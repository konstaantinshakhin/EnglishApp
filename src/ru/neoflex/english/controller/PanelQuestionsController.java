package ru.neoflex.english.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
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
    
    @FXML
    private CheckBox chksHint;
    

    // Reference to the main application.
    private Main main;
    
    private boolean hint = false;

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
    	materialColumn.setCellValueFactory(cellData -> cellData.getValue().rusStringProperty());
    	showTextDetails(null);
    	 chksHint.setOnAction(e -> handleButtonAction(e));
        // Listen for selection changes and show the person details when changed.
        txtTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showTextDetails(newValue));
    	
    	
    }
    private void showTextDetails(StringOfText strTxt) {
        if (strTxt != null && !hint) {
            // Fill the labels with info from the person object.
        	textRightLabel.setText(strTxt.getEnglishRandomString());
        	textLeftLabel.setText(strTxt.getRusString());
        	
        } else if (strTxt != null && hint)  {
        	textRightLabel.setText(strTxt.getEngString());
        	textLeftLabel.setText(strTxt.getRusString());
            
        } else{
        	textRightLabel.setText("");
        	textLeftLabel.setText("");
        }
    }
    @FXML
    private void handleButtonAction(ActionEvent e) {
        
        if(chksHint.isSelected())
        	
        		hint = true;
        if(!chksHint.isSelected()){
        		hint = false;
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
