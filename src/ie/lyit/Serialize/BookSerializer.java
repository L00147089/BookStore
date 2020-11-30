package ie.lyit.Serialize;

import java.util.ArrayList;
import java.util.Scanner;
import ie.lyit.Book.Book;
import java.io.*;

public class BookSerializer 
{
	private ArrayList<Book> books;
	
	final String FILENAME = "book.ser";
	
	public BookSerializer()
	{
		books = new ArrayList<>();
	}
	
	public void add()
	{
		//Create book.
		Book book = new Book();
		//Call read method, to read the book's details from the user.
		book.read();
		//add that book to the books ArrayList.
		books.add(book);
	}
	
	public void list()
	{
		for(Book tmpBook:books)
		{
			System.out.println(tmpBook);
		}
	}
	
	Scanner KB = new Scanner(System.in);
	
	public Book view()
	{
		//Read the key field of the Book to be viewed from the user,
		System.out.println("Enter libary number of book : ");
		int bookToView = KB.nextInt();
		
		//Loop around for every Book object in the ArrayList, and
		for(Book tmpBook:books)
		{
			//If its key field equals the key field of the Book to be viewed
			if(tmpBook.getLibraryNumber() == bookToView)
			{
				//Display the object on screen.
				System.out.println(tmpBook);
				
				//And return it.
				return tmpBook;
			}
		}
		//if the search turns up noting return null.
		return null;
	}
	
	public void Delete()
	{
		//Call the view() method to find, display, and return the Book to be deleted,
		Book tempBook = view();
		
		//If the Book to be deleted != null
		if(tempBook != null)
		{
			//Delete it from the ArrayList by calling the ArrayLists remove() method.
			books.remove(tempBook);
		}		
	}
	
	public void edit()
	{
		//Call the view() method to find, display, and return the Book to be edited,
		Book tempBook = view();
		
		//If the Book to be edited != null
		if(tempBook != null)
		{
			int index = books.indexOf(tempBook);
			//Read in new details for it by calling it’s read()method,
			tempBook.read();
			
			//Reset it in the ArrayList to this new object using the ArrayList set() method.
			books.set(index, tempBook);
		}
	}
	
	public void serializeBooks()
	{
		ObjectOutputStream os = null;
		try 
		{
			//Create a FileOutputStream object, passing the name of the binary File to be created
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
			//Connect it to an ObjectOutputStream object
			os = new ObjectOutputStream(fileStream);
			//Call its writeObject() method to write the entire ArrayList instance variable to the file
			os.writeObject(books);
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Can't create file to store book");
		}
		catch(IOException ioe)
		{
			System.out.println(ioe.getMessage());
		}
		finally
		{
			try {
				//Call its close() method to close the file
				os.close();
			}
			catch(IOException ioe)
			{
				System.out.println(ioe.getMessage());
			}			
		}
	}
	
	@SuppressWarnings("unchecked")
	public void deserializeBooks()
	{
		ObjectInputStream is = null;
		try 
		{
			//Create a FileOutputStream object, passing the name of the binary File to be created
			FileInputStream fileStream = new FileInputStream(FILENAME);
			//Connect it to an ObjectOutputStream object
			is = new ObjectInputStream(fileStream);
			//Call its writeObject() method to write the entire ArrayList instance variable to the file
			books=(ArrayList<Book>)is.readObject();
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Can't create file to store book");
		}
		catch(IOException ioe)
		{
			System.out.println(ioe.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try {
				//Call its close() method to close the file
				is.close();
			}
			catch(IOException ioe)
			{
				System.out.println(ioe.getMessage());
			}			
		}
	}
}
