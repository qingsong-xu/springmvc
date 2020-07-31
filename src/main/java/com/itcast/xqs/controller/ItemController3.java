package com.itcast.xqs.controller;

import com.itcast.xqs.po.Item;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * ItemController3采用注解来实现，通过Controller来标识这是一个handler类，org.springframework.stereotype.Controller;
 * 同时可以定义多个不同的url映射方法
 */
@Controller
public class ItemController3 {

    private static Logger log = Logger.getLogger(ItemController3.class.getClass());

    /**
     * 通过RequestMapping配置url映射，这样可以配置多个方法对应不同的映射，而不用在配置文件中配置，简化了很多，
     * 同时在配置文件中配置组件时，为了方便直接使用组件扫描器扫描，不同一个一个bean的去进行配置
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/queryItems4.action")
    public ModelAndView queryAllItem() throws Exception {
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
        modelAndView.setViewName("/items/itemsList1");


        log.debug("debug");
        log.error("error");
        //指定视图
        return modelAndView;
    }
}
