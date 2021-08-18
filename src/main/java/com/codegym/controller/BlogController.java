package com.codegym.controller;

import moduls.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.BlogService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @RequestMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        blogService.findAll();
        modelAndView.addObject("list", blogService.list);
        return modelAndView;
    }

    @GetMapping("/readBlog{index}")
    public ModelAndView showPlay(@PathVariable int index, Model model) {
        ModelAndView modelAndView = new ModelAndView("readBlog");
        blogService.findAll();
        modelAndView.addObject("listNext", blogService.list);
        model.addAttribute("list", blogService.list.get(index));
        return modelAndView;
    }

    @GetMapping("/delete/{index}")
    public ModelAndView delete(@PathVariable int index) {
        blogService.delete(index);
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create","listTrangThai",blogService.listTrangThai);
        modelAndView.addObject("list", new Blog());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog,@RequestParam MultipartFile uppImg,@RequestParam MultipartFile uppMusic) {
        String nameImg = uppImg.getOriginalFilename();
        String nameMusic = uppMusic.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppImg.getBytes(), new File("D:\\JAVA MD4\\MD4-06-TH-ungDungQLKH\\src\\main\\webapp\\image/" + nameImg));
            FileCopyUtils.copy(uppMusic.getBytes(), new File("D:\\JAVA MD4\\MD4-06-TH-ungDungQLKH\\src\\main\\webapp\\music/" + nameMusic));
            String urlImg = "/image/" + nameImg;
            String urlMusic = "/music/" + nameMusic;
            blog.setImage(urlImg);
            blog.setFileNhac(urlMusic);
        } catch (IOException e) {
            System.err.println("chưa uppload file");
        }
        blogService.save(blog);
        return "redirect:/home";
    }

    @GetMapping("/edit/{index}")
    public ModelAndView showEdit(@PathVariable int index) {
        ModelAndView modelAndView = new ModelAndView("edit","listTrangThai",blogService.listTrangThai);
        modelAndView.addObject("list", blogService.list.get(index));
        return modelAndView;
    }

    @PostMapping("/edit/{index}")
    public ModelAndView edit(@ModelAttribute Blog blog,@RequestParam MultipartFile uppImg,@RequestParam MultipartFile uppMusic) {
        String nameImg = uppImg.getOriginalFilename();
        String nameMusic = uppMusic.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppImg.getBytes(), new File("D:\\JAVA MD4\\MD4-06-TH-ungDungQLKH\\src\\main\\webapp\\image/" + nameImg));
            FileCopyUtils.copy(uppMusic.getBytes(), new File("D:\\JAVA MD4\\MD4-06-TH-ungDungQLKH\\src\\main\\webapp\\music/" + nameMusic));
            String urlImg = "/image/" + nameImg;
            String urlMusic = "/music/" + nameMusic;
            blog.setImage(urlImg);
            blog.setFileNhac(urlMusic);
        } catch (IOException e) {
            System.err.println("chưa uppload file");
        }
        blogService.edit(blog);
        return new ModelAndView("redirect:/home");
    }


    @GetMapping("/find")
    public String findByName(@RequestParam String findName) {
        blogService.findByName(findName);
        return "redirect:/home";
    }
}
