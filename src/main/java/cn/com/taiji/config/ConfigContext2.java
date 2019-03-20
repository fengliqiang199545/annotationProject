package cn.com.taiji.config;

import cn.com.taiji.dao.BookDao;
import cn.com.taiji.pojo.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * @author fengliqiang
 * @date 2019/03/20/4:40 PM
 **/
@Configuration
/*
*
* */

public class ConfigContext2 {
//    @Scope("prototype")
    @Lazy
    @Bean
    public Person person(){
        System.out.println("Config Context 2");
        return new Person(12,"fengliqiang");
    }


}
