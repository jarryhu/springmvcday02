package service;

import mapper.UserMapper;
import pojo.User;

import java.util.HashMap;
import java.util.List;

public interface UserDao {

    public User Login(User user);

    public int updateUserinfo(User user);

    public int deleteUser(Integer id);

    public int userAdd(User user);

    public List<User> getUserList(HashMap map);

    public User getUserByid(int id);

    public int updatehead(User user);

    public int checkUserName(String name);

    public List<User> searchByWhere(User user);


    public List<User> search(User user);

    public Integer userCount(User user);

    public List<User> selectLayUitable();

    public List<User> selectpage(HashMap map);

    public int updateuser(User user);


}
