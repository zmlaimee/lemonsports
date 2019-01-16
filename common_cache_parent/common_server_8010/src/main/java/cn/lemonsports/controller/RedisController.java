package cn.lemonsports.controller;

import cn.lemonsports.utils.RedisUtils;
import cn.lemonsports.IRedisCache;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//Feign实现的断路器负载均衡：内部调用缓存，使用时记得启动redis服务器
@RestController
public class RedisController implements IRedisCache {

    @RequestMapping(value = "/redis",method = RequestMethod.POST)
    @Override
    public void set(@RequestParam("key")String key, @RequestParam("value")String value) {
        RedisUtils.INSTANCE.set(key, value);
    }
    @RequestMapping(value = "/redis",method = RequestMethod.GET)
    @Override
    public String get(@RequestParam("key")String key) {
        return RedisUtils.INSTANCE.get(key);
    }
}
