package com.tech.service;

import com.tech.dto.CategoryDTO;
import com.tech.dto.CategoryPageQueryDTO;
import com.tech.entity.Category;
import com.tech.result.PageResult;

import java.util.List;

public interface CategoryService {
    void save(CategoryDTO categoryDTO);
    void deleteById(Long id);
    void startOrStop(Integer status, Long id);
    void update(CategoryDTO categoryDTO);
    List<Category> list(Integer type);
    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);
}
