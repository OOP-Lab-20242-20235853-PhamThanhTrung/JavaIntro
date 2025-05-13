package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*; 
import hust.soict.hedspi.aims.store.*;
import java.util.Scanner;
public class Aims {
	public static Store store = new Store();
	public static Cart currentCart = new Cart();
	public static void filterMediaInCart()
	{
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Search by title");
		System.out.println("2. Search by id");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		Scanner input = new Scanner(System.in);
		int choosing = input.nextInt();
		if(choosing == 1) 
		{
			String mediaTitle = input.nextLine();
			currentCart.searchFor(mediaTitle);
			showMenu();
		}
		else
			if(choosing == 2)
			{
				int mediaId = input.nextInt();
				currentCart.searchFor(mediaId);
				showMenu();
			}
			else cartMenu();
	}
	public static void sortMediaInCart()
	{
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Sort by title");
		System.out.println("2. Sort by cost");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		Scanner input = new Scanner(System.in);
		int choosing = input.nextInt();
		if(choosing == 1) 
			currentCart.sortMediaByTitle();
		else
			if(choosing == 2)
				currentCart.sortMediaByCost();
		cartMenu();
	}
	public static void removeMediaFromCart()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Input id: ");
		int id = input.nextInt();
		currentCart.removeMedia(id);
		cartMenu();
	}
	public static void playMediaInCart()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Find media:");
		String mediaTitle = input.nextLine();
		Media findMedia = currentCart.searchFor(mediaTitle);
		if(findMedia == null)
			cartMenu();
		if(findMedia instanceof DVD) ((DVD) findMedia).play();
		if(findMedia instanceof CompactDisc) ((CompactDisc)findMedia).play();
		cartMenu();
	}
	public static void placeOrder()
	{
		System.out.println("An order is created.");
		currentCart.freeCart();
		showMenu();
	}
	public static void cartMenu()
	{
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter media in cart");
		System.out.println("2. Sort media in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
		Scanner input = new Scanner(System.in);
		int choosing = input.nextInt();
		switch (choosing)
		{
			case 0: showMenu();
			case 1: filterMediaInCart(); break;
			case 2: sortMediaInCart(); break;
			case 3: removeMediaFromCart(); break;
			case 4: playMediaInCart(); break;
			case 5: placeOrder(); break;
			default: showMenu(); break;
		}
	}
	public static void playDVDOrCD(Media findMedia)
	{
		if(findMedia instanceof DVD) ((DVD) findMedia).play();
		if(findMedia instanceof CompactDisc) ((CompactDisc)findMedia).play();
		storeMenu();
	}
	public static void mediaDetailMenu()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Input title:");
		String mediaTitle = input.nextLine();
		Media findMedia = store.searchMedia(mediaTitle);
		if(findMedia == null) 
		{
			System.out.println("Cannot find media with that title!");
			storeMenu();
		}
		System.out.println(findMedia.toString());
		if(!(findMedia instanceof Disc)) storeMenu();
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		int choosing = input.nextInt();
		while(choosing<0 || choosing>2)
			System.out.println("Please choose a number again: 0-1-2");
		switch (choosing)
		{
			case 0: storeMenu(); break;
			case 1: currentCart.addMedia(findMedia); break;
			case 2: playDVDOrCD(findMedia); break;
			default: storeMenu(); break;
		}
	}
	public static void addMediaToCart()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Input title:");
		String mediaTitle = input.nextLine();
		Media findMedia = store.searchMedia(mediaTitle);
		if(findMedia == null) 
		{
			System.out.println("Cannot find media with that title!");
			storeMenu();
		}
		currentCart.addMedia(findMedia);
		currentCart.countMediaInCart();
		storeMenu();
	}
	public static void playMedia()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Input title:");
		String mediaTitle = input.nextLine();
		Media findMedia = store.searchMedia(mediaTitle);
		if(findMedia == null) 
		{
			System.out.println("Cannot find media with that title!");
			storeMenu();
		}
		if(findMedia instanceof DVD) ((DVD) findMedia).play();
		if(findMedia instanceof CompactDisc) ((CompactDisc)findMedia).play();
		storeMenu();
	}
	public static void storeMenu()
	{
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		Scanner input = new Scanner(System.in);
		int choosing = input.nextInt();
		while(choosing<0 || choosing>4)
			System.out.println("Please choose a number again: 0-1-2-4");
		switch (choosing)
		{
			case 0: showMenu(); break;
			case 1: mediaDetailMenu(); break;
			case 2: addMediaToCart(); break;
			case 3: playMedia(); break;
			case 4: currentCart.printCart(); cartMenu(); break;
			default: showMenu(); break;
		}
	}
	public static void addDVDToStore()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Input title: ");
		String title = input.nextLine();
		System.out.println("Input category: ");
		String category = input.nextLine();
		System.out.println("Input director: ");
		String director = input.nextLine();
		System.out.println("Input length: ");
		int length = input.nextInt();
		System.out.println("Input cost: ");
		float cost = input.nextFloat();
		DVD newDVD = new DVD(title, category, director, length, cost);
		store.addMedia(newDVD);
		addMediaToStore();
	}
	public static void addCDToStore()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Input artist's name: ");
		String artistName = input.nextLine();
		System.out.println("Input category: ");
		String category = input.nextLine();
		System.out.println("Input cost: ");
		float cost = input.nextFloat();
		CompactDisc newCD = new CompactDisc(artistName, category, cost);
		store.addMedia(newCD);
		addMediaToStore();
	}
	public static void addBookToStore()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Input title: ");
		String title = input.nextLine();
		System.out.println("Input category: ");
		String category = input.nextLine();
		System.out.println("Input cost: ");
		float cost = input.nextFloat();
		Book newBook = new Book(title, category, cost);
		int check = 1;
		while(true)
		{
			System.out.println("Input authors: ");
			String author = input.nextLine();
			if(author.isEmpty()) break;
			newBook.addAuthor(author);
		}
		store.addMedia(newBook);
		addMediaToStore();
	}
	public static void addMediaToStore()
	{
		System.out.println("OPTIONS: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add DVD to store");
		System.out.println("2. Add CD to store");
		System.out.println("3. Add Book to store");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		Scanner input = new Scanner(System.in);
		int choosing = input.nextInt();
		switch (choosing)
		{
			case 0: updateStore(); break;
			case 1: addDVDToStore(); break;
			case 2: addCDToStore(); break;
			case 3: addBookToStore(); break;
			default: updateStore(); break;
		}
	}
	public static void removeMediaFromStore()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Input title: ");
		String title = input.nextLine();
		Media i = store.searchMedia(title);
		if(i != null) store.removeMedia(i.getId());
		else 
			System.out.println("Cannot find media with that id!");
		updateStore();
	}
	public static void updateStore()
	{
		System.out.println("OPTIONS: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add media to store");
		System.out.println("2. Remove media from store");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		Scanner input = new Scanner(System.in);
		int choosing = input.nextInt();
		switch (choosing)
		{
			case 0: showMenu(); break;
			case 1: addMediaToStore(); break;
			case 2: removeMediaFromStore(); break;
			default: showMenu(); break;
		}
	}
	public static void showMenu()
	{
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		Scanner input = new Scanner(System.in);
		int choosing = input.nextInt();
		switch (choosing)
		{
			case 0: System.exit(0);
			case 1: store.viewStore(); storeMenu(); break;
			case 2: updateStore(); break;
			case 3: currentCart.printCart(); cartMenu(); break;
			default: showMenu(); break;
		}
	}
	public static void main(String[] args)
	{
		DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(dvd1);
		DVD dvd2 = new DVD("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(dvd2);
		DVD dvd3 = new DVD("Aladin", "Animation", 18.99f);
		store.addMedia(dvd3);
		showMenu();
	}
}
