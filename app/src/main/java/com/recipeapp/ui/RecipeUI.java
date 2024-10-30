package com.recipeapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.recipeapp.datahandler.DataHandler;

public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;

    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }
    private void displayRecipes(){
        List<Recipe> recipes = dataHandler.readData();
        if (recipes.isEmpty()) {
            System.out.println("No recipes available.");
            return;
        }
        System.out.println();
        System.out.println("Recipes:");
        System.out.println("-----------------------------------");
        for (String recipe : recipes) {
            String[] parts = recipe.split(",", 2);
            System.out.println("Recipe Name: " + parts[0]);
            if (parts.length > 1) {
                System.out.println("Main Ingredients: " + parts[1]);
            }
            System.out.println("-----------------------------------");
        }
    }
    private void addNewRecipe(){
        System.out.println("Adding a new recipe");
        System.out.print("Enter recipe name: ");
        String name = reader.readLine();
        System.out.print("Enter ingredients (type 'done' when finished): ");
        
        while(true){
            System.out.println("Ingredient: ");
            String ingredients = reader.readLine();
            if (input.equals("done")){
                System.out.println("Recipe added successfully.");
                break;
            }
        }
        String ingredients = reader.readLine();

        fileHandler.addRecipe(name, ingredients);
        System.out.println("Recipe added successfully.");
    }
    private String ArrayList<Recipe> searchData(){
        
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
