package ru.neoflex.english.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ru.neoflex.english.model.StringOfText;
import ru.neoflex.english.Main;


public class PanelQuestionsController {
	
	@FXML
    private TableView<StringOfText> txtTable;
	
    @FXML
    private TableColumn<StringOfText, String> materialColumn;
    
    @FXML
    private Label textRightLabel;
    
    @FXML
    private Label textLeftLabel;
    

    // Reference to the main application.
    private Main main;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PanelQuestionsController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
    	materialColumn.setCellValueFactory(cellData -> cellData.getValue().engStringProperty());
    	
    	showTextDetails(new StringOfText("You should visit  the  dentist","Вам следует сходить\n к стоматологу"));
    }
    private void showTextDetails(StringOfText strTxt) {
        if (strTxt != null) {
            // Fill the labels with info from the person object.
        	String str = strTxt.getEnglishRandomString();
        	textRightLabel.setText(str);
        	textLeftLabel.setText(strTxt.getRusString());
        	
        	
//        	textRitghLabel.setText("the should visit You dentist");
//        	textLeftLabel.setText("Вам следует сходить к стоматологу");
           
        } else {
            // Person is null, remove all the text.
        	textRightLabel.setText("");
        	textLeftLabel.setText("");
            
        }
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(Main main) {
        this.main = main;

        // Add observable list data to the table
       txtTable.setItems(main.getStringData());
    }

}
