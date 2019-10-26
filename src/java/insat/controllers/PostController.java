/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insat.controllers;

import insat.model.Admin;
import insat.model.Post;
import insat.model.Rate;
import insat.model.User;
import insat.service.PostService;
import insat.service.RateService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Madou
 */
@Controller
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    RateService rateService;

    @RequestMapping(value = "/deletePost", method = RequestMethod.GET)
    public ModelAndView deleteUser(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("id") long id) {

        postService.deletePost(id);

        ModelAndView mav = new ModelAndView("redirect:/adminManip");
        return mav;
    }

    @RequestMapping("/reportedPosts")
    public ModelAndView reportedPosts(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("adminReported");
        HttpSession session_SocialMedia = request.getSession(false);
        if (null == session_SocialMedia.getAttribute("Session_Admin")) {
            return new ModelAndView("redirect:/MM-admin");
        }

        Admin admin = new Admin();
        admin = (Admin) session_SocialMedia.getAttribute("Session_Admin");
        mav.addObject("admin", admin);

        List<Post> posts = postService.getReportedPosts();
        mav.addObject("posts", posts);

        return mav;
    }

    @RequestMapping(value = "/postAddingProcess", method = RequestMethod.POST)
    public String addPost(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") long id,
            @ModelAttribute("post") Post post) {

        //test d'�coute
        System.out.println("*************  Servlet Registration ***************");
        System.out.println(post.getPost_Text());
        System.out.println(post.getPost_Image());
        System.out.println(id);

        //retreiving the user from the Session
        /* HttpSession session_SocialMedia = request.getSession();
        User user = new User();
        user = (User) session_SocialMedia.getAttribute("Session_user");*/
        post.setPost_Owner_ID(id);
        post.setPost_Type("PENDING");

        //saving the post to the database
        postService.add(post);

        //preparing the welcome view
        String next = "redirect:/profile?id=" + id;
        return next;
    }

    @RequestMapping(value = "/pending", method = RequestMethod.GET)
    public ModelAndView getPending(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("pending");

        HttpSession session_SocialMedia = request.getSession(false);
        if (null == session_SocialMedia.getAttribute("Session_user")) {
            return new ModelAndView("redirect:/login");
        }

        User user = new User();
        user = (User) session_SocialMedia.getAttribute("Session_user");
        mav.addObject("user", user);

        List<Post> posts = postService.getPendingPosts((int) user.getUser_ID());
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

    @RequestMapping(value = "/published", method = RequestMethod.GET)
    public ModelAndView getPublished(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("published");

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

    @RequestMapping(value = "/like", method = RequestMethod.GET)
    public ModelAndView Like(HttpServletRequest request, HttpServletResponse response, @RequestParam("postId") long Post_Id, @RequestParam("l") long Id_User) {

        HttpSession session_SocialMedia = request.getSession(false);
        if (null == session_SocialMedia.getAttribute("Session_user")) {
            return new ModelAndView("redirect:/login");
        }

        User user = new User();
        user = (User) session_SocialMedia.getAttribute("Session_user");

        rateService.addLike(Post_Id, user.getUser_ID());

        if (Id_User == 0) {
            return new ModelAndView("redirect:/welcome");
        }

        return new ModelAndView("redirect:/profile?id=" + Id_User + "&pub=1");

    }

    @RequestMapping(value = "/dislike", method = RequestMethod.GET)
    public ModelAndView Dislike(HttpServletRequest request, HttpServletResponse response, @RequestParam("postId") long Post_Id, @RequestParam("l") long Id_User) {

        HttpSession session_SocialMedia = request.getSession(false);
        if (null == session_SocialMedia.getAttribute("Session_user")) {
            return new ModelAndView("redirect:/login");
        }

        User user = new User();
        user = (User) session_SocialMedia.getAttribute("Session_user");

        rateService.addDislike(Post_Id, user.getUser_ID());

        if (Id_User == 0) {
            return new ModelAndView("redirect:/profile?id=" + Id_User + "&pub=1");
        }
        return new ModelAndView("redirect:/welcome");

    }

}
