package com.spring3nelio.course.service;


import com.spring3nelio.course.entities.Category;
import com.spring3nelio.course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> Category = repository.findById(id);

        return Category.get();
    }
}
