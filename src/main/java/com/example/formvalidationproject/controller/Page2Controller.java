package com.example.formvalidationproject.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.formvalidationproject.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.*;

@Controller
public class Page2Controller implements Initializable{
	
	@Autowired
	UseraddressAdapterImpl userAdapter2;
	
	public String country, house, street, brgy, city, province, zipcode, output;
	public String newcountry, newhouse, newstreet, newbrgy, newcity, newprovince, newzipcode;
	String[] word;
	StringBuilder outputBuilder = new StringBuilder();
	
	@FXML
	public TextField countrytext, housetext, streettext, brgytext, citytext, provincetext, zipcodetext;
	
	@FXML
	public Label errcountry, errhousenum, errstreet, errbrgy, errcity, errprovince, errzipcode	;
	
	@FXML
	public Button submitbtn;
	
	
	public void back(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/page1scene.fxml"));
		Parent root = loader.load();
	    Scene newScene = new Scene(root);
	    Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    primaryStage.setTitle("Form Validation - Page 1");
	    primaryStage.setResizable(false);
	    primaryStage.setScene(newScene);
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		checkeraddress();
		addresschecker();
	}
	
	public void send(ActionEvent event) throws Exception{
		converter();
		if(countrytext.getText().isEmpty() ||
		housetext.getText().isEmpty() ||
		streettext.getText().isEmpty() ||
		citytext.getText().isEmpty() ||
		provincetext.getText().isEmpty() ||
		zipcodetext.getText().isEmpty()) {
			errcountry.setText("*");
			errhousenum.setText("*");
			errstreet.setText("*");
			errbrgy.setText("*");
			errcity.setText("*");
			errprovince.setText("*");	
			errzipcode.setText("*");
		}
		
		else {
			
			userAdapter2.setuseraddress(newcountry, newhouse, newstreet, newbrgy, newcity, newprovince, newzipcode);
			
			countrytext.setText("");
			housetext.setText("");
			streettext.setText("");
			brgytext.setText("");
			citytext.setText("");
			provincetext.setText("");
			zipcodetext.setText("");
			
			
			
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/page3scene.fxml"));
//			Parent root = loader.load();
//		    Scene newScene = new Scene(root);
//		    Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//		    primaryStage.setTitle("Form Validation - Page 3");
//		    primaryStage.setResizable(false);
//		    primaryStage.setScene(newScene);
		}
	}

	public void checkeraddress() {
		if(countrytext.getText().isEmpty() &&
		housetext.getText().isEmpty() &&
		streettext.getText().isEmpty() &&
		brgytext.getText().isEmpty() &&
		citytext.getText().isEmpty() &&
		provincetext.getText().isEmpty() &&
		zipcodetext.getText().isEmpty()) {
			errcountry.setText("*");
			errhousenum.setText("*");
			errstreet.setText("*");
			errbrgy.setText("*");
			errcity.setText("*");
			errprovince.setText("*");	
			errzipcode.setText("*");
		}
	}
	
	public void clear_page2() {
		countrytext.setText("");
		housetext.setText("");
		streettext.setText("");
		brgytext.setText("");
		citytext.setText("");
		provincetext.setText("");
		zipcodetext.setText("");
	}
	
	public void addresschecker() {
		
		countrytext.textProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.length() == 0) {
				errcountry.setText("*");
			}
			else {
                errcountry.setText("");
                country = newValue;
            }
		});
		
		housetext.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.contains("Block") && newValue.contains("Lot") || 
            	newValue.contains("Blk") && newValue.contains("L") ||
            	newValue.contains("block") && newValue.contains("lot") ||
            	newValue.contains("blk") && newValue.contains("l")) {
            	errhousenum.setText("");
            	house = newValue;
            } 
            else {
                errhousenum.setText("It must contain Block/Blk and Lot/L");
            }
            
		});
		
		streettext.textProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.length() == 0) {
				errstreet.setText("*");
			}
			else {
                errstreet.setText("");
                street = newValue;
            }
		});
		
		brgytext.textProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.length() == 0) {
				errstreet.setText("");
				brgy = newValue;
			}
			else {
				errstreet.setText("");
                brgy = newValue;
            }
			
		});
		
		citytext.textProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.length() == 0) {
				errcity.setText("");
				city = newValue;
			}
			else {
                errcountry.setText("");
                city = newValue;
            }
		});
		provincetext.textProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.length() == 0) {
				errprovince.setText("");
				province = newValue;
			}
			else {
                errprovince.setText("");
                province = newValue;
            }
		});
		
		zipcodetext.textProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.length() == 0) {
				errzipcode.setText("");
				zipcode = newValue;
			}
			else {
                errzipcode.setText("");
                zipcode = newValue;
            }
		});
	}
	
	public void converter() {
		if(country != null) {
			word = country.split(" ");
	        for (String letter : word) {
	            if (!letter.isEmpty()) {
	                String capitalizedWord = letter.substring(0, 1).toUpperCase() + letter.substring(1);
	                outputBuilder.append(capitalizedWord).append(" ");
	            }
	        }
	        output = outputBuilder.toString().trim();
	        newcountry = output;
	        outputBuilder.setLength(0);
		}
		
		if(house != null) {
			word = house.split(" ");
	        for (String letter : word) {
	            if (!letter.isEmpty()) {
	                String capitalizedWord = letter.substring(0, 1).toUpperCase() + letter.substring(1);
	                outputBuilder.append(capitalizedWord).append(" ");
	            }
	        }
	        output = outputBuilder.toString().trim();
	        newhouse = output;
	        outputBuilder.setLength(0);
		}
		
		if(street != null) {
			word = street.split(" ");
	        for (String letter : word) {
	            if (!letter.isEmpty()) {
	                String capitalizedWord = letter.substring(0, 1).toUpperCase() + letter.substring(1);
	                outputBuilder.append(capitalizedWord).append(" ");
	            }
	        }
	        output = outputBuilder.toString().trim();
	        newstreet = output;
	        outputBuilder.setLength(0);
		}
		if(brgy != null) {
			word = brgy.split(" ");
	        for (String letter : word) {
	            if (!letter.isEmpty()) {
	                String capitalizedWord = letter.substring(0, 1).toUpperCase() + letter.substring(1);
	                outputBuilder.append(capitalizedWord).append(" ");
	            }
	        }
	        output = outputBuilder.toString().trim();
	        newbrgy = output;
	        outputBuilder.setLength(0);
		}
		if(city != null) {
			word = city.split(" ");
	        for (String letter : word) {
	            if (!letter.isEmpty()) {
	                String capitalizedWord = letter.substring(0, 1).toUpperCase() + letter.substring(1);
	                outputBuilder.append(capitalizedWord).append(" ");
	            }
	        }
	        output = outputBuilder.toString().trim();
	        newcity = output;
	        outputBuilder.setLength(0);
		}
		if(province != null) {
			word = province.split(" ");
	        for (String letter : word) {
	            if (!letter.isEmpty()) {
	                String capitalizedWord = letter.substring(0, 1).toUpperCase() + letter.substring(1);
	                outputBuilder.append(capitalizedWord).append(" ");
	            }
	        }
	        output = outputBuilder.toString().trim();
	        newprovince = output;
	        outputBuilder.setLength(0);
		}
		if(zipcode != null) {
			word = zipcode.split(" ");
	        for (String letter : word) {
	            if (!letter.isEmpty()) {
	                String capitalizedWord = letter.substring(0, 1).toUpperCase() + letter.substring(1);
	                outputBuilder.append(capitalizedWord).append(" ");
	            }
	        }
	        output = outputBuilder.toString().trim();
	        newzipcode = output;
	        outputBuilder.setLength(0);
		}
	}
}
