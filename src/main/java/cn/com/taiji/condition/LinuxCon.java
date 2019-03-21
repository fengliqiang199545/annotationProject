package cn.com.taiji.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author fengliqiang
 * @date 2019/03/21/4:37 PM
 **/
public class LinuxCon implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//获取运行时环境
        Environment environment = context.getEnvironment();

        String property =  environment.getProperty("os.name");
        if (property.contains("linux")){
            return true;
        }
        return false;
    }
}
