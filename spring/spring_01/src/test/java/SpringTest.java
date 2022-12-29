import com.yzm.entity.Book;
import com.yzm.entity.Orders;
import com.yzm.entity.User;
import com.yzm.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    /**
     * 获取实例对象
     */
    @Test
    public void test() {
        // 1. 加载Spring的配置文件
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BeanFactory context = new ClassPathXmlApplicationContext("bean1.xml");
        // 2. 获取配置创建的对象
        User user = context.getBean("user", User.class);
        System.out.println(user);

        user.hello();
    }

    /**
     * set 方法注入
     */
    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }

    /**
     * 构造器 方法注入
     */
    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println(orders);
    }

    /**
     * P 名称空间注入
     */
    @Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Book book = context.getBean("book2", Book.class);
        System.out.println(book);
    }

    /**
     * 属性赋值：特殊值
     */
    @Test
    public void test5() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Book book = context.getBean("book3", Book.class);
        System.out.println(book);
    }

}
