package springboot.mapper;


import org.springframework.stereotype.Repository;
import springboot.entity.User;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {

    public User getUserById(int id);

    public List<Map> getUserList(int id);

    public void updateUserById(int id);

}
