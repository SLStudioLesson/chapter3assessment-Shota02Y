package main.java.com.recipeapp.model;
import java.util.ArrayList;

import main.java.com.recipeapp.Ingredient;

public class Recipe {
    
    public class Recipe{
            private String name;
            private ArrayList<Ingredient> Ingredients= new ArrayList<>();

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
    //displayMenuメソッド
    public void displayMenu(){
        System.out.println("Main Menu:");
        System.out.println("1: Display Recipes");
        System.out.println("2: Add New Recipe");
        System.out.println("3: Search Recipe");
        System.out.println("4: Exit Application");
        System.out.print("Please choose an option: ");
    }
}
