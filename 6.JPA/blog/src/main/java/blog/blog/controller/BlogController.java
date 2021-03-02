package blog.blog.controller;

import blog.blog.model.Blog;
import blog.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/")
    public String home(Model model){
        List<Blog> blogs = blogService.findBlog();
        model.addAttribute("blogs", blogs);
        return "home";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String create(Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.update(blog.getId(),blog);
        redirectAttributes.addFlashAttribute("success","edit success");
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("success","delete success");
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        return "/view";
    }
}
