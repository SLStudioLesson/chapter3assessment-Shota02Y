package com.recipeapp.model;

public class Ingredient {
    private String name; // 材料の名前

    public Ingredient(String name){
        this.name = name;
    }
    
    // ゲッター
    public String getName() {
        return name;
    }

    // セッター
    public void setName(String name) {
        this.name = name;
    }
}