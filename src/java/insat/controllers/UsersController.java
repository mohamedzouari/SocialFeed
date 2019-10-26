/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insat.controllers;

import insat.model.Post;
import insat.model.Rate;
import insat.model.User;

import insat.service.PostService;
import insat.service.UserService;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*
/**
 *
 * @author Mohamed
 */
@Controller
public class UsersController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @RequestMapping(value = "/searchUser", method = RequestMethod.GET)
    public ModelAndView SearchUser(
            HttpServletRequest request,
            HttpServletResponse response) {

        String searchValue = request.getParameter("name");
        System.out.println(searchValue);
        List<User> users = userService.userSearch(searchValue);

        ModelAndView mav = new ModelAndView("userSearchList");
        mav.addObject("users", users);
        return mav;
    }

    @RequestMapping(value = "profile")
    public ModelAndView getProfile(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") long id, @RequestParam("pub") long pub) {

        HttpSession session_SocialMedia = request.getSession(false);
        if (null == session_SocialMedia.getAttribute("Session_user")) {
            return new ModelAndView("redirect:/login");
        }
        ModelAndView mav = new ModelAndView("profile");

        //Test d'écoute
        System.out.println("user id is" + id);

        User user = userService.getUser(id);
        List<Post> userPosts = null;
        String pend = "Pending Posts";
        String publ = "Published Posts";
        String pendLink = "profile?id=" + user.getUser_ID() + "&pub=0";
        String pubLink = "profile?id=" + user.getUser_ID() + "&pub=1";
        if (pub == 1) {
            userPosts = postService.getPublishedPosts(id);
            mav.addObject("Text", publ);
            mav.addObject("Butt", pend);
            mav.addObject("linkTo", pendLink);
        } else {
            userPosts = postService.getPendingPosts(id);
            mav.addObject("Text", pend);
            mav.addObject("Butt", publ);
            mav.addObject("linkTo", pubLink);
        }
        List<Rate> rates = null;

        if (userPosts != null) {
            for (Post tmppost : userPosts) {
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

        mav.addObject("user", user);
        mav.addObject("posts", userPosts);
        mav.addObject("newPost", new Post());
        return mav;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ModelAndView deleteUser(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("id") long id) {

        userService.deleteUser(id);

        ModelAndView mav = new ModelAndView("redirect:/users");
        return mav;
    }

}
