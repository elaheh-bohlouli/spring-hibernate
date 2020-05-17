package com.elaheh.spring_hibernate.controller;


import com.elaheh.spring_hibernate.exceptions.ItemNotFoundException;
import com.elaheh.spring_hibernate.model.CategoryElements;
import com.elaheh.spring_hibernate.service.CategoryElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/CategoryElementController")
public class CategoryElementController {

    @Autowired
    private CategoryElementService categoryElementService;

    @PostMapping("/InsertCategoryElement")
    public void insertCategoryElement(@RequestBody CategoryElements categoryElements) {
        categoryElementService.create(categoryElements);
    }

    @GetMapping("/GetByIdCategoryElement")
    public CategoryElements categoryElements(@RequestParam int id) throws ItemNotFoundException {
        return categoryElementService.findById(id).orElseThrow(() -> new ItemNotFoundException());
    }

    @GetMapping("/GetAllCategoryElement")
    public List<CategoryElements> categoryElementList(){
        return categoryElementService.findAll();
    }

    @PostMapping("/UpdateCategoryElement")
    public void update(@RequestBody CategoryElements categoryElements){
        categoryElementService.update(categoryElements);
    }

    @DeleteMapping("/DeleteCategoryElement")
    public void delete(@RequestParam int id) {
        categoryElementService.deleteById(id);
    }
}
