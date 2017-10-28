package application;
	
import java.io.File;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	Player player;
	FileChooser fileChooser;
	
	@Override
	public void start(final Stage primaryStage) throws MalformedURLException {
		MenuItem open = new MenuItem("Open");
		Menu file = new Menu("File");
		MenuBar menu = new MenuBar();
		
		file.getItems().add(open);
		menu.getMenus().add(file);
		fileChooser = new FileChooser();
		open.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				//player.player.pause();
				File file = fileChooser.showOpenDialog(primaryStage);
				if(file !=null){
					try {
						player = new Player(file.toURI().toURL().toExternalForm());
						Scene scene = new Scene(player,720,535,Color.BLACK);
						primaryStage.setScene(scene);
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		File file2 = new File("src/sampleVideo.mp4");
		//final String file1 = "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";
		//final String file2 = "../sampleVideo.mp4";
		Player player = new Player(file2.toURI().toURL().toString());
		player.setTop(menu);
		Scene scene = new Scene(player,720,535,Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
