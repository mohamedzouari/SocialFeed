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

import insat.model.User;
import insat.service.UserService;
import insat.service.UserServiceImpl;
import java.io.File;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Path;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class RegistrationController {

    @Autowired
    public UserService userService;
    
    private Path path;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView mav = new ModelAndView("register");
        mav.addObject("user", new User());
        return mav;
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST )
    public ModelAndView addUser(HttpServletRequest request,HttpSession session,
            @ModelAttribute("user") User user) {

        /* test d'�coute
        System.out.println("*************  Servlet Registration ***************");
        System.out.println(user.getUser_Firstname());
        System.out.println(user.getUser_Lastname());
        System.out.println(user.getUser_Email());
        System.out.println(user.getUser_Birthdate());
        System.out.println(user.getUser_Password());
        System.out.println(user.getUser_Intro());
        System.out.println(user.getUser_Number());
        System.out.println(user.getUser_Password()); */
        
        // get root directory to store the image
	//String rootDirectory = session.getServletContext().getRealPath("/");
        //System.out.println(rootDirectory);
         
        /*
        path = Paths.get(rootDirectory + "/ressources/uploaded-images"+ user.getUser_ID()+ ".png");
        System.out.println(path.toString());
        if (userPicture != null && !userPicture.isEmpty()) {
			try {
				// convert the image type to png
				userPicture.transferTo(new File(path.toString()));
			} catch (IllegalStateException | IOException e) {
				// oops! something did not work as expected
				e.printStackTrace();
				throw new RuntimeException("Saving User image was not successful", e); 
			}
		}
                */

        
        //user.setUser_Picture(path.toString());
        userService.register(user);
        //adding the user to the Session
        HttpSession session_SocialMedia = request.getSession();
        if (null == session_SocialMedia.getAttribute("Session_user")) {
            session_SocialMedia.setAttribute("Session_user", user);
        }
        //preparing welcome View
        ModelAndView mav = new ModelAndView("redirect:/welcome", "Identifier", user.getUser_ID());
        mav.addObject("firstname", user.getUser_Firstname());
        return mav;
    }
}
