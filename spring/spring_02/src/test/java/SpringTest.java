import com.yzm.autowire.Emp;
import com.yzm.entity.Book;
import com.yzm.entity.User;
import com.yzm.factorybean.MyBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        // id=myBean注册的bean是工厂bean里面getObject的返回类型
        User user = applicationContext.getBean("myBean", User.class);
        System.out.println("user = " + user);

        // 获取原始工厂bean需通过id值加上 &
        MyBean myBean = applicationContext.getBean("&myBean", MyBean.class);
        System.out.println("myBean = " + myBean);
    }

    /**
     * Bean 的作用域
     */
    @Test
    public void test2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        Book book = applicationContext.getBean("book", Book.class);
        Book book2 = applicationContext.getBean("book", Book.class);
        // 查看地址值或==比较
        System.out.println("book = " + book);
        System.out.println("book2 = " + book2);
    }

    /**
     * 基于XML的自动装配
     */
    @Test
    public void test3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        Emp emp = applicationContext.getBean("emp", Emp.class);
        Emp emp2 = applicationContext.getBean("emp2", Emp.class);

        System.out.println("emp = " + emp);
        System.out.println("emp2 = " + emp2);
    }

}
