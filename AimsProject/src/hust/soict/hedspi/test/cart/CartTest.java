package hust.soict.hedspi.test.cart;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DVD;
public class CartTest {
	public static void main(String[] args)
	{
		Cart cart = new Cart();
		DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addMedia(dvd1);
		DVD dvd2 = new DVD("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addMedia(dvd2);
		DVD dvd3 = new DVD("Aladin", "Animation", 18.99f);
		cart.addMedia(dvd3);
		cart.removeMedia(2);
		cart.printCart();
		cart.searchFor(2);
		cart.searchFor(3);
		cart.searchFor("Tay du ki");
		cart.searchFor("Aladin");
	}
}
