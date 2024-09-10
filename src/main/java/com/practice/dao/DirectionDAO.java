package com.practice.dao;

import com.practice.entities.Direction;
import com.practice.entities.Employee;

import java.util.List;

public interface DirectionDAO {

    List<Direction> findAll();

    Direction findById(Long id);

   Direction create(Direction direction);

   Direction update (Direction direction);

   boolean deleteById(Long id);

}
