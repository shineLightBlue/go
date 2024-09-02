package com.tech.mapper;

import com.github.pagehelper.Page;
import com.tech.dto.CategoryPageQueryDTO;
import com.tech.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Insert("insert into category(type,name,sort,status,create_time,update_time,create_user,update_user)"+
    " VALUES" + " (#{type}, #{name}, #{sort}, #{status}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    void insert(Category category);

    @Delete("delete from category where id = #{id}")
    void deleteById(Long id);

    void update(Category category);

    List<Category> list(Integer type);

    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);
}
