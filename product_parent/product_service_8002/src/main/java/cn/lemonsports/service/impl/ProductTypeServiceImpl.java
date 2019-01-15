package cn.lemonsports.service.impl;

import cn.lemonsports.domain.ProductType;
import cn.lemonsports.mapper.ProductTypeMapper;
import cn.lemonsports.service.IProductTypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品目录 服务实现类
 * </p>
 *
 * @author zmltest
 * @since 2019-01-15
 */
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements IProductTypeService {

    @Override
    public List<ProductType> treeData() {

        return null;
    }
}
