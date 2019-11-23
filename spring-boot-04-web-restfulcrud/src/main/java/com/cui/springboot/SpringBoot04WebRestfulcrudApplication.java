package com.cui.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot对静态资源的映射规则：
 * 1. 所有/webjars/**，都去classpath:/META-INF/resources/webjars/找资源
 *     webjars：以jar包的方式引入静态资源
 *     官网：https://www.webjars.com
 *     访问方式：http://localhost:8080/webjars/jquery/3.4.1/jquery.js
 * 2. /**访问当前项目的任何资源（静态资源文件夹）
 *     1）classpath:/META-INF/resources/
 *     2）classpath:/resources/
 *     3）classpath:/static/
 *     4）classpath:/public/
 *     5）/:当前项目的根路径
 *     访问方式：http://localhost:8080/asserts/js/Chart.min.js
 * 3. 欢迎页：静态资源文件夹下的所有index.html页面；被/**映射
 * 4. 所有的 ** /favicon.ico都是在静态资源文件下找；
 */
@SpringBootApplication
public class SpringBoot04WebRestfulcrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot04WebRestfulcrudApplication.class, args);
    }

}
