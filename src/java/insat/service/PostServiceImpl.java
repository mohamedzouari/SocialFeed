/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insat.service;

import insat.dao.PostDaoImpl;
import insat.model.Post;
import insat.model.Rate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Madou
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostDaoImpl postDao;

    public void add(Post post) {
        post.setPost_Type("PENDING");
        postDao.add(post);
    }

    public List<Post> getPublishedPosts(long userId) {
        return postDao.getPublishedPosts(userId);
    }

    public List<Post> getPosts() {
        return postDao.getPosts();
    }

    public List<Post> getPendingPosts(long userId) {
        return postDao.getPendingPosts(userId);
    }

    public List<Rate> getRates(long userId) {
        return postDao.getRates(userId);
    }

    @Override
    public void deletePost(long id) {
        postDao.deletePost(id);
    }

    public List<Rate> getRatesForPost(long id) {
        return postDao.getRatesForPost(id);
    }

    public List<Post> getReportedPosts() {
        return postDao.getReportedPosts();
    }

}
