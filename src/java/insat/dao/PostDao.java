/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insat.dao;

import insat.model.Post;
import insat.model.Rate;
import java.util.List;

/**
 *
 * @author Madou
 */
public interface PostDao {

    public void add(Post post);

    public List<Post> getPublishedPosts(long userId);

    public List<Post> getPosts();
    
    public List<Post> getPendingPosts(long userId);

    public void deletePost(long id);

    public List<Rate> getRatesForPost(long id);
    
    public List<Post> getReportedPosts();
}
