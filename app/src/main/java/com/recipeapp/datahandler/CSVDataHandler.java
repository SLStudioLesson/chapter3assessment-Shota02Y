package com.recipeapp.datahandler;

import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CSVDataHandler implements DataHandler {
    private String filePath; // レシピデータを格納するCSVファイルのパス

    // デフォルトコンストラクタ
    public CSVDataHandler() {
        filePath = "app/src/main/resources/recipes.csv";
    }

    // 引数付きコンストラクタ
    public CSVDataHandler(String filePath) {
        this.filePath = filePath;
    }

    // 文字列CSVを返す
    @Override
    public String getMode() {
        return "CSV";
    }

    // 問5
    public ArrayList<Recipe> readData() throws IOException {
        // レシピリストの初期化
        ArrayList<Recipe> recipes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // ファイルの読み込み
            while ((line = reader.readLine()) != null) {
                // レシピ名と材料名を
                String[] parts = line.split(",", 2);
                // line splitで料理名を
                String recipeName = parts[0];
                ArrayList<Ingredient> ingredients = new ArrayList<>();
                // ingredient
                String[] ingredientNames = parts[1].split(",");
                for (String ingredientName : ingredientNames) {
                    // 材料のインスタンス作成
                    Ingredient ingredient = new Ingredient(ingredientName);
                    // 読み込んだingredientsを追加
                    ingredients.add(ingredient);
                }
                // レシピのインスタンス作成
                Recipe recipe = new Recipe(recipeName, ingredients);
                // 読み込んだレシピを追加
                recipes.add(recipe);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return recipes; // レシピのリストを返す
    }// メソッド

    @Override
    public void writeData(Recipe recipe) throws IOException {
        String line ="";
        line += recipe.getName() + ","; // Tomato Soup,
        // 1. recipeオブジェクトよりingredientsフィールドを取り出し、要素を先頭から順に取り出す
        ArrayList<Ingredient> ingredients = recipe.getIngredients();
        // ループ回数用の変数を用意する
        int count = 0;
        // 材料リストの件数分、ループする
        for (Ingredient ingredient : recipe.getIngredients()) {
            // 2. 取り出したingreditentより材料名を取り出し、行文字列と結合する。
            // 材料名を文字連結する
            line += ingredient.getName();
            // ループ回数が最終回でなければカンマ、スペースを連結する
            if (count < recipe.getIngredients().size() - 1) {
                line += ", ";
            }
            // ループ回数をカウントアップする
            count++;
        }
        // 4. 行文字列をrecipes.csvに書き出す
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {
            writer.newLine();
            writer.write(line);
            // writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //問7
    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null;
    }
}
