package controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import exception.ParamErrorException;
import org.apache.commons.io.FilenameUtils;

import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pojo.*;

import service.BookDao;
import service.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;


@Controller
public class Productcontroller {



    @RequestMapping("/loginPage.action")
    public String loginPage() {
        System.out.println("Productcontroller>>>/loginPage.action");
        return "login";
    }


    @Autowired
    UserDao userDao;
    @Autowired
    HttpServletRequest reqeust;

    @RequestMapping("/login.action")
    public String login(User user, Model model) {
        //  model view controller
        HttpSession session = reqeust.getSession();
        User loginUser = userDao.Login(user);
        if (loginUser != null) {
            //重定向
            session.setAttribute("user", loginUser);
            return "redirect:/userList.action";
        } else {
            model.addAttribute("msg", "用户名密码错误");
            return "login";
        }
    }

    @RequestMapping("/loginTest.action")
    @ResponseBody
    public int loginTest(@RequestBody User user, Model model) {
        //  model view controller

        HttpSession session = reqeust.getSession();
        User loginUser = userDao.Login(user);
        if (loginUser != null) {
            //重定向
            session.setAttribute("user", loginUser);
            return 1;
        } else {
            model.addAttribute("msg", "用户名密码错误");
            return 0;
        }
    }


    @RequestMapping("goListPage.action")
    public String goListPage() {
        return "layuipage/list.html";
    }

    @RequestMapping("getUserByid.action")
    public ModelAndView getUserByid(int id) {
        User user = userDao.getUserByid(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("modify");
        return modelAndView;
    }

    @RequestMapping("/update.action")
    //这是我做的 李证奇 谁都别动
    public String update(User user, MultipartFile pictureFile) throws IOException {
        String filename = UUID.randomUUID().toString().replaceAll("-", "");
        String extension = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
        filename = filename + "." + extension;
        pictureFile.transferTo(new File("D:\\upload\\" + filename));
        user.setHeadpath(filename);

        int updatehead = userDao.updatehead(user);
        return "redirect:/userList.action";

    }

    @RequestMapping("/check.action")
    @ResponseBody
    public String checkName(String name) {
        int i = userDao.checkUserName(name);
        if (i > 0) {
            return "用户名已被注册";
        } else {
            return "用户名没有被使用可以注册";
        }
    }

    @RequestMapping("/searchPage.action")
    public String registerPage() {

        return "search";
    }

    @RequestMapping("/checkPage.action")
    public String checkPage() {
        return "test";
    }


    @RequestMapping(value = "/search.action", method = RequestMethod.POST)

    public @ResponseBody
    List<Product> search(@RequestBody User user1) {

        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "phone", 20.0f, new Date(), "test"));
        list.add(new Product(1, "phone", 20.0f, new Date(), "test"));
        list.add(new Product(1, "手机", 20.0f, new Date(), "test"));
        return list;

    }


    @RequestMapping(value = "/searchUserAjax.action")
    @ResponseBody
    public List<User> searchUserAjax(@RequestBody User user) {
        List<User> users = userDao.searchByWhere(user);
        return users;


    }

    @RequestMapping("/searchUserAjaxPage.action")

    public String searchUserAjaxPage() {
        return "userSearch";

    }

    @Autowired
    BookDao bookDao;

    @RequestMapping("borrowBook.action")
    public String borrowBook(Model model) {
        List<Book> books = bookDao.borrowBookList();
        model.addAttribute("books", books);
        return "bookList";
    }

    @RequestMapping("borrow.action")
    public String borrow(BorrowBookUser b) {
        HttpSession session = reqeust.getSession();
        User user = (User) session.getAttribute("user");
        b.setUserid(user.getUser_id());
        bookDao.borrow(b);
        return "redirect:borrowBook.action";
    }




}
