package com.homework.view;

import com.homework.domain.food;

import java.util.List;

public interface foodview {
    public void showFoodList(int businessId);
    public void saveFood(int businessId);
    public void updateFood();
    public void removeFood();

}
