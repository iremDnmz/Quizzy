package SystemandMain;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import CategoryObj.Category;
import mainFrame.QuizMainFrame;


public class QuizMain {
	//public static ArrayList<Category> categoryArray = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		//Frames and FileReadSys.readFromFiles()  will be called. So if txt file contains different
		//data different types of quizzes will be available for the user
		
		// TODO Auto-generated method stub
			FileReadSys.readFromFiles();
			System.out.println(FileReadSys.displayCategoryObjects());
				
			QuizMainFrame mainFrame = new  QuizMainFrame();
			mainFrame.setVisible(true);
		
	
		   
		
			
	}

}
