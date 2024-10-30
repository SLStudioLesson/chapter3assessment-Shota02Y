import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.datahandler.JSONDataHandler;
import com.recipeapp.ui.RecipeUI;
import java.io.*;

public class App {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");
            String choice = reader.readLine();
            DataHandler dataHandler;

            switch (choice) {
                case "1":
                    // CSVが選ばれた場合はCSVDataHandlerのインスタンス生成
                    dataHandler = new CSVDataHandler();
                    System.out.println("Current mode: " + dataHandler.getMode());
                    break;
                case "2":
                    // JSONが選ばれた場合はJSONDataHandlerのインスタンス生成
                    dataHandler = new JSONDataHandler();
                    System.out.println("Current mode: " + dataHandler.getMode());
                    break;
                default:
                    // 不正な入力の場合はCSVDataHandlerのインスタンス生成
                    dataHandler = new CSVDataHandler();
                    System.out.println("Current mode: " + dataHandler.getMode());
                    break;
            }
            // RecipeUIにデータハンドラーを渡してメインメニューを表示
            RecipeUI recipeUI = new RecipeUI(dataHandler);
            recipeUI.displayMenu();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}