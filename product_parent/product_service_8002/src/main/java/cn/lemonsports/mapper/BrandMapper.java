package cn.lemonsports.mapper;

import cn.lemonsports.domain.Brand;
import cn.lemonsports.query.BrandQuery;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 * <p>
 * 品牌信息 Mapper 接口
 * </p>
 *
 * @author zmltest
 * @since 2019-01-15
 */
public interface BrandMapper extends BaseMapper<Brand> {

    List<Brand> selectPageList(Page<Brand> page, BrandQuery query);
}
