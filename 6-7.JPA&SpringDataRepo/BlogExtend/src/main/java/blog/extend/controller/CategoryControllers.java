package blog.extend.controller;

import blog.extend.model.Category;
import blog.extend.service.BlogService;
import blog.extend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Locale;

@Controller
public class CategoryControllers {
    @Autowired
    CategoryService categoryService;

    @Autowired
    BlogService blogService;

    @ModelAttribute("categories")
    public List<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("/create/category")
    public String showPage(Model model){
        model.addAttribute("category",new Category());
        return "category/create";
    }

    @PostMapping("/create/category")
    public String createCategory(Category category){
        categoryService.saveCategory(category);
        return "redirect:/";
    }

    @GetMapping("/blogOfCategories/{id}")
    public String showBlogOfCategories(@PathVariable Integer id, Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category",category);
        model.addAttribute("blogs",blogService.findAllByCategory(category));
        return "category/view";
    }
}
