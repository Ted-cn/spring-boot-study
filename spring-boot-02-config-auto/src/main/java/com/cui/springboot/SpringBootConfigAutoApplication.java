package com.cui.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * EnableAutoConfiguration
 * 配置文件能配置的属性参照：
 * https://docs.spring.io/spring-boot/docs/2.2.1.RELEASE/reference/htmlsingle/common-application-properties
 *
 * 自动配置原理：
 * 1. SpringBoot启动的时候加载主配置类，开户了自动配置功能@EnableAutoConfiguration
 * 2. @EnableAutoConfiguration的作用：
 *    1）利用EnableAutoConfigurationImportSelector给容器中导入一些组件
 *    2）可以查看selectImports()（org.springframework.boot.autoconfigure.AutoConfigurationImportSelector）方法的内容
 *    3）获取候选的配置List<String> configurations = getCandidateConfigurations(annotationMetadata, attributes);
 *        i. List<String> configurations = SpringFactoriesLoader.loadFactoryNames(getSpringFactoriesLoaderFactoryClass(), getBeanClassLoader());
 *        ii. 扫描所有jar包类路径下"META-INF/spring.factories"文件
 *        iii. 把扫描到的这些文件的内容包装成properties对象
 *        iiii. 从properties中获取到EnableAutoConfiguration.class类（类名）对应的值，然后把他们添加在容器中
 *        iiiii. 每个这样的xxxAutoConfiguration类都是容器中的一个组件，都加入到容器中，用他们来做自动配置。
 *  3. 每一个自动配置类进行自动配置功能；
 *  4. 以HttpEncodingAutoConfiguration为例解释自动配置原理：
 *      @Configuration  // 表示这是一个配置类，给容器中添加组件
 *      @EnableConfigurationProperties(HttpEncodingProperties.class)  // 启动指定类
 *          @ConfigurationProperties  // 将配置文件中对应的值和HttpEncodingProperties.class绑定起来
 *      @ConditionalOnWebApplication  // web应用时才生效
 *      @ConditionalOnClass(CharacterEncodingFilter.class)  // 有这个类里才生效
 *      @ConditionalOnProperty(prefix = "spring.http.encoding", value = "enabled", matchIfMissing = true)
 *      // 配置文件中是否存在spring.http.encoding.enabled属性，如果没有，就是true
 *      public class HttpEncodingAutoConfiguration {
 *
 * 	    private final HttpEncodingProperties properties;
 *
 * 	    public HttpEncodingAutoConfiguration(HttpEncodingProperties properties) {
 * 		    this.properties = properties;
 * 	    }
 *
 * 	    @Bean
 * 	    @ConditionalOnMissingBean(CharacterEncodingFilter.class)
 * 	    public CharacterEncodingFilter characterEncodingFilter() {
 * 		    CharacterEncodingFilter filter = new OrderedCharacterEncodingFilter();
 * 		    filter.setEncoding(this.properties.getCharset().name());
 * 		    filter.setForceRequestEncoding(this.properties.shouldForce(Type.REQUEST));
 * 		    filter.setForceResponseEncoding(this.properties.shouldForce(Type.RESPONSE));
 * 		    return filter;
 * 	    }
 *      1）根据当前不同的条件判断，决定这个配置类是否生效？
 *      2）一旦这个配置类生效；这个配置类就会给容器中添加各种组件；这些组件的属性是从对应的properties类中获取的，
 *      这些类里面的每一个属性又是和配置文件绑定的。
 *  5. 所有在配置文件中能配置的属性都是在xxxxProperties类中封装着；配置文件能配置什么，就可以参数某个功能对应的这个属性类。
 * 
 *  精髓：
 *  1. SpringBoot启动会加载大量的自动配置类
 *  2. 看我们需要的功能，是不是SpringBoot默认写好的自动配置类
 *  3. 我们再来看这个自动配置类中到底配置了哪些组件
 *  4. 给容器中自动配置类添加组件的时候，会从properties类中获取某些属性。我们就可以在配置文件中指定这些属性的值。
 *
 *  xxxxAutoConfiguration：自动配置类
 *  给容器中添加组件
 *  xxxxProperties：封闭配置文件中相关属性
 */
@SpringBootApplication
public class SpringBootConfigAutoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConfigAutoApplication.class, args);
    }
}























