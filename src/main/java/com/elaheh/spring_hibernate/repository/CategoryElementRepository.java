package com.elaheh.spring_hibernate.repository;

import com.elaheh.spring_hibernate.model.CategoryElements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryElementRepository extends JpaRepository<CategoryElements, Integer> {}
