import cn.com.taiji.config.ConfigContext;
import cn.com.taiji.config.ConfigContext2;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import cn.com.taiji.pojo.Person;

/**
 * @author fengliqiang
 * @date 2019/03/20/4:46 PM
 **/
public class AnnotationTest {
    private ApplicationContext applicationContext;

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
    }

    @Test
    public void testCompScan(){
        String[] benaName = applicationContext.getBeanDefinitionNames();
        for (String s : benaName) {
            System.out.println(s);
        }
    }
}
