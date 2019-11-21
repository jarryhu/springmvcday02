package controller;

import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User;
import service.UserDao;
import tool.TooL;
import util.PageUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    HttpServletRequest request;

    @RequestMapping("/loginLayui.action")
    @ResponseBody
    public String login(@RequestBody User user) {
        HttpSession session = request.getSession();
        User loginUser = userDao.Login(user);
        if (loginUser != null) {
            //重定向
            session.setAttribute("user", loginUser);
            return "success";
        } else {

            return "fail";
        }
    }


    @RequestMapping("userListpage1.action")

    public String userList() {
        return "/layuipage/list.html";
    }

    @RequestMapping("userListpage2.action")

    public String userList2() {
        return "/layuipage/list2.html";
    }


    @RequestMapping("main.action")

    public String mainPage() {
        return "/layuipage/admin.html";
    }


    @RequestMapping("/userList1.action")
    @ResponseBody
    public Map<String, Object> getUserList1(User user) {
        List<User> userList = userDao.searchByWhere(user);
        Map<String, Object> tableData = PageUtil.getDataForPage(0, 0, userList, userList.size());
        return tableData;
    }


    @RequestMapping("/userList2.action")
    @ResponseBody
    public Map<String, Object> getUserList2(User user, int page, int limit) {
        List<User> o = userDao.getUserList(PageUtil.getPageParamer(page, limit));
        int size = userDao.userCount();
        Map<String, Object> tableData = PageUtil.getDataForPage(page, limit, o, size);
        return tableData;
    }


    @RequestMapping("selectLayUitablePage.action")

    public String selectLayUitablePage() {
        return "tableDemo";
    }


    @RequestMapping("selectLayUitable.action")
    @ResponseBody
    public Map<String, Object> selectLayUitable() {

        List<User> users = userDao.selectLayUitable();
        return TooL.testLayui(users, 0, 0);
    }


    @RequestMapping("selectLayUitable_Page.action")
    @ResponseBody
    public Map<String, Object> selectLayUitable_Page(int page, int limit) {
        HashMap<String, Integer> map = new HashMap<>();
        int pageStart = (page - 1) * limit;
        map.put("pagestart", pageStart);
        map.put("size", limit);
        List<User> users = userDao.selectpage(map);
        Integer pagecount = userDao.userCount();
        Map<String, Object> returnTable = TooL.testLayui(users, page, limit);
        returnTable.put("count", pagecount);
        return returnTable;
    }


}
