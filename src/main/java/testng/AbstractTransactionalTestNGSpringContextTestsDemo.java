package testng;

import cn.yuanpx.springbootmybatisdemo.entity.User;
import cn.yuanpx.springbootmybatisdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * AbstractTestNGSpringContextTests 和AbstractTransactionalTestNGSpringContextTests区别：
 * AbstractTransactionalTestNGSpringContextTests自带回滚功能，默认每个方法执行完都会回滚
 */
public class AbstractTransactionalTestNGSpringContextTestsDemo extends AbstractTransactionalTestNGSpringContextTests {
    @Autowired
    UserMapper mapper;

    @Test
    public void testa() {
        mapper.updateUserById(1);
    }

    @Test(dependsOnMethods = "test")
    public void testb() {
        User user = mapper.getUserById(1);
        System.out.println(user);
    }
}
