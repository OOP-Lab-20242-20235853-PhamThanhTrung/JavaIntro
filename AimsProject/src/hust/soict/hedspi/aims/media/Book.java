package hust.soict.hedspi.aims.media;
import java.util.ArrayList;
import java.util.List;
public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	public Book(String title, String category, float cost)
	{
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public Book(String title, String category)
	{
		super();
		this.title = title;
		this.category = category;
	}
	public Book(String title)
	{
		super();
		this.title = title;
	}
	public void addAuthor(String authorName)
	{
		for(String i : authors)
		{
			if(i == authorName)
			{
				System.out.println("This author has already been exist!");
				return;
			}
		}
		authors.add(authorName);
		System.out.println("Add completed.");
	}
	public void removeAuthor(String authorName)
	{
		for(String i : authors)
		{
			if(i == authorName)
			{
				authors.remove(i);
				System.out.println("Remove completed.");
				return;
			}
		}
		System.out.println("This author is not exist!");
	}
}
