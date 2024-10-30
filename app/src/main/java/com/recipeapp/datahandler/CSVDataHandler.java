package main.java.com.recipeapp.datahandler;

import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Recipe;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;

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

    // 
    @Override
    public ArrayList<Recipe> readData() throws IOException {
        return null; 
    }
    //問5
    @Override
    public void writeData(Recipe recipe) throws IOException {
        String ingredients = reader.readLine();
        fileHandler.addNewRecipe(ingredients);
    }

    //
    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null;
    }
}