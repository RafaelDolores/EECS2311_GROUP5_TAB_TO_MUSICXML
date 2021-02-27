package Interface;

import java.awt.Desktop;

import java.io.*;
import java.net.URL;
import java.util.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;
import TAB_TO_XML.App;
import TAB_TO_XML.Parser;

public class Controller {

	Desktop screen = Desktop.getDesktop();
	Window window;
	File tablature;
	File xmlFile;
	BufferedReader input;
	StreamResult output;
	FileChooser fc, saveFile;
	
	@FXML
	AnchorPane anchorpane;

	@FXML
	Button browse, convert, save;

	@FXML
	Label path;

	@FXML
	TextArea view, write;
	
	/**
	 * This method enables browsing through the file explorer for .txt files. After browsing, it shows the text on the file in a 
	 * text area. 
	 * @param event
	 */
	
	@FXML
	public void handleButtonBrowse(ActionEvent event) {
		write.clear();
		fc = new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
		tablature = fc.showOpenDialog(null);

		if (tablature != null) {
			path.setText(tablature.getAbsolutePath());
			Scanner sc = null;
			save.setVisible(true);
			try {
				sc = new Scanner(tablature);
				while (sc.hasNextLine()) {
					write.appendText(sc.nextLine() + "\n"); // else read the next token
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	/**
	 * This method handles the convert button in the Graphic User Interface. It shows an alert once the file is converted.
	 * @param event
	 */

	@FXML
	public void handleButtonConvert(ActionEvent event) {
		view.clear();
		try {
				String storeText = write.getText();
				Parser.setText(storeText);
				App.main(null);
				String getConversion = App.getConversion();
				view.appendText(getConversion);
				save.setDisable(false);
		}
		catch (Exception e) {
			Alert errorAlert = new Alert(AlertType.ERROR); 
			errorAlert.setHeaderText("Input not valid!"); 
			errorAlert.setContentText("Provide text file."); 
			errorAlert.showAndWait();
		}
	}

	/**
	 * This is the method that controls the save button in the User Interface.
	 * @param event
	 */
	@FXML
	public void handleButtonSave(ActionEvent event) {
		saveFile = new FileChooser();
		FileChooser.ExtensionFilter extension = new FileChooser.ExtensionFilter("musicXML files", "*.musicxml");
		saveFile.getExtensionFilters().add(new ExtensionFilter("musicXML files", "*.musicxml"));
		xmlFile = saveFile.showSaveDialog(null);
		PrintWriter write = null;
		try {
			write = new PrintWriter(xmlFile.getAbsolutePath());
			write.println(view.getText());
			Alert saveAlert = new Alert(AlertType.CONFIRMATION); //creates a displayable error allert window 
			saveAlert.setHeaderText("The converted file has been saved to " + xmlFile.getAbsolutePath()); 
			saveAlert.setContentText("Thank you for using Allegro Tab Converter!"); //Shows this stage and waits for it to be hidden (closed) before returning to the caller.
			saveAlert.showAndWait();
		}
		catch(Exception e) {
			Alert errorAlert = new Alert(AlertType.ERROR); 
			errorAlert.setHeaderText("File cannot be saved!"); 
			errorAlert.setContentText("Please convert a file in order to save it!"); 
			errorAlert.showAndWait();
		}
		finally {
			write.close();
		}

	}
}
