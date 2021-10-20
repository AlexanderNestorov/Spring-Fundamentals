package com.example.examprep15_10.repository.category;

import com.example.examprep15_10.model.entity.category.Category;
import com.example.examprep15_10.model.entity.category.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category> findByName(CategoryNameEnum name);
}
