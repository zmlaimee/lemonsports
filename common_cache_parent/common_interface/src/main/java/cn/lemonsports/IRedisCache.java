package cn.lemonsports;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * redis做集群缓存:common_cache_interface是公共模块
 */
@FeignClient(value = "LOVEBUY-COMMON",fallbackFactory = RedisClientFallbackFactory.class )
public interface IRedisCache {

    @RequestMapping(value = "/redis",method = RequestMethod.POST)
    void set(@RequestParam("key")String key, @RequestParam("value")String value);//添加缓存数据

    @RequestMapping(value = "/redis",method = RequestMethod.GET)
    String get(@RequestParam("key")String key);//获取缓存数据
}
