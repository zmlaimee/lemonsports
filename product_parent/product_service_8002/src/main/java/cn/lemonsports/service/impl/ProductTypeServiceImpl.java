package cn.lemonsports.service.impl;

import cn.lemonsports.IRedisCache;
import cn.lemonsports.domain.Product;
import cn.lemonsports.domain.ProductType;
import cn.lemonsports.mapper.ProductTypeMapper;
import cn.lemonsports.service.IProductTypeService;
import cn.lemonsports.domain.ProductType;
import cn.lemonsports.mapper.ProductTypeMapper;
import cn.lemonsports.service.IProductTypeService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**加入缓存，页面静态化
 * <p>
 * 商品目录 服务实现类
 * </p>
 *
 * @author yhptest
 * @since 2019-01-13
 */
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements IProductTypeService {

    @Resource
    private ProductTypeMapper productTypeMapper;
    @Autowired
    //注入common_cache_parent设计的接口IRedisCache
    private IRedisCache iRedisCache;
    @Override
    public boolean insert(ProductType entity) {
        iRedisCache.set("productType_redis", "");
        return super.insert(entity);
    }

    @Override
    public boolean deleteById(Serializable id) {
        iRedisCache.set("productType_redis", "");
        return super.deleteById(id);
    }

    @Override
    public boolean updateById(ProductType entity) {
        iRedisCache.set("productType_redis", "");
        return super.updateById(entity);
    }

    /**
     * 查询所有商品类型得到菜单树
     * @return
     */
    @Override
    public List<ProductType> treeData()
    {

        // 1 递归方案效率低,要发多次sql
        //return getTreeDataRecursion(0L);
        String productType_redis = iRedisCache.get("productType_redis");
        if (StringUtils.isNotEmpty(productType_redis)){
            //如果存在缓存,就直接将缓存数据返回
            return JSONArray.parseArray(productType_redis,ProductType.class );
        }else {//不存在缓存就查数据库，然后将其放入缓存中
            // 2 循环方案,只需发一条sql
            List<ProductType> treeDataLoop = getTreeDataLoop(0L);
            iRedisCache.set(productType_redis,JSONArray.toJSONString(treeDataLoop, SerializerFeature.WriteMapNullValue) );
            return treeDataLoop;
        }
    }
    //方案2：
    private List<ProductType> getTreeDataLoop(long l) {
        //返回数据 一级类型,下面挂了子子孙孙类型
        List<ProductType> result = new ArrayList<>();
        //1 获取所有的商品类型
        List<ProductType> productTypes = productTypeMapper.selectList(null);
        //2)遍历所有的类型
        Map<Long,ProductType> productTypesDto = new HashMap<>();
        //将所有商品key=id,value=ProductType的形式存入map集合中，方便获取
        for (ProductType productType : productTypes) {
            productTypesDto.put(productType.getId(), productType);
        }
        for (ProductType productType : productTypes) {
            Long pid = productType.getPid();
            // ①如果没有父亲就是一级类型 放入返回列表中
            if (pid.longValue() == 0){
                result.add(productType);
            }else{
                // ②如果有父亲就是把自己当做一个儿子就ok
                //方案1:遍历比较所有所有里面获取 两层for 10*10
//                for (ProductType productTypeTmp : productTypes) { 1 10 2 10 310 40 10
//                    if (productTypeTmp.getId()==pid){
//                        productTypeTmp.getChildren().add(productType);
//                    }
//                }
                //方案2:通过Map建立id和类型关系,以后通过pid直接获取父亲 10+10
                ProductType parent = productTypesDto.get(pid);
                parent.getChildren().add(productType);
            }

        }
        return result;
    }

    /**
     * 递归获取无限极数据
     *    ①自己调用自己
     *    ②要有出口
     * @return
     */
    private List<ProductType> getTreeDataRecursion(Long id) {

        //得到pid=0的商品类型
        List<ProductType> children = getAllChildren(id); //
        //出口
        if (children == null || children.size()<1){
            return null;
        }
        for (ProductType productType : children) {
            //1 3 4 自己调用自己
            List<ProductType> children1 = getTreeDataRecursion(productType.getId());
            productType.setChildren(children1);
        }
        return children;

    }
    //查询pid（父id）商品类型
    private List<ProductType> getAllChildren(Long pid){
        Wrapper wrapper = new EntityWrapper<ProductType>();
        wrapper.eq("pid", pid);
        return productTypeMapper.selectList(wrapper);
    }

}
