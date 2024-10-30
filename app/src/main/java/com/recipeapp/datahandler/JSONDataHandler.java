package main.java.com.recipeapp.datahandler;

import com.recipeapp.model.Recipe;
import java.io.IOException;
import java.util.ArrayList;

public class JSONDataHandler implements DataHandler {
    //getModeのオーバーライド
    @Override
    public String getMode() {
        return "JSON";
    }
    //readDataのオーバーライド
    @Override
    public ArrayList<Recipe> readData() throws IOException {
        return null; 
    }
    //writeDataのオーバーライド
    @Override
    public void writeData(Recipe recipe) throws IOException {
        
    }
    //searchDataのオーバーライド
    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null; 
    }
}