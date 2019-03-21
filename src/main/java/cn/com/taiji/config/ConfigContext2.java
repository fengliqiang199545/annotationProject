package cn.com.taiji.config;

import cn.com.taiji.condition.LinuxCon;
import cn.com.taiji.condition.WindowsCon;
import cn.com.taiji.dao.BookDao;
import cn.com.taiji.pojo.Color;
import cn.com.taiji.pojo.Person;
import cn.com.taiji.pojo.PersonFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * @author fengliqiang
 * @date 2019/03/20/4:40 PM
 **/


@Configuration
@Import({Color.class})
public class ConfigContext2 {
//    @Scope("prototype")
    @Lazy
    @Bean
    public Person person(){
        System.out.println("Config Context 2");
        return new Person(12,"fengliqiang");
    }

    @Conditional({WindowsCon.class})
    @Bean("windows")
    public Person person2(){
        System.out.println("Creating Bean person2!!");
        return new Person(11,"windows");
    }
    @Conditional({LinuxCon.class})
    @Bean("linux")
    public Person person3(){
        System.out.println("Creating Bean person3!!");
        return new Person(11,"linux");
    }

    @Bean
    public PersonFactory getPF(){
        return  new PersonFactory();
    }

    /*
    *   给Spring容器中注册组件
    *   1.包扫描+组件注解标注【自己写的类】
    *   2.通过@bean 手动导入【通常是第三方的里面的组件】
    *   3.@Import 【快速给容器中注册组件】
    *   4.使用Spring提供的factoryBean
    * */

}
