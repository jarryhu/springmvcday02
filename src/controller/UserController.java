package controller;

import net.sf.json.JSONArray;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import pojo.User;
import service.BookDao;
import service.UserDao;
import tool.TooL;
import util.PageUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;


    @RequestMapping("/checkUserName.action")
    @ResponseBody
    public String checkUsername(String username) {
        username = username.substring(0, username.length() - 1);
        String[] split = username.split(",");
        for (String id : split) {
            userDao.deleteUser(Integer.parseInt(id));
        }
        int i = userDao.checkUserName(username);
        return (i > 0) ? "用户名已经被占用" : "用户名可用";
    }

    @RequestMapping("userheadUpload.action")
    public String userheadUpload() {
        return "upload";
    }

    @RequestMapping("uploadHead.action")
    @ResponseBody
    public Map<String, Object> uploadHead(MultipartFile file, int id) throws IOException {
        String filename = UUID.randomUUID().toString().replaceAll("-", "");
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        filename = filename + "." + extension;
        String path = "D:\\upload";
        file.transferTo(new File("D:\\upload\\" + filename));
        Map<String, Object> map = new HashMap<>();
        User user = new User();
        user.setUser_id(id);
        user.setHeadpath(filename);
        userDao.updatehead(user);
        File dir = new File(path, filename);
        if (!dir.exists()) {
            map.put("msg", "上传失败");
            map.put("code", 1);

        } else {

            dir.mkdirs();
            map.put("msg", "上传成功");
            map.put("code", 0);

        }
        return map;

    }

    @RequestMapping("delete.action")
    @ResponseBody
    public int delete(String user_ids) {

        boolean b = user_ids.endsWith(",");
        if (b) {
            user_ids = user_ids.substring(0, user_ids.length() - 1);
        }
        String[] ids = user_ids.split(",");

        int result = 0;
        for (String id :
                ids) {
            result = userDao.deleteUser(Integer.parseInt(id));
        }
        return result;
    }

    @RequestMapping("addUser.action")
    @ResponseBody
    public int addUser(User user) {
        int r = userDao.userAdd(user);
        return r;
    }

    @RequestMapping("addUser2.action")
    @ResponseBody
    public int addUser2(User user) {
        int r = userDao.userAdd(user);
        return r;
    }


    @RequestMapping("searchByWhere.action")
    @ResponseBody
    public List<User> searchByWhere(@RequestBody User user) {
        List<User> users = userDao.search(user);
        return users;
    }


    @RequestMapping("searchByWhere2.action")
    @ResponseBody
    public List<User> searchByWhere2(User user) {
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

    @RequestMapping("addUserPage.action")

    public String addUserPage() {
        return "adduser";
    }


    @RequestMapping("userListpage1.action")

    public String userList() {
        return "list";
    }

    @RequestMapping("userListpage2.action")

    public String userList2() {
        return "list2";
    }


    @RequestMapping("main.action")

    public String mainPage() {
        return "admin";
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
        List<User> o = userDao.getUserList(PageUtil.getPageParamer(user, page, limit));
        int size = userDao.userCount();
        Map<String, Object> tableData = PageUtil.getDataForPage(page, limit, o, size);
        return tableData;
    }


    @RequestMapping("selectLayUitablePage.action")

    public String selectLayUitablePage() {
        return "list3";
    }


    @RequestMapping("selectLayUitable.action")
    @ResponseBody
    public Map<String, Object> selectLayUitable() {

        List<User> users = userDao.selectLayUitable();
        return TooL.testLayui(users, 0, 0);
    }


    @RequestMapping("updateUserInfo.action")
    @ResponseBody
    public int updateuser(User user) {
        return userDao.updateuser(user);

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
