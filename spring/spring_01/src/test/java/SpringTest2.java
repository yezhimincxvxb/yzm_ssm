import com.yzm.entity.Employee;
import com.yzm.entity.Student;
import com.yzm.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest2 {

    /**
     * 注入外部bean
     */
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    /**
     * 注入内部bean
     */
    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Employee employee = context.getBean("employee", Employee.class);
        System.out.println(employee);
    }

    /**
     * 级联赋值
     */
    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Employee employee = context.getBean("employee2", Employee.class);
        System.out.println(employee);
    }

    /**
     * 级联赋值
     */
    @Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
    }

}
