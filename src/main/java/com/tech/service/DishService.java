package com.tech.service;

import com.tech.dto.DishDTO;
import com.tech.dto.DishPageQueryDTO;
import com.tech.result.PageResult;

import java.util.List;

public interface DishService {
    void saveWithFlavor(DishDTO dishDTO);
    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);
    void deleteBatch(List<Long> ids);
}
