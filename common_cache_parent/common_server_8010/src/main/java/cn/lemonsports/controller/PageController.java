package cn.lemonsports.controller;

import cn.lemonsports.PageClient;
import cn.lemonsports.utils.VelocityUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 页面静态
 */
@RestController
public class PageController implements PageClient {
    @Override
    @RequestMapping(value = "/page",method = RequestMethod.POST)
    public  void genStaticPage(@RequestBody Map<String,Object> params){
        // model 数据
        Object model = params.get("model");
        // tmeplatePath==xxx
       String tmeplatePath = (String) params.get("tmeplatePath");
       //  staticPagePath = xxx
        String staticPagePath = (String) params.get("staticPagePath");
        System.out.println(model);
        System.out.println(tmeplatePath);
        System.out.println(staticPagePath);
        VelocityUtils.staticByTemplate(model, tmeplatePath,
                staticPagePath);
    }
}
