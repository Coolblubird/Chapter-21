import java.net.URL;
import java.util.HashMap;
import java.io.*;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.beans.*;
import java.util.*;
import java.net.*;


public class Exercise21_11 extends Application{
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		List<Map<String, Integer>> mapForBoy = new ArrayList<Map<String, Integer>>();
		List<Map<String, Integer>> mapForGirl = new ArrayList<Map<String, Integer>>();
		
		Button btFindRanking = new Button("Find Ranking");
		ComboBox<Integer> cboYear = new ComboBox<>();
		ComboBox<String> cboGender = new ComboBox<>();
		TextField tfName = new TextField();
		Label lblResult = new Label();
		
		try {
			for (int i = 1; i < 11; i++) {
				URL url;
				url = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking" + (2000 + i) + ".txt");
				BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
				Character line='1';
				ArrayList<Character> word = new ArrayList<>();
				String newWord;
				int placement = 1;
				Map<String,Integer> temp1 = new HashMap<String,Integer>(10);
				Map<String,Integer> temp2 = new HashMap<String,Integer>(10);
				
				in.read();
				in.read();
				in.read();
				if (i==10){
					in.read();
				}
				
				for (int b = 0; b < 10; b++) {
					while (line!=null){
							if (Character.isLetter(line)){
								word.add(line);
								line = (char)in.read();
							}
							else if(Character.isDigit(line)){
								line = (char)in.read();
							}
							else if (Character.isWhitespace(line)){
								line = (char)in.read();
								if (word.isEmpty()!=true){
									break;
								}
							}
					}
					
					newWord = convertToString(word);
					
					
					if (newWord != null && newWord != ""){
						temp1.put(newWord.toLowerCase(),placement);
					}
					
					line = (char)in.read();
					word.clear();
					
					while (line!=null){
							if (Character.isLetter(line)){
								word.add(line);
								line = (char)in.read();
							}
							else if(Character.isDigit(line)){
								line = (char)in.read();
							}
							else if (Character.isWhitespace(line)){
								line = (char)in.read();
								if (word.isEmpty()!=true){
									break;
								}
							}
					}
					
					newWord = convertToString(word);
					
					
					if (newWord != null && newWord != ""){
						temp2.put(newWord.toLowerCase(),placement);
						
						placement++;
					}
					
					line = (char)in.read();
					word.clear();
				}
				
				mapForBoy.add(temp1);
				mapForGirl.add(temp2);
				in.close();
			}
		}
		catch (MalformedURLException e){
			System.out.println("The URL could not be run. Please contact someone who can fix it.");
		}
		catch (NullPointerException e){
			System.out.println("The Code could not be run. Please contact someone who can fix it.");
			e.printStackTrace();
		}
		catch (IOException e){
			System.out.println("The File could not be run. Please contact someone who can fix it.");
		}
		
		GridPane gridPane = new GridPane();
		gridPane.add(new Label("Select a year:"), 0, 0);
		gridPane.add(new Label("Boy or girl?"), 0, 1);
		gridPane.add(new Label("Enter a name:"), 0, 2);
		gridPane.add(cboYear, 1, 0);
		gridPane.add(cboGender, 1, 1);
		gridPane.add(tfName, 1, 2);
		gridPane.add(btFindRanking, 1, 3);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(5);
		gridPane.setVgap(5);
	
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(gridPane);
		borderPane.setBottom(lblResult);
		BorderPane.setAlignment(lblResult, Pos.CENTER);

		// Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 370, 160);
		primaryStage.setTitle("Exercise21_11"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		for (int year = 2001; year <= 2010; year++) {
			cboYear.getItems().add(year);
		}
		cboYear.setValue(2001);
				
		cboGender.getItems().addAll("Male", "Female");
		cboGender.setValue("Male");
		
		btFindRanking.setOnAction(e -> {
			if (cboGender.getValue() == "Male"){
				int getYear = cboYear.getValue() - 2000;
				String name = tfName.getText();
				
				if (mapForBoy.get(getYear).get(name.toLowerCase())!= null) {
					lblResult.setText("Your name was ranked " + (mapForBoy.get(getYear).get(name.toLowerCase())) + " between the top ten baby names.");
				}
				else{
					lblResult.setText("I'm sorry, but your name was not on the rankings.");
				}
			}
			else if (cboGender.getValue() == "Female"){
				int getYear = cboYear.getValue() - 2000;
				String name = tfName.getText();
				
				if (mapForGirl.get(getYear).get(name.toLowerCase())!= null) {
					lblResult.setText("Your name was ranked " + (mapForGirl.get(getYear).get(name.toLowerCase())) + " between the top ten baby names.");
				}
				else{
					lblResult.setText("I'm sorry, but your name was not on the rankings.");
				}
			}
		});
		
	}

	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	public static String convertToString(ArrayList<Character> list){
			StringBuilder builder = new StringBuilder(list.size());
			
			for(Character ch: list)
				builder.append(ch);
			
			return builder.toString();
	}
}

