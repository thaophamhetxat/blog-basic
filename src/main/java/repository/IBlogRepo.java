package repository;


import moduls.Blog;

import java.util.ArrayList;

public interface IBlogRepo {

     Blog save(Blog blog);

     ArrayList<Blog> findAll();
     Blog findByName(String name);

     void Delete(Blog blog);

     void edit(Blog blog);

}
