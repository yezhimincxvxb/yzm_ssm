import com.yzm4.config.SpringConfig;
import com.yzm4.proxy.DynamicProxyHandler;
import com.yzm4.proxy.ProxyCglib;
import com.yzm4.service.AccountService;
import com.yzm4.aop.UserAop;
import com.yzm4.service.UserService;
import com.yzm4.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Proxy;

public class SpringTest {

    @Test
    public void test1() {
        // 代理UserServiceImpl类
        UserService userService = (UserService) Proxy.newProxyInstance(
                DynamicProxyHandler.class.getClassLoader(),
                UserServiceImpl.class.getInterfaces(),
                new DynamicProxyHandler(new UserServiceImpl()));
        userService.login("admin", "123456");
    }

    @Test
    public void test2() {
        // 代理AccountService类
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(ProxyCglib.class.getClassLoader());
        enhancer.setSuperclass(AccountService.class);
        enhancer.setCallback(new ProxyCglib(new AccountService()));
        AccountService accountService = (AccountService) enhancer.create();
        accountService.transfer("小明", "小马");
    }

    @Test
    public void test3() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserAop userAop = applicationContext.getBean("userAop", UserAop.class);
        userAop.add("张三");
    }

    @Test
    public void test4() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserAop userAop = applicationContext.getBean("userAop", UserAop.class);
        userAop.edit("张三");
    }
}
