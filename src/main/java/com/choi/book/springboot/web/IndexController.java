package com.choi.book.springboot.web;

import com.choi.book.springboot.config.auth.LoginUser;
import com.choi.book.springboot.config.auth.dto.SessionUser;
import com.choi.book.springboot.service.posts.PostsService;
import com.choi.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @RequestMapping("/")
    public String board(Model model, @PageableDefault Pageable pageable, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findPostList(pageable));
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @RequestMapping("/index2")
    public String index2() {
        return "index2";
    }

    /*@GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }*/

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
