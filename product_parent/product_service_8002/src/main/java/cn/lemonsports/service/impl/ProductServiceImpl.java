package cn.lemonsports.service.impl;

import cn.lemonsports.domain.Product;
import cn.lemonsports.mapper.ProductMapper;
import cn.lemonsports.service.IProductService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品 服务实现类
 * </p>
 *
 * @author zmltest
 * @since 2019-01-15
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
