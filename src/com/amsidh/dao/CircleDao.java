package com.amsidh.dao;

import java.util.List;

import com.amsidh.model.Circle;

public interface CircleDao {
   public Circle getCircle(int circleId);
   public int getCircleCount();
   public Circle getCircleById(int circleId);
   public List<Circle> getAllCircle();
}
