import com.yzm.dao.UserDao;
import com.yzm.entity.User;
import com.yzm.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {

    @Test
    public void listUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.listUser();

        // 了解即可，返回类型需要强转
//        List<User> users = sqlSession.selectList("com.yzm.dao.UserDao.listUser");

        users.forEach(System.out::println);

        sqlSession.close();
    }

    @Test
    public void listUser2() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.listUser2();
        users.forEach(System.out::println);

        sqlSession.close();
    }

    @Test
    public void getById() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.getById(2);
        System.out.println("user = " + user);

        sqlSession.close();
    }

    @Test
    public void getById2() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.getById2(3);
        System.out.println("user = " + user);

        sqlSession.close();
    }

    @Test
    public void addUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int i = userDao.addUser(User.builder().id(4).username("admin").password("admin").build());
        if (i > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }

        // 必须提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void editUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int i = userDao.editUser(User.builder().id(8).username("ADMIN").build());
        if (i > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void delUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int i = userDao.delUser(8);
        if (i > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 通过参数列表下标获取参数值
     * arg0、arg1、arg2
     * param1、param2、param3
     * 可以混合使用
     */
    @Test
    public void listUserByIndex() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.listUserByIndex(2, 1, 1);
        users.forEach(System.out::println);

        sqlSession.close();
    }

    /**
     * @Param
     */
    @Test
    public void listUserByParam() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.listUserByParam(0, 1);
        users.forEach(System.out::println);

        sqlSession.close();
    }


    /**
     * 使用Map传参
     */
    @Test
    public void listUserByMap() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        Map<String, Object> map = new HashMap<>();
        map.put("name", "李秀莲");
        List<User> users = userDao.listUserByMap(map);
        System.out.println(users);
        sqlSession.close();
    }

}
