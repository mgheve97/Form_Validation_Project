package com.example.formvalidationproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class FormvalidationProjectApplication extends Application {
	
	@Autowired
	UsersAdapterImpl userAdapter;
	
	private ConfigurableApplicationContext springcontext;
	private Parent rootNode;
	private FXMLLoader fxmlloader;
	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws Exception {
		springcontext=SpringApplication.run(FormvalidationProjectApplication.class);
		fxmlloader = new FXMLLoader();
		fxmlloader.setControllerFactory(springcontext::getBean);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		fxmlloader.setLocation(getClass().getResource("/fxml/page1scene.fxml"));
		rootNode = fxmlloader.load();
		primaryStage.setTitle("Form Validation - Page 1");
		Scene scene = new Scene(rootNode);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	
}
