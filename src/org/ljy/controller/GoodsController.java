package org.ljy.controller;

import org.ljy.domain.Goods;
import org.ljy.service.GoodsService;
import org.ljy.util.AjaxUtil;
import org.ljy.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @RequestMapping("/goods/addGoods")
    @ResponseBody
    public Map<String,String> addGoods(Goods goods){
        Map<String,String> ajaxMap = AjaxUtil.createDefaultAjaxMap();
        if(goods != null && !StringUtil.isEmpty(goods.getGoodsName())){
            int flag = goodsService.insertSelective(goods);
            if(flag > 0){
                ajaxMap.put("status","1");
                ajaxMap.put("msg","添加成功");
            }
        }else{
            ajaxMap.put("status","0");
            ajaxMap.put("msg","添加失败");
        }
        return ajaxMap;
    }
}
