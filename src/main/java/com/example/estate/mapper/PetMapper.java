package com.example.estate.mapper;

import com.example.estate.entity.Pet;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
/**
 * @author 22973
 */
@Repository
public interface PetMapper extends Mapper<Pet> {
}
