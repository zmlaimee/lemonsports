package cn.lemonsports.controller;

import cn.lemonsports.domain.Employee;
import cn.lemonsports.util.AjaxResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plat")
public class PlatApplicationController {
    //登录入口
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public AjaxResult login(@RequestBody Employee employee){
        if ("zhang".equals(employee.getName())&&"123"==employee.getPassword()){
            return AjaxResult.getAjaxResult();
        }
        return AjaxResult.getAjaxResult().setSuccess(false).setMessage("用户名或密码错误！").setObject("出错啦！");
    }
    @RequestMapping("/employee")
    public Employee getEmployee(){
        return new Employee("zhang","123");
    }
}
