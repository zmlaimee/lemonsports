package cn.lemonsports.controller;

import cn.lemonsports.service.IBrandService;
import cn.lemonsports.domain.Brand;
import cn.lemonsports.query.BrandQuery;
import cn.lemonsports.util.AjaxResult;
import cn.lemonsports.util.PageList;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    public IBrandService brandService;

    /**
    * 保存和修改公用的
    * @param brand  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Brand brand){
        try {
            if(brand.getId()!=null){
                brandService.updateById(brand);
            }else{
                brandService.insert(brand);
            }
            return AjaxResult.getAjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.getAjaxResult().setMessage("保存对象失败！"+e.getMessage());
        }
    }

    /**
    * 删除对象信息
    * @param id
    * @return
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id")Long id){
        try {
            brandService.deleteById(id);
            return AjaxResult.getAjaxResult();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.getAjaxResult().setMessage("删除失败！"+e.getMessage());
        }
    }
    @RequestMapping(value="/idsjson/{ids}",method=RequestMethod.DELETE)
    public AjaxResult deleteAll(@PathVariable("ids") String ids){//接收前端传来的多个id字符串（数组形式的字符串）
        try {//@PathVariable("ids") String ids是restful风格传参
            String[] split = ids.split(",");//拆分字符串以逗号分隔拆分为数组
            //brandService.deleteById(id);
            brandService.deleteBatchIds(Arrays.asList(split));//直接传入数组
            return AjaxResult.getAjaxResult();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.getAjaxResult().setMessage("删除失败！"+e.getMessage());
        }
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Brand get(@PathVariable("id")Long id)
    {
        return brandService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Brand> list(){

        return brandService.selectList(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    public PageList<Brand> json(@RequestBody BrandQuery query)
    {//@RequestBody BrandQuery query是json格式的对象传参
        return brandService.selectPageList(query);
//        Page<Brand> page = new Page<Brand>(query.getPage(),query.getRows());
//            page = brandService.selectPage(page);
//            return new PageList<Brand>(page.getTotal(),page.getRecords());
    }
}
