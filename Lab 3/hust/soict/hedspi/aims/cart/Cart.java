package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.media.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	public Cart() {
		super();
		this.itemsOrdered = itemsOrdered;
	}
	public void totalCost()
	{
		float total = 0.0f;
		for(Media i : itemsOrdered)
			total += i.getCost();
		System.out.println("Total Cost is: " + total);
	}
	public void displayMedia()
	{
		int j = 1;
		for(Media i : itemsOrdered)
		{
			System.out.print(j++ + ". Media - " + i.getTitle());
			System.out.print(" - " + i.getCategory());
			System.out.println(" - " + i.getCost() + "$");
		}
		totalCost();
	}
	public void printCart()
	{
		System.out.println("*************************CART***********************");
		for(Media i : itemsOrdered)
			System.out.println(i.toString());
		totalCost();
		System.out.println("****************************************************");
	}
	public Media searchFor(int id)
	{
		for(Media i : itemsOrdered)
			if(i.isMatch(id) == true)
			{
				System.out.println(i.toString());
				return i;
			}
		System.out.println("Cannot find any Media with that ID!");
		return null;
	}
	public Media searchFor(String title)
	{
		for(Media i : itemsOrdered)
			if(i.isMatch(title) == true)
			{
				System.out.println(i.toString());
				return i;
			}
		System.out.println("Cannot find any Media with that title!");
		return null;
	}
	public void addMedia(Media media)
	{
		for(Media i : itemsOrdered)
		{
			if(i.equals(media) == true)
			{
				System.out.println("This media has already exist!");
				return;
			}
		}
		itemsOrdered.add(media);
		System.out.println("Add completed.");
	}
	public void addMedia(Media media1, Media media2)
	{
		addMedia(media1);
		addMedia(media2);
	}
	public void removeMedia(int id)
	{
		for(Media i : itemsOrdered)
		{
			if(i.getId() == id)
			{
				itemsOrdered.remove(i);
				System.out.println("Remove completed.");
				return;
			}
		}
		System.out.println("Cannot find media with that id!");
	}
	public void sortMediaByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}
        
    public void sortMediaByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}
    public void countMediaInCart()
    {
    	System.out.println("Numbers of media in your cart: " + itemsOrdered.size());
    }
    public void freeCart()
    {
    	for(Media i : itemsOrdered)
    		itemsOrdered.remove(i);
    }
}
