package cn.lemonsports;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
//托底函数
@Component//hfffffffffffhxc
public class PageClientFallbackFactory implements FallbackFactory<PageClient> {
    @Override
    public PageClient create(Throwable throwable) {
        return new PageClient() {
            @Override
            public void genStaticPage(Map<String, Object> params) {
                System.out.println("....");
            }
        };
    }
}
