package ie.lyit.tester;

import ie.lyit.Serialize.*;
import ie.lyit.Book.*;

public class BookSerializerTester 
{

	public static void main(String[] args) 
	{
		//Create an object of the BookSerializer class.
		BookSerializer bookSerializer = new BookSerializer();
		
		//Call it’s add() method twice.
		//bookSerializer.add();
		//bookSerializer.add();
		
		//Call it’s serializeBooks() method to write the entire ArrayList to the File.
		//bookSerializer.serializeBooks();
		
		//Read the ArrayList from the File
		//bookSerializer.deserializeBooks();
		
		//List all the books in the ArrayList
		//bookSerializer.list();

		/*Call it’s deserializeBooks() method to read the 
		 * entire ArrayList from the File into the ArrayList instance variable,
		 */
		bookSerializer.deserializeBooks();
		
		//Create an object of the Menu class,
		Menu menu = new Menu();
		
		//Repeatedly
		do 
		{
			//Call the Menu objects display() method,
			menu.display();
			
			//Call the Menu objects readOption() method,
			menu.readOption();
			
			//switch on the chosen option and call the  appropriate method
			switch(menu.getOption()) 
			{
				case 1:bookSerializer.add();break;
				case 2:bookSerializer.list();break;
				case 3:bookSerializer.view();break;
				case 4:bookSerializer.edit();break;
				case 5:bookSerializer.Delete();break;
				case 6:break;
			}
		}while(menu.getOption() != 6);
		/*Call the BookSerializer objects serializeBooks() method to write the
		entire ArrayList from the ArrayList instance variable to the File.*/
		bookSerializer.serializeBooks();
	}

}
