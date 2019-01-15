package cn.lemonsports.service;

import cn.lemonsports.domain.Brand;
import cn.lemonsports.query.BrandQuery;
import cn.lemonsports.util.PageList;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 品牌信息 服务类
 * </p>
 *
 * @author zmltest
 * @since 2019-01-15
 */
public interface IBrandService extends IService<Brand> {
//分页+连表查询
    PageList<Brand> selectPageList(BrandQuery query);
}
