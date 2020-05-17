package com.elaheh.spring_hibernate.service;

import com.elaheh.spring_hibernate.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService  {
    void create(Category category);
    Optional<Category> findById(int id);
    List<Category> findAll();
    void deleteById(int id);
    void update(Category category);
}
