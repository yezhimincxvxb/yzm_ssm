import com.yzm2.dao.UserMapper;
import com.yzm2.entity.User;
import com.yzm2.plugin.Page;
import com.yzm2.plugin.UserPage;
import com.yzm2.utils.MyBatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {

    @Test
    public void listUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.listUser();
        users.forEach(System.out::println);

        sqlSession.close();
    }

    /**
     * 物理分页
     */
    @Test
    public void listUserByLimit() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.listUserByLimit(1,2);
        users.forEach(System.out::println);

        sqlSession.close();
    }

    /**
     * RowBounds 实现分页
     */
    @Test
    public void rowBounds() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        List<User> users = sqlSession.selectList("com.yzm2.dao.UserDao.listUser", null, new RowBounds(3, 2));
        users.forEach(System.out::println);

        sqlSession.close();
    }

    @Test
    public void plugin() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserPage userPage = new UserPage();
        Page<User> page = new Page<>();
        page.setNowPage(3);
        page.setPageShow(2);
        userPage.setPage(page);
        Page<User> pages = userPage.getPage().setResult(userMapper.page(userPage));

        System.out.println("显示数：" + pages.getPageShow());
        System.out.println("当前页：" + pages.getNowPage());
        System.out.println("总页数：" + pages.getTotalPage());
        System.out.println("总记录：" + pages.getTotalCount());
        pages.getResult().forEach(System.out::println);
    }

    @Test
    public void plugin2() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Page<User> page = new Page<>();
        page.setNowPage(3);
        page.setPageShow(2);
        Page<User> pages = page.setResult(userMapper.page2(page));

        System.out.println("显示数：" + pages.getPageShow());
        System.out.println("当前页：" + pages.getNowPage());
        System.out.println("总页数：" + pages.getTotalPage());
        System.out.println("总记录：" + pages.getTotalCount());
        pages.getResult().forEach(System.out::println);
    }

}
