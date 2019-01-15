package cn.lemonsports.service.impl;

import cn.lemonsports.domain.Brand;
import cn.lemonsports.mapper.BrandMapper;
import cn.lemonsports.query.BrandQuery;
import cn.lemonsports.service.IBrandService;
import cn.lemonsports.util.PageList;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 品牌信息 服务实现类
 * </p>
 *
 * @author zmltest
 * @since 2019-01-15
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {
 @Autowired
 private BrandMapper brandMapper;
    @Override
    public PageList<Brand> selectPageList(BrandQuery query) {
        Page<Brand> page=new Page<>(query.getPage(),query.getRows());//query.getPage()当前页，query.getRows()每页显示的数据条数
        //当我们传入Page,表示要做分页查询,会把查询总数设置在Page的total
        List<Brand> rows = brandMapper.selectPageList(page,query);
        //PageList total,rows
        long total = page.getTotal();
        return new PageList<Brand>(total,rows);
    }
}
