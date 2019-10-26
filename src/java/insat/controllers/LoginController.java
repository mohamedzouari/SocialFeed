/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insat.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import insat.model.Login;
import insat.model.User;
import insat.service.UserService;
import insat.service.UserServiceImpl;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login", new Login());
        return mav;
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("login") Login login) {

        ModelAndView mav = null;
        User user = userService.validateUser(login);

        if (null != user) {
            mav = new ModelAndView("redirect:/welcome");
                       
            HttpSession session_SocialMedia = request.getSession();
            if (null == session_SocialMedia.getAttribute("Session_user")) {
                session_SocialMedia.setAttribute("Session_user", user);
            }
        } else {
            mav = new ModelAndView("login");
            mav.addObject("message", "Username or Password is wrong !");
        }
        return mav;
    }
}
