package cn.com.taiji.config;

import cn.com.taiji.pojo.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fengliqiang
 * @date 2019/03/21/5:36 PM
 **/
/*
*   Bean的生命周期： 创建--初始化--销毁
*   容器管理Bean的创建，而我们可以人为地对Bean进行初始化和销毁
*   初始化方法： init-method
*   销毁方法： destroy-method
* */


@Configuration
public class ConfigOfLifeCycle {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }
}
