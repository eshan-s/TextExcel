package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
	    // Add your command loop here
		
		Spreadsheet user = new Spreadsheet();
		Scanner console = new Scanner(System.in);
		
		String input = console.nextLine();
		//exit loop
		while (!(input.toLowerCase().equals("quit")))
		{
			System.out.println(user.processCommand(input));
			input = console.nextLine();
		}
	}
}
