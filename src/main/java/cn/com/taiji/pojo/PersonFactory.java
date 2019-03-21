package cn.com.taiji.pojo;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author fengliqiang
 * @date 2019/03/21/5:23 PM
 **/
public class PersonFactory implements FactoryBean<Person> {

    @Override
    public Person getObject() throws Exception {

        System.out.println("Factory create Person Bean!!");
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
