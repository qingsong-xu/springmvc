# springmvc
springmvc

1、什么是springmvc
1.1、spring的框架图
springmvc是spring框架的一个模块。springmvc和spring无需通过中间层进行整合。
springmvc是一个基于mvc的一个web框架。

1.2、什么是mvc
mvc是一个设计模式。mvc在B/S系统下的应用。c= controller控制器,接受用户请求、请求model模型进行处理后，响应结果给用户（将模型数据填充到request域，响应到view视图），m = model模型（pojo、action、service、dao）。
B\S系统下的不同：model是无法直接填充到view视图的。必须经过controller控制器


2、springmvc框架原理

（用户）request->dispatcherServerlet-> 处理器映射器，请求查找handler，请求执行handlerAdapter适配器->handler处理器（controller）->返回ModelAndView到适配器，由handlerAdapter适配器返回ModelAndView->由视图解析器去进行视图解析，最终返回一个真正的物理视图：view - jsp、freemarker、pdf、excel


第一步：发起请到前端控制器(dispatchServlet)
第二步：前端控制器请求HandlerMapping查找handler，可以根据xml配置、注解进行查找
第三步：处理器映射器HandlerMapping向前端控制器返回Handler
第四步：前端控制器调用处理器适配器handlerAdapter去执行handler
第五步：处理器适配器去执行handler
第六步：handler执行完后返回ModelAndView到处理器适配器
第七步：处理器适配器向前端控制器返回modelAndView，modelAndView是springmvc的底层对象，包括model和view。
第八步：前端控制器请求视图解析器去进行视图解析，根据逻辑视图名解析成真正的视图jsp
第九步：视图解析器向前端控制器返回view
第十步：前端控制器进行视图渲染
视图渲染将模型数据（在
ModelAndView对象中）填充到request域
第十一步：前端控制器向用户响应结果

组件：（1）前端控制器DispatcherServlet，作用接收请求，响应结果，相当于转发器,中央处理器。有了DispatcherServlet减少了其他组件之间的耦合度
（2）处理器映射器HandlerMapping，作用：根据请求的URL查找handler
（3）处理器适配器HandlerAdapter，作用：按照特定规则（HandlerAdapter要求的规则）去执行Handler
注意：编写Handler时按照HandlerAdapter的要求去做，这样适配器才可以去正确执行Handler
（4）视图解析器View resolver，作用进行视图解析，根据逻辑视图名解析成真正的视图（view）
（5）视图View,View是一个接口，实现类支持不同的View类型（jsp、freemarker、pdf...）

## 3、springmvc入门程序
目的：对前端控制器、处理器映射器、处理器适配器、视图解析器学习
非注解的处理器映射器、处理器适配器
注解的处理器映射器、处理器(掌握)
spring和mybatis入门程序，以案例“商品订单的管理为例”。

### 3.1 非注解的映射器
org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping
org.springframework.web.servlet.handler.SimpleUrlHandlerMapping


### 3.2 注解映射器
在3.1之前,使用org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping注解映射器

在3.1及之后，使用 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping注解映射器

### 3.3注解适配器
在3.1之前,使用org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter注解适配器

在3.1及之后，使用 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter注解适配器


## springmvc和mybatis整合（掌握）
常用的注解学习
参数绑定（简单类型、pojo、集合类型）
自定义参数绑定（掌握）

```
spring将各层进行整合，通过spring管理持久层的mapper(相当于dao接口)

通过spring管理业务层service，service中可以调用mapper接口。

通过spring管理表现层handler，handler中可以调用service接口。

mapper、service、handler都是java bean.

同时spring进行事务控制。
```
第一步：整合dao层。
mybatis和spring整合，通过spring管理mapper接口。
使用mapper的扫描自动扫描mapper接口在spring中进行注册

第二步：整理service层
通过spring管理sverice接口。
使用配置方式将service接口配置在spring配置文件中。
实现事务控制。

第三步：整合springmvc
由于springmvc是spring的模块，不需要整合

![image.png](/doc/imgs/001.pnggit )

springmvc和struts2区别



4、spring的高级应用
参数绑定（集合类型）

数据回显

上传图片
