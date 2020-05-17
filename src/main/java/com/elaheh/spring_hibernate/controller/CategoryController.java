package com.elaheh.spring_hibernate.controller;

import com.elaheh.spring_hibernate.exceptions.ItemNotFoundException;
import com.elaheh.spring_hibernate.model.Category;
import com.elaheh.spring_hibernate.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/CategoryController")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/InsertCategory")
    public void insertCategory(@RequestBody Category category) {
        categoryService.create(category);
    }

    @GetMapping("/GetByIdCategory")
    public Category category(@RequestParam int id) throws ItemNotFoundException {
        return categoryService.findById(id).orElseThrow(() -> new ItemNotFoundException());
    }

    @GetMapping("/GetAllCategory")
    public List<Category> categoryList(){
        return categoryService.findAll();
    }

    @PostMapping("/UpdateCategory")
    public void update(@RequestBody Category category){
        categoryService.update(category);
    }

    @DeleteMapping("/DeleteCategory")
    public void delete(@RequestParam int id) {
        categoryService.deleteById(id);
    }
}
