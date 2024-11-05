package com.recipeapp.model;
import java.util.ArrayList;

//エラーmodel
import com.recipeapp.model.Ingredient;

public class Recipe {
    
        private String name;
        private ArrayList<Ingredient> ingredients= new ArrayList<>();

        //コンストラクタ
        public Recipe (String name, ArrayList<Ingredient> ingredients){
            this.name = name;
            this.ingredients = ingredients;
        }

        //nameのゲッター
        public String getName() {
            return name;
        }
        // nameのセッター
        public void setName(String name) {
            this.name = name;
        }

        //ingredientsのゲッター
        public ArrayList<Ingredient> getIngredients() {
            return ingredients;
        }
        //ingredientsのセッター
        public void setIngredients(ArrayList<Ingredient> ingredients) {
            this.ingredients = ingredients;
        }
    
}
