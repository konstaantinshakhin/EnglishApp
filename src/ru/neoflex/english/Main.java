
package ru.neoflex.english;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import ru.neoflex.english.controller.PanelQuestionsController;
import ru.neoflex.english.model.FileManager;
import ru.neoflex.english.model.StringOfText;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private FileManager fm;
    private ObservableList<StringOfText> stringData = FXCollections.observableArrayList();
    
    public Main() throws Exception {
    	fm = new FileManager();
    	 Map<Integer,StringOfText> mapStr =  fm.readFile(null);
    	 for(Entry<Integer,StringOfText> entry : mapStr.entrySet()) {
    		 stringData.add(entry.getValue());
    	 }
        // Add some sample data
//        stringData.add(new  StringOfText("You should visit  the  dentist","Вам следует сходить\n к стоматологу"));
    
//        stringData.add(new  StringOfText("Hello World","Привет Мир"));
    }
    
    public ObservableList<StringOfText> getStringData(){
    	return stringData;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("EnglishApp");

        initRootLayout();

        showStringOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showStringOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/PanelQuestionsView.fxml"));
            AnchorPane panelOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(panelOverview);
            
            PanelQuestionsController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}