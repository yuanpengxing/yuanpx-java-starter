package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.entity.User;
import springboot.mapper.UserMapper;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    UserMapper userMapper;

    @RequestMapping("getUser/{id}")
    public String getUser(@PathVariable int id) {
        User user = userMapper.getUserById(id);
        return user.toString();
    }

}
