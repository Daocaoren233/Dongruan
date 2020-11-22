package com.homework.dao;

import com.homework.domain.food;

import java.util.List;

public interface fooddao {
    public List<food> listFoodByBusinessId(int businessId);
    public int saveFood(food fo);
    public int updateFood(food fo);
    public int removeFood(int foodId);
    public food getFoodByfoodId(int foodId);
}
