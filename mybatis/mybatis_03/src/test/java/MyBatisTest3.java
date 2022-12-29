import com.yzm3.entity.Movie;
import com.yzm3.mapper.MovieMapper;
import com.yzm3.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyBatisTest3 {

    /**
     * 一级缓存：在一次SqlSession内有效
     * 重复获取同一条数据，只有一次查询SQL打印
     * 缓存失效的情况：
     * 1、进行增删改操作
     * 2、查询不同的Mapper.xml
     * 3、sqlSession.clearCache手动清理缓存
     */
    @Test
    public void firstLevelCache() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        MovieMapper movieMapper = sqlSession.getMapper(MovieMapper.class);

        Movie movie = movieMapper.getMovieById(1);
        System.out.println("movie = " + movie);
        System.out.println("===================================");

        Movie movie2 = movieMapper.getMovieById(1);
        System.out.println(movie == movie2);

        sqlSession.close();
    }

    @Test
    public void secondLevelCache() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        MovieMapper movieMapper = sqlSession.getMapper(MovieMapper.class);

        Movie movie = movieMapper.getMovieById(1);
        System.out.println("movie = " + movie);
        sqlSession.close();
        System.out.println("===================================");

        SqlSession sqlSession2 = MyBatisUtils.getSqlSession();
        MovieMapper movieMapper2 = sqlSession2.getMapper(MovieMapper.class);
        Movie movie2 = movieMapper2.getMovieById(1);
        System.out.println(movie == movie2);
        sqlSession2.close();
    }

}
