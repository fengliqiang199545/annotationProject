package cn.com.taiji.condition;


import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author fengliqiang
 * @date 2019/03/21/4:37 PM
 **/
public class WindowsCon implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //能够获取到IOC容器额Beanfactory
        ConfigurableListableBeanFactory factory =context.getBeanFactory();
        //获取到类加载器
        ClassLoader classLoader = context.getClassLoader();
        //获取运行时环境
        Environment environment = context.getEnvironment();

        String property =  environment.getProperty("os.name");
        if (property.contains("Windows")){
            return true;
        }

        return false;
    }
}
