package com.example.formvalidationproject.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.*;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.formvalidationproject.*;


@Controller
public class Page1Controller implements Initializable{
	
	@Autowired
	UsersAdapterImpl userAdapter;
	
	String fname, mname, lname, suffix, age, pnum, email, gender, output, newfname, newmname,newlname, newemail;
	Integer newage;
	String[] word;
	StringBuilder outputBuilder = new StringBuilder();
	
	@FXML
	public TextField fnametext, mnametext, lnametext, sufxtext, pnumtext, emailtext, agetext;
	
	@FXML
	public Label errfname, errmname, errlname, errphone, erremail, errage, errsuffix;

	@FXML
	public RadioButton malerbtn,fmalerbtn;
	
	@FXML
	public ToggleGroup genderchoice;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		//check if textfield is empty
		checker();
		characterchecker();
		
		
		
		//RadioButton Grouping
		genderchoice = new ToggleGroup();
		malerbtn.setToggleGroup(genderchoice);
        fmalerbtn.setToggleGroup(genderchoice);
        
        genderchoice.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				if (genderchoice.getSelectedToggle() != null) {
					gender = genderchoice.getSelectedToggle().getUserData().toString();
                }
				
			}
		});
	
	}
	
	public void next() {
		converter();
		if(fnametext.getText().isEmpty() == false && mnametext.getText().isEmpty() == false && lnametext.getText().isEmpty() == false &&
		   pnumtext.getText().isEmpty() == false && emailtext.getText().isEmpty() == false && agetext.getText().isEmpty() == false) {
			
			userAdapter.setUsers(newfname, newmname, newlname, suffix, gender, newage, pnum, newemail);
			
			fnametext.setText("");
			mnametext.setText("");
			lnametext.setText("");
			sufxtext.setText("");
			pnumtext.setText("");
			emailtext.setText("");
			agetext.setText("");
			malerbtn.setSelected(false);
			fmalerbtn.setSelected(false);	
		}
	}
	
	public void clear() {
		fnametext.setText("");
		mnametext.setText("");
		lnametext.setText("");
		sufxtext.setText("");
		pnumtext.setText("");
		emailtext.setText("");
		agetext.setText("");
		malerbtn.setSelected(false);
		fmalerbtn.setSelected(false);
	}
	
	public void checker() {
		if(fnametext.getText().isEmpty() &&
		mnametext.getText().isEmpty() &&
		lnametext.getText().isEmpty() &&
		pnumtext.getText().isEmpty() &&
		emailtext.getText().isEmpty() &&
		agetext.getText().isEmpty()) {
			errfname.setText("*");
			errmname.setText("*");
			errlname.setText("*");
			errphone.setText("*");
			erremail.setText("*");
			errage.setText("*");		
		}
	}
	
	public void characterchecker() {
		//firstname checker
		fnametext.textProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.length() == 1 || newValue.length() > 100) {
                errfname.setText("must be between 2 and 100 characters.");
            } 
			else if(newValue.length() == 0) {
				errfname.setText("*");
			}
			else {
                errfname.setText("");
                fname = newValue;
            }
		});
		
		//Middle Name Checker
		mnametext.textProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.length() == 1 || newValue.length() > 100) {
                errmname.setText("must be between 2 and 100 characters.");
            }
			else if(newValue.length() == 0) {
				errmname.setText("*");
			}
			else {
                errmname.setText("");
                mname = newValue;
            }
		});
		
		//Last Name Checker
		lnametext.textProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.length() == 1 || newValue.length() > 100) {
                errlname.setText("must be between 2 and 100 characters.");
            } 
			else if(newValue.length() == 0) {
				errlname.setText("*");
			}
			else {
                errlname.setText("");
                lname = newValue;
                
            }
			
		});
		
		//Age Checker
		agetext.textProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.isEmpty()) {
				errage.setText("*");
			}
			else if (!isValidAge(newValue)) {
                errage.setText("Age must be a number.");
            } 
			else if(newValue.length() > 3) {
				errage.setText("Age must be less than 1000");
			}
            else {
                errage.setText("");
                age = newValue;
            }
        });	
		
		//Suffix Checker
		sufxtext.textProperty().addListener((observable, oldValue, newValue) ->{
			if(newValue.length() > 100) {
				errlname.setText("Text Must be less than 100");
			}
			else {
				suffix = newValue;
			}
		});
		
		//Mobile Number Checker
		pnumtext.textProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.isEmpty()) {
				errphone.setText("*");
			}
			else if (!isValidAge(newValue)) {
                errphone.setText("Phone must be a number.");
            } 
			else if(newValue.length() != 11) {
				errphone.setText("Phone number must be 11 digit numbers");
			}
            else {
                errphone.setText("");
                pnum = newValue;
            }
        });	
		
		//Email Address Checker
		emailtext.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!isValidEmail(newValue)) {
                erremail.setText("Please enter a valid email address.");
            } else {
                erremail.setText("");
                email = newValue;
            }
        });
	}
	
	public void converter() {
		if(fname != null) {
			word = fname.split(" ");
	        for (String letter : word) {
	            if (!letter.isEmpty()) {
	                String capitalizedWord = letter.substring(0, 1).toUpperCase() + letter.substring(1);
	                outputBuilder.append(capitalizedWord).append(" ");
	            }
	        }
	        output = outputBuilder.toString().trim();
	        newfname = output;
	        outputBuilder.setLength(0);
		}
		
		if(mname != null) {
			word = mname.split(" ");
	        for (String letter : word) {
	            if (!letter.isEmpty()) {
	                String capitalizedWord = letter.substring(0, 1).toUpperCase() + letter.substring(1);
	                outputBuilder.append(capitalizedWord).append(" ");
	            }
	        }
	        output = outputBuilder.toString().trim();
	        newmname = output;
	        outputBuilder.setLength(0);
		}
		
		if(lname != null) {
			word = lname.split(" ");
	        for (String letter : word) {
	            if (!letter.isEmpty()) {
	                String capitalizedWord = letter.substring(0, 1).toUpperCase() + letter.substring(1);
	                outputBuilder.append(capitalizedWord).append(" ");
	            }
	        }
	        output = outputBuilder.toString().trim();
	        newlname = output;
	        outputBuilder.setLength(0);
		}
		
		if(age != null) {
			newage = Integer.parseInt(age);
		}
		
		if(suffix != null) {
			suffix = suffix.toUpperCase();
		}
		
		if(email != null) {
			newemail = email;
		}
		
	
	}
	
	private boolean isValidAge(String age) {
        // check if age is a number
        return age.matches("\\d+");
    }
	
	private boolean isValidEmail(String email) {
        // check if email contains an "@" symbol and a period character
        return email.matches("^.+@.+\\..+$");
    }
}
