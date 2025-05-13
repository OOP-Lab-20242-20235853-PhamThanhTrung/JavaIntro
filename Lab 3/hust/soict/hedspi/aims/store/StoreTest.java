package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DVD;

public class StoreTest {
	public static void main(String[] args)
	{
		Store testStore = new Store();
		DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		testStore.addMedia(dvd1);
		DVD dvd2 = new DVD("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		testStore.addMedia(dvd2);
		DVD dvd3 = new DVD("Aladin", "Animation", 18.99f);
		testStore.addMedia(dvd3);
		testStore.removeMedia(2);
		testStore.printMedia();
	}
}
