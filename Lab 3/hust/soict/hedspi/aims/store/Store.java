package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;
public class Store {
	private final int MAX_DVD_IN_STORE = 1000;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	public void addMedia(Media media)
	{
		if(itemsInStore.size() >= MAX_DVD_IN_STORE)
		{
			System.out.println("The store is full");
			return;
		}
		if(media == null)
		{
			System.out.println("ERROR");
			return;
		}
		for(Media i : itemsInStore)
			if(i.getTitle() == media.getTitle())
			{
				System.out.println("This media has already exist!");
				return;
			}
		itemsInStore.add(media);
		System.out.println("Add completed.");
	}
	public void removeMedia(int index)
	{
		if(index < 1 || index > itemsInStore.size())
		{
			System.out.println("ERROR");
			return;
		}
		for(Media i : itemsInStore)
			if(i.getId() == index)
			{
				itemsInStore.remove(i);
				System.out.println("Remove completed.");
				return;
			}
		System.out.println("Cannot find media with that id!");
	}
	public void printMedia()
	{
		for(Media i : itemsInStore)
			System.out.println(i.toString());
	}
	public Media searchMedia(String title)
	{
		for(Media i : this.itemsInStore)
			if(i.getTitle().equals(title))
				return i;
		return null;
	}
	public void viewStore()
	{
		System.out.println("*************STORE**************");
		for(Media i : itemsInStore)
		{
			System.out.println(i.toString());
		}
		System.out.println("********************************");
	}
}

