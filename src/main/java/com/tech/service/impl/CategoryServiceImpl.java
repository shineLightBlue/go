package com.tech.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tech.constant.StatusConstant;
import com.tech.context.BaseContext;
import com.tech.dto.CategoryDTO;
import com.tech.dto.CategoryPageQueryDTO;
import com.tech.entity.Category;
import com.tech.mapper.CategoryMapper;
import com.tech.mapper.DishMapper;
import com.tech.mapper.SetmealMapper;
import com.tech.result.PageResult;
import com.tech.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private SetmealMapper setmealMapper;

    @Override
    public void save(CategoryDTO categoryDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO,category);
        category.setStatus(StatusConstant.DISABLE);
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        category.setCreateUser(BaseContext.getCurrentId());
        category.setUpdateUser(BaseContext.getCurrentId());
        categoryMapper.insert(category);
    }

    @Override
    public void deleteById(Long id) {
        Integer count = dishMapper.countByCategory(id);
        if(count>0){
            return;
        }
        count = setmealMapper.countByCategoryId(id);
        if(count<0){
            return;
        }
        categoryMapper.deleteById(id);
    }

    @Override
    public void startOrStop(Integer status, Long id) {
        Category category = Category.builder().id(id).status(status).updateTime(LocalDateTime.now()).updateUser(BaseContext.getCurrentId()).build();
        categoryMapper.update(category);
    }

    @Override
    public void update(CategoryDTO categoryDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO,category);
        category.setUpdateTime(LocalDateTime.now());
        category.setUpdateUser(BaseContext.getCurrentId());
        categoryMapper.update(category);
    }

    @Override
    public List<Category> list(Integer type) {
        return categoryMapper.list(type);
    }

    @Override
    public PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageHelper.startPage(categoryPageQueryDTO.getPage(),categoryPageQueryDTO.getPageSize());
        Page<Category> page = categoryMapper.pageQuery(categoryPageQueryDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }
}
