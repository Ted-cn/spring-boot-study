package com.cui.springboot02config;

import com.cui.springboot02config.bean.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02ConfigApplicationTests {
    @Resource
    private Person person;
    @Autowired
    private ApplicationContext ac;

    @Test
    public void contextLoads() {
        System.out.println(ac);
        System.out.println(ac.containsBean("helloService"));
    }

}
