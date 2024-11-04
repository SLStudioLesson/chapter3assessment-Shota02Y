// package com.recipeapp.ui;
package com.recipeapp.ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;
    private String filePath;

    public CSVDataHandler() {
        filePath = "app/src/main/resources/recipes.csv";
    }

    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }

    private void displayRecipes() {
        // returnするrecipes
        try {
            // dataHandlerオブジェクトのreadDataメソッドでレシピのリストを取得→recipeDataに格納
            ArrayList<Recipe> recipeData = dataHandler.readData();

            if (recipeData.isEmpty()) {
                System.out.println("No recipes available.");
                return;
            }
            System.out.println("Recipes:");
            System.out.println("-----------------------------------");
            // recipeDataリストに含まれる各レシピに対してループ
            for (Recipe recipe : recipeData) {
                System.out.println("Recipe Name: " + recipe.getName());

                System.out.print("Main Ingredirnts: ");

                for (Ingredient ingredient : recipe.getIngredients()) {
                    System.out.print(ingredient.getName() + ", ");
                }
                System.out.println();
                System.out.println("-----------------------------------");

            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return;
    }
    // ファイルを読み込む。1行ずつデータ取り出し
    // レシピ名（String）と材料（Stringの配列）に分けておく

    // recipesをreturnする
    // 問6
    private void addNewRecipe() {
        try {
            System.out.println("Adding a new recipe");
            System.out.print("Enter recipe name: ");
            String name = reader.readLine();
            System.out.println("Enter ingredients (type 'done' when finished): ");
            ArrayList<Ingredient> ingredientsList = new ArrayList<>();
            while (true) {
                System.out.print("Ingredient: ");
                String ingredients = reader.readLine();
                if (ingredients.equals("done")) {
                    System.out.println("Recipe added successfully.");
                    break;
                }
                // Ingredientオブジェクトを作成し、リストに追加
                ingredientsList.add(new Ingredient(ingredients));
            }
            // 新しいレシピオブジェクトを作成する
            Recipe newRecipe = new Recipe(name, ingredientsList);
            dataHandler.writeData(newRecipe);
        } catch (IOException e) {
            System.out.println("Failed to add new recipe:" + e.getMessage());
        }
    }

    public void displayMenu() {
        System.out.println("Current mode: " + dataHandler.getMode());
        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        displayRecipes();
                        break;
                    case "2":
                        addNewRecipe();
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }
}