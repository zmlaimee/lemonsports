package cn.lemonsports.service.impl;

import cn.lemonsports.domain.User;
import cn.lemonsports.mapper.UserMapper;
import cn.lemonsports.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zmltest
 * @since 2019-01-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
