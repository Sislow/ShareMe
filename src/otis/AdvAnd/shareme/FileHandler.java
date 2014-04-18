package otis.AdvAnd.shareme;

import android.app.Activity;
import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileHandler {
	public static void saveToFile(Activity currActivity, String filename, String fileText)
	{
		FileOutputStream fos;
		try {
			
			fos = currActivity.openFileOutput(filename, Context.MODE_PRIVATE);
			fos.write(fileText.getBytes());
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean checkFileExists(Activity currActivity, String filename)
	{		
		try {
			currActivity.openFileInput(filename);
		} catch (FileNotFoundException e) {
			return false;
		}
		
		return true;
	}
	
	public static String loadFile(Activity currActivity, String filename)
	{
	    StringBuilder sb = new StringBuilder();
	    
		try {
			
			FileInputStream in = currActivity.openFileInput(filename);
			
			InputStreamReader inputStreamReader = new InputStreamReader(in);
		    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		    String line;
		    
		    while ((line = bufferedReader.readLine()) != null) {
		        sb.append(line + "\n");
		        System.out.println("in " + line);
		    }
			
		    inputStreamReader.close();
		    in.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
	public static String[] processFileContent(String contents)
	{
		String lines[] = contents.split("\\r?\\n", -1);

		return lines;
	}
	
	public static void deleteAFile(Activity currActivity, String fileName)
	{
		try{
			File dir = currActivity.getFilesDir();
			File file = new File(dir, fileName);
			file.delete();
		}
		finally
		{}
	}
}
