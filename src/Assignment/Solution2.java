package Assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filepath = "This is simple text. This text will be written to file and then read to count word frequency.";
		//String filepath = "C:\\Users\\malaygupta\\Downloads\\Java\\src\\javaday0";
		String filename = "java.txt";
		writeToFile(filename, filepath);
		
		String fileContent = readFile(filename);
		
		String[] words = fileContent.split("\\s+");
		
		Map<String, Integer> wordFrequency = new HashMap<>();
		for (String word : words)
		{
			wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) +1);
		}
		
		System.out.println("Word frequencies: ");
		for (Map.Entry<String, Integer> entry : wordFrequency.entrySet())
		{
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
	private static void writeToFile(String filename, String filepath)
	{
		try (PrintWriter writer = new PrintWriter(filename))
		{
			writer.println(filepath);
			System.out.println("text written to file: " + filename);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("error writing: " + e.getMessage());
		}
	}
	
	
	private static String readFile(String filename)
	{
		StringBuilder content = new StringBuilder();
		try(BufferedReader reader = new BufferedReader(new FileReader(filename)))
		{
			String line;
			while((line = reader.readLine()) != null)
			{
				content.append(line).append("\n");
			}
		}
		catch (IOException e)
		{
			System.out.println("Error reading from file: " + e.getMessage());
		}
		return content.toString();
	}
}
