/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insat.controllers;

import insat.model.Login;
import insat.model.Post;
import insat.model.Rate;
import insat.model.User;
import insat.service.PostService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*
 *
 * @author Mohamed
 */
@Controller
public class HomeController {

    @Autowired
    PostService postService;

    @RequestMapping(value = "/")
    public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session_SocialMedia = request.getSession(false);
        if (null == session_SocialMedia.getAttribute("Session_user")) {
            ModelAndView mav = new ModelAndView("redirect:/login");
            mav.addObject("login", new Login());
            return mav;
        }
        return new ModelAndView("redirect:/welcome");
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView getConf(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("welcome");

        HttpSession session_SocialMedia = request.getSession(false);
        if (null == session_SocialMedia.getAttribute("Session_user")) {
            return new ModelAndView("redirect:/login");
        }

        User user = new User();
        user = (User) session_SocialMedia.getAttribute("Session_user");
        mav.addObject("user", user);

        List<Post> posts = postService.getPublishedPosts((int) user.getUser_ID());
        List<Rate> rates = null;

        // this is repeated in pending posts
        if (posts != null) {
            for (Post tmppost : posts) {
                tmppost.setPost_Likes(0);
                rates = postService.getRatesForPost(tmppost.getPost_ID());
                int likes = 0;
                int totalRate = rates.size();
                if (rates != null) {
                    for (Rate tmpRate : rates) {
                        if (tmpRate.getRate_Value() == 1) {
                            likes++;
                        }
                    }
                }
                tmppost.setPost_Likes(likes);
                tmppost.setPost_Dislikes(totalRate - likes);
            }
        }

        mav.addObject("posts", posts);
        return mav;

    }

    @RequestMapping(value = "/information", method = RequestMethod.GET)
    public ModelAndView getInfo(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("profileinfo");

        //retreiving the user from the Session
        HttpSession session_SocialMedia = request.getSession(false);
        if (null == session_SocialMedia.getAttribute("Session_user")) {
            return new ModelAndView("redirect:/login");
        }

        User user = new User();
        user = (User) session_SocialMedia.getAttribute("Session_user");
        mav.addObject("user", user);

        return mav;

    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session_SocialMedia = request.getSession(false);
        session_SocialMedia.invalidate();

        return new ModelAndView("redirect:/login");
    }

}
