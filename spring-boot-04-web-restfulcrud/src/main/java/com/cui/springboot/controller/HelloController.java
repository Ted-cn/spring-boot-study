package com.cui.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * 使用thymeleaf
 * 1. 导入thymeleaf的名称空间
 *     xmlns:th="http://www.thymeleaf.org"
 * 2. 使用thymeleaf的语法
 *     <div th:text="${hello}">这是显示欢迎信息</div>
 * 3. 语法规则
 *     1）<th:任意html属性>：替换原属性的值
 *     2）
 *         i. ${...} 变量表达式
 *         ii. *{...} 选择变量表达式，类似${...}，多一个<th:object=${session.user}>
 *         iii. #{...} 获取国际化内容
 *         iiii. @{...} 定义URL
 *         iiiii. ~{...} 片段引用表达式
 *     3）
 *
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello World!";
    }


    @RequestMapping(value = "success")
    public String success(Map<String, Object> map) {
        map.put("hello", "<h1>你好！</h1>");
        map.put("users", Arrays.asList("Tom", "Jerry", "Spark"));
        return "success";
    }
}
