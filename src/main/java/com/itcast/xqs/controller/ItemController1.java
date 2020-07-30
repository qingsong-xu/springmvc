package com.itcast.xqs.controller;

import com.itcast.xqs.po.Item;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import java.util.ArrayList;
import java.util.List;

public class ItemController1 implements Controller {
    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        //调用service查询数据库，查询商品列表，这里使用静态数据模拟
        List<Item> list = new ArrayList<>();
        //向list中填充静态数据
        Item item1 = new Item();
        item1.setId("001");
        item1.setName("联想电脑");
        item1.setPrice(600);
        item1.setDescription("ThinkPad T430联想笔记本电脑");

        Item item2 = new Item();
        item2.setId("002");
        item2.setName("苹果手机");
        item2.setPrice(3600);
        item2.setDescription("苹果手机就是贵，就是好用");

        list.add(item1);
        list.add(item2);

        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //相当于request的setAttribute,在jsp页面中通过itemList取数据
        modelAndView.addObject("itemList", list);
        //指定视图
        modelAndView.setViewName("/items/itemsList.jsp");
        return modelAndView;
    }
}
