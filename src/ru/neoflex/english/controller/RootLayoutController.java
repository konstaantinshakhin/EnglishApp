package ru.neoflex.english.controller;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;

import org.controlsfx.dialog.Dialogs;

import ru.neoflex.english.Main;
import ru.neoflex.english.model.FileManager;
import ru.neoflex.english.model.StringOfText;

public class RootLayoutController {
	 private Main main;
	 private FileManager fm;
	 private ObservableList<StringOfText> stringData = FXCollections.observableArrayList();

	    /**
	     * Is called by the main application to give a reference back to itself.
	     * 
	     * @param mainApp
	     */
	    public void setMainApp(Main main) {
	        this.main = main;
	    }

	    /**
	     * Creates an empty address book.
	     */
	    

	    /**
	     * Opens a FileChooser to let the user select an address book to load.
	     */
	    @FXML
	    private MenuItem fileOpen;
	    
	    @FXML
	    private MenuItem helpAbout;
	    
	    @FXML
	    private void handleOpen() throws Exception {
	        FileChooser fileChooser = new FileChooser();

	        // Set extension filter
	        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
	                "TXT files (*.txt)", "*.txt");
	        fileChooser.getExtensionFilters().add(extFilter);

	        // Show save file dialog
	        File file = fileChooser.showOpenDialog(main.getPrimaryStage());

	        if (file != null) {
	           // main.loadPersonDataFromFile(file);
	        	fm = new FileManager();
	        	Map<Integer, StringOfText> mapStr = new HashMap<Integer, StringOfText>();
			
				mapStr = fm.readFile(file);
			
			
		
			
	       	 main.getStringData().removeAll(main.getStringData());
	       	 for(Entry<Integer,StringOfText> entry : mapStr.entrySet()) {
	       		 main.getStringData().add(entry.getValue());
	       		
	       	 }
	        }
	    }
	    
	    @FXML
	    private void handleAbout() {
	        Dialogs.create()
	            .title("AddressApp")
	            .masthead("About")
	            .message("Author: Marco Jakob\nWebsite: http://code.makery.ch")
	            .showInformation();
	    }

	    /**
	     * Closes the application.
	     */
	    @FXML
	    private void handleExit() {
	        System.exit(0);
	    }

}
