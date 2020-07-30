package com.itcast.xqs.controller;

import com.itcast.xqs.po.Item;
import org.springframework.lang.Nullable;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ItemController2 implements HttpRequestHandler {

    @Nullable
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
//        ModelAndView modelAndView = new ModelAndView();
        //相当于request的setAttribute,在jsp页面中通过itemList取数据
        request.setAttribute("itemList", list);
//        modelAndView.addObject("itemList", list);
        //指定视图
        //使用此方法可以修改定义response,设置响应的格式，比如响应json数据
        response.setCharacterEncoding("utf-8");
        response.setContentType("appliation/json;charset=utf-8");
        response.getWriter().write("json串");

        request.getRequestDispatcher("/items/itemsList1.jsp").forward(request, response);
    }
}
