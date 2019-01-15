package cn.lemonsports.service.impl;

import cn.lemonsports.domain.Brand;
import cn.lemonsports.mapper.BrandMapper;
import cn.lemonsports.service.IBrandService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
