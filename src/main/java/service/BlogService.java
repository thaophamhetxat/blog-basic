package service;

import moduls.Blog;
import moduls.TrangThai;
import org.springframework.beans.factory.annotation.Autowired;
import repository.IBlogRepo;

import java.util.ArrayList;

public class BlogService  {
public ArrayList<Blog> list = new ArrayList<>();
public ArrayList<TrangThai> listTrangThai = new ArrayList<>();
    @Autowired
    IBlogRepo iBlogRepo;
public BlogService(){
    listTrangThai.add(new TrangThai(1,"vui"));
    listTrangThai.add(new TrangThai(1,"buồn"));
    listTrangThai.add(new TrangThai(1,"háo hức"));
}

    public void save(Blog blog) {
        iBlogRepo.save(blog);
    }

    public Blog findByName(String name) {
        return iBlogRepo.findByName(name);
    }

    public void findAll() {
        list = iBlogRepo.findAll();
    }


    public void edit(Blog blog) {
        iBlogRepo.edit(blog);
    }

    public void delete(int index) {
        iBlogRepo.Delete(list.get(index));
        list.remove(index);
    }
}
