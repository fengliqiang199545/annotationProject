import cn.com.taiji.config.ConfigContext;
import cn.com.taiji.config.ConfigContext2;
import cn.com.taiji.config.ConfigOfLifeCycle;
import cn.com.taiji.pojo.Car;
import cn.com.taiji.pojo.PersonFactory;
import com.sun.tracing.ProbeName;
import jdk.internal.org.objectweb.asm.Handle;
import jdk.nashorn.internal.runtime.ECMAException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import cn.com.taiji.pojo.Person;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fengliqiang
 * @date 2019/03/20/4:46 PM
 **/
public class AnnotationTest {
    private ApplicationContext applicationContext;

    public void printBean(){
        String[] beanName =  applicationContext.getBeanDefinitionNames();
        for (String s : beanName) {
            System.out.println(s);
        }
    }

    @Before
    public void setup(){
        System.out.println("IOC容器创建完成");
        applicationContext = new AnnotationConfigApplicationContext(ConfigContext2.class);

    }

    @Test
    public void testBean(){
        Person person = (Person)applicationContext.getBean("person");
        System.out.println(person);
    }
    @Test
    public void testBean2(){
//        Person person = (Person)applicationContext.getBean("person");
//        Person person2 = (Person)applicationContext.getBean("person");
//        System.out.println(person==person2);

        String[] beans = applicationContext.getBeanNamesForType(Person.class);

        for (String bean : beans) {
            System.out.println(bean);
        }

        Map<String ,Object> beanMap = new HashMap<>();
        for (String bean : beans) {
            beanMap.put(bean,(Person)applicationContext.getBean(bean));


        }

        for (Object value : beanMap.values()) {
            System.out.println(value);
        }
    }

    @Test
    public void testCompScan(){
        String[] benaName = applicationContext.getBeanDefinitionNames();
        for (String s : benaName) {
            System.out.println(s);
        }
    }

    @Test
    public void testEnv(){
        Environment environment =  applicationContext.getEnvironment();
        environment.getProperty("os.name");
        System.out.println(environment.getProperty("os.name"));
    }

    @Test
    public void testImport(){
        printBean();
    }

    @Test
    public void testFactory() throws Exception{

        PersonFactory factory = (PersonFactory) applicationContext.getBean("&getPF");

        Person person =  factory.getObject();
        Person person2 =  factory.getObject();
        Person person1 =  factory.getObject();
        System.out.println(person == person1);
    }

    @Test
    public void testLifeCycle(){
        applicationContext = new AnnotationConfigApplicationContext(ConfigOfLifeCycle.class);

        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car);


        //关闭容器
        ((ConfigurableApplicationContext)applicationContext).close();
    }
}


