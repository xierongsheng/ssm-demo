package com.backoffice.web.controller;

import com.backoffice.model.Items;
import com.backoffice.service.IItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("items")
public class ItemsController {

    @Autowired
    private IItemsService itemsService;

    @RequestMapping("list")
    public String list(Model model){
        //1.查数据
        List<Items> itemsList = itemsService.findAllItems();

        //2.存数据
        model.addAttribute("itemsList",itemsList);
        return "items/list";
    }

    @RequestMapping("save")
    public String save(){
        //创建商品
        Items items = new Items();
        items.setName("iphone11");
        items.setPrice(7999.00F);
        items.setCreatetime(new Date());
        items.setDetail("666好用");

        //保存数据
        itemsService.saveOrUpdate(items);

        return "items/list";
    }

    @RequestMapping("delete")
    public String delete(Integer id, Model model){
        //保存数据
        itemsService.deleteById(id);
        return "forward:list.do";
    }

    @RequestMapping("update")
    public String update(Items items, Model model){
        System.out.println(items);

        //设置时间
        items.setCreatetime(new Date());
        itemsService.saveOrUpdate(items);

        return "forward:list.do";
    }

    @RequestMapping("edit")
    public String edit(Integer id, Model model){

        System.out.println("id:" + id);
        //通过id找到商品
        Items items = itemsService.findById(id);
        System.out.println(items);
        if (items != null){
            model.addAttribute("items",items);
        }
        return "items/edit";
    }


    @RequestMapping("hello")
    public String hello(Model model){
        model.addAttribute("myname","Java Go Go Go!");
        return "items/hello";

    }

}
