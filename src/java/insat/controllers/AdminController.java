/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insat.controllers;

import insat.model.Admin;
import insat.model.Login;
import insat.model.Post;
import insat.model.User;
import insat.service.AdminService;
import insat.service.PostService;
import insat.service.UserService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Madou
 */
@Controller
public class AdminController {

    @Autowired
    PostService postService;

    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/MM-admin", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("adminLogIn");
        mav.addObject("login", new Login());
        return mav;
    }

    @RequestMapping(value = "/adminLoginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("login") Login login) {

        ModelAndView mav = null;

        System.out.println(login.getEmail() + "  " + login.getPassword());
        Admin admin = adminService.validateAdmin(login);

        if (null != admin) {
            mav = new ModelAndView("redirect:/adminManip");

            HttpSession session_SocialMedia = request.getSession();
            if (null == session_SocialMedia.getAttribute("Session_Admin")) {
                session_SocialMedia.setAttribute("Session_Admin", admin);
            }

        } else {
            mav = new ModelAndView("adminLogIn");
            mav.addObject("message", "Username or Password is wrong !");
        }
        return mav;
    }

    @RequestMapping(value = "/adminManip", method = RequestMethod.GET)
    public ModelAndView adminHome(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("adminManip");

        HttpSession session_SocialMedia = request.getSession(false);
        if (null == session_SocialMedia.getAttribute("Session_Admin")) {
            return new ModelAndView("redirect:/MM-admin");
        }

        Admin admin = new Admin();
        admin = (Admin) session_SocialMedia.getAttribute("Session_Admin");
        mav.addObject("admin", admin);

        List<Post> posts = postService.getPosts();
        mav.addObject("posts", posts);

        return mav;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView adminUserList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("adminUsersList");

        HttpSession session_SocialMedia = request.getSession(false);
        if (null == session_SocialMedia.getAttribute("Session_Admin")) {
            return new ModelAndView("redirect:/MM-admin");
        }

        Admin admin = new Admin();
        admin = (Admin) session_SocialMedia.getAttribute("Session_Admin");
        mav.addObject("admin", admin);

        List<User> users = userService.getUsers();
        mav.addObject("users", users);

        return mav;
    }

}
