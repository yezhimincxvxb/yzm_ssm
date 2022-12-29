import com.yzm3.entity.User;
import com.yzm3.entity.UserMore;
import com.yzm3.entity.UserOne;
import com.yzm3.mapper.UserMapper;
import com.yzm3.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyBatisTest {

    @Test
    public void listUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.listUser();
        users.forEach(System.out::println);

        sqlSession.close();
    }

    @Test
    public void listOneToOne() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<UserOne> users = userMapper.listOneToOne();
        users.forEach(System.out::println);

        sqlSession.close();
    }

    @Test
    public void listOneToOne2() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<UserOne> users = userMapper.listOneToOne2();
        users.forEach(System.out::println);

        sqlSession.close();
    }

    @Test
    public void listOneToMore() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<UserMore> users = userMapper.listOneToMore();
        users.forEach(System.out::println);

        sqlSession.close();
    }

    @Test
    public void listOneToMore2() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<UserMore> users = userMapper.listOneToMore2();
        users.forEach(System.out::println);

        sqlSession.close();
    }

}
