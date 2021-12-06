package com.cui;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot优点：
 * 1. 快速创建独立运行的Spring项目以及与主流框架集成
 * 2. 使用嵌入式的Servlet容器，应用无需打成war包
 * 3. starters自动依赖与版本控制
 * 4. 大量的自动配置，简化开发，也可修改默认值
 * 5. 无需配置XML，无代码生成，开箱即用
 * 6. 准生产环境的运行时应用监控
 * 7. 与云计算天然集成
 */

/**
 * @SpringBootApplication 标注在某个类上，说明这个类是SpringBoot的主配置类，
 *                        SpringBoot就应该运行这个类的main方法来启动SpringBoot应用。
 *
 *     @SpringBootConfiguration 标注在某个类上，表示这是一个SpringBoot的配置类。
 *         @Configuration Spring定义，用来标注配置类
 *             @Component Spring定义，用来标注组件
 *
 *     @EnableAutoConfiguration 开启自动配置功能。
 *         @AutoConfigurationPackage 自动配置包
 *             @Import(AutoConfigurationPackages.Registrar.class) 给容器中导入组件，组件由Registrar定义。通过断点Registrar类的registerBeanDefinitions方法的方式，
 *                                                                发现是将主配置类（即@SpringBootApplication标注的类）所在包以及下面所有子包里面的所有组件扫描到
 *                                                                 Spring容器中。
 *
 *     @AutoConfigurationPackage
 */
@SpringBootApplication
public class HelloWorldMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldMainApplication.class, args);
    }
}
