package com.elaheh.spring_hibernate.service.serviceClass;

import com.elaheh.spring_hibernate.model.Category;
import com.elaheh.spring_hibernate.repository.CategoryRepository;
import com.elaheh.spring_hibernate.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceClass implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void create(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Optional<Category> findById(int id) {
        return categoryRepository.findById(id);
    }


    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void update(Category category) {
        categoryRepository.save(category);
    }
}