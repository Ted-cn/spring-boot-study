package com.cui.springboot02config.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ConfigurationProperties 告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定；
 *     prefix = "person"：配置文件中的key
 * 只有这个组件是容器中的组件时，才能使用@ConfigurationProperties注解
 *
 * @PropertySource 加载指定的配置文件。
 * @ImportSource 导入spring的配置文件。
 */
@ConfigurationProperties(prefix = "person")
@PropertySource(value = {"classpath:person.properties"})
@Component
public class Person {

    private String lastName;
    private Integer age;
    private Boolean boss;
    private Date birth;

    private Map<String, Object> map;
    private List<String> list;
    private Dog dog;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", map=" + map +
                ", list=" + list +
                ", dog=" + dog +
                '}';
    }
}
