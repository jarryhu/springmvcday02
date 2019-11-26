package service;

import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pojo.User;

import java.util.HashMap;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {
    @Autowired
    UserMapper userMapper;

    @Override
    public User Login(User user) {
        return userMapper.login(user);
    }

    @Override
    public List<User> getUserList(HashMap map) {
        return userMapper.getUserList(map);
    }


    @Override
    public User getUserByid(int id) {
        return userMapper.getUserByid(id);
    }

    @Override
    public int updatehead(User user) {
        int result = userMapper.updatehead(user);
        return result;
    }

    @Override
    public int checkUserName(String name) {
        return userMapper.checkUserName(name);
    }

    @Override
    public List<User> searchByWhere(User user) {
        return userMapper.searchByWhere(user);
    }

    @Override
    public List<User> search(User user) {
        return userMapper.search(user);
    }

    @Override
    public Integer userCount() {
        return userMapper.userCount();
    }

    @Override
    public List<User> selectLayUitable() {
        return userMapper.selectLayUitable();
    }

    @Override
    public List<User> selectpage(HashMap map) {
        return userMapper.selectpage(map);
    }

    @Override
    public int updateuser(User user) {
        return userMapper.updateuser(user);
    }


    @Override
    public int updateUserinfo(User user) {
        return userMapper.updateUserinfo(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public int userAdd(User user) {
        userMapper.userAdd(user);
        return user.getUser_id();
    }
}
