package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User;
import service.UserDao;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/checkUserName.action")
    @ResponseBody
    public String checkUsername(String username) {
        int i = userDao.checkUserName(username);
        return (i > 0) ? "用户名已经被占用" : "用户名可用";
    }


    @RequestMapping("searchByWhere.action")
    @ResponseBody
    public List<User> searchByWhere(@RequestBody User user) {
        List<User> users = userDao.search(user);
        return users;
    }
}
