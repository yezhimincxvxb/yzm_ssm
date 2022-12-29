import com.yzm3.entity.Account;
import com.yzm3.mapper.AccountMapper;
import com.yzm3.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MyBatisTest2 {

    @Test
    public void listAccountByIf() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);

        // 查询所有
        List<Account> accounts = accountMapper.listAccountByIf(Account.builder().build());
        accounts.forEach(System.out::println);

        // 根据userid查询
        accounts = accountMapper.listAccountByIf(Account.builder().userId("5").build());
        accounts.forEach(System.out::println);

        // 根据userid查询
        accounts = accountMapper.listAccountByIf(Account.builder().username("莫小贝").build());
        accounts.forEach(System.out::println);

        sqlSession.close();
    }

    @Test
    public void listAccountByWhere() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);

        List<Account> accounts;

        accounts = accountMapper.listAccountByWhere(Account.builder().userId("5").build());
        accounts.forEach(System.out::println);

        sqlSession.close();
    }

    @Test
    public void updateBySet() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);

        accountMapper.updateBySet(Account.builder().id(18).username("ADMIN").payPassword("123456").build());

        sqlSession.close();
    }

    @Test
    public void listAccountByChoose() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);

        List<Account> accounts = accountMapper.listAccountByChoose(Account.builder().build());
        accounts.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void listAccountByForeach() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);

        List<Account> accounts = accountMapper.listAccountByForeach(Arrays.asList(2, 4, 6));
        accounts.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void listAccountByBind() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);

        List<Account> accounts = accountMapper.listAccountByBind("a");
        accounts.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void listUserByLike() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
        List<Account> accounts = accountMapper.listUserByLike("%b%");
        System.out.println(accounts);
        sqlSession.close();
    }

    @Test
    public void listUserByCONCAT() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
        List<Account> accounts = accountMapper.listUserByCONCAT("o");
        System.out.println(accounts);
        sqlSession.close();
    }

    @Test
    public void listAccountBySQL() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);

        List<Account> accounts = accountMapper.listAccountBySQL(Account.builder().payPassword("laoxing").build());
        accounts.forEach(System.out::println);
        sqlSession.close();
    }

}
