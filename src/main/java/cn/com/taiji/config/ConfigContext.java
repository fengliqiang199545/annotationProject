package cn.com.taiji.config;

import cn.com.taiji.dao.BookDao;
import cn.com.taiji.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author fengliqiang
 * @date 2019/03/20/4:40 PM
 **/
@Configuration
@ComponentScan(value = "cn.com.taiji" ,
        includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = BookDao.class)
},useDefaultFilters = false)
public class ConfigContext {
    @Bean
    public Person person(){
        return new Person(1,"fengliqiang");
    }


}
