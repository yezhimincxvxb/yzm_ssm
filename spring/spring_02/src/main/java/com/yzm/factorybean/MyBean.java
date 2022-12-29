package com.yzm.factorybean;

import com.yzm.entity.User;
import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

@Data
public class MyBean implements FactoryBean<User> {

    private String beanName = "工厂bean";

    @Override
    public User getObject() throws Exception {
        return User.builder().userid(11).username("Yzm").build();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
