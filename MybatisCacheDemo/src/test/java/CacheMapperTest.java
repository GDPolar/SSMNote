import com.xd.pl.mapper.CacheMapper;
import com.xd.pl.pojo.Emp;
import com.xd.pl.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {
    // 查询时，依次从二级缓存->一级缓存->数据库中查询数据
    @Test
    public void test1() throws IOException {
        // Mybatis 一级缓存默认开启
        // SqlSession 级别，即一级缓存范围作用于同一 SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpById(1);
        System.out.println(emp1);
        // 手动清空一级缓存
        sqlSession.clearCache();
        // 从缓存中获取，不会生成 sql 语句
        // 但是若两次查询间进行了任何增删改操作，会使得一级缓存失效，重新查询
        Emp emp2 = mapper.getEmpById(1);
        System.out.println(emp2);
        // 重新获取 sqlSession
        SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        // 重新生成 sql 语句查询数据库
        Emp emp3 = mapper2.getEmpById(1);
        System.out.println(emp3);
    }

    @Test
    public void test2() throws IOException {
        // Mybatis 二级缓存通过在 mapper 的 xml 文件中使用 <cache/> 标签开启
        // SqlSessionFactory 级别，即通过同一 SqlSessionFactory 所创建的 SqlSession
        // sqlSession 关闭后将一级缓存的数据保存至二级缓存
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);
        sqlSession1.close();
        // 二级缓存要求查询的数据所转换的实体类必须实现序列化接口，否则报错
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        // 从缓存中获取，不会生成 sql 语句
        // 但是若两次查询间进行了任何增删改操作，会使得二级缓存也失效，重新查询
        Emp emp2 = mapper2.getEmpById(1);
        System.out.println(emp2);
        sqlSession2.close();
    }
}
