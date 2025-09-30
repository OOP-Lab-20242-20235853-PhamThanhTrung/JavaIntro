package hust.soict.hedspi.aims.media;
import java.util.Comparator;
public abstract class Media {
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	protected static int nbMedia = 1;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	public boolean isMatch(int id)
	{
		if(this.getId() == id)
			return true;
		else return false;
	}
	public boolean isMatch(String title)
	{
		if(this.getTitle().equals(title))
			return true;
		else return false;
	}
	public Media()
	{
		this.id = nbMedia;
		nbMedia++;
	}
	public boolean equals(Media m)
	{
		if(this.getTitle() == m.getTitle())
			return true;
		else return false;
	}
	public String toString()
	{
		return this.getId() + " - "
				+ this.getTitle() + " - "
				+ this.getCost() + ".";
	}
	private static class MediaComparatorByCostTitle implements Comparator<Media>
	{
		public int compare(Media media1, Media media2)
		{
			int costCompare = Float.compare(media1.getCost(), media2.getCost());
			if(costCompare != 0) return costCompare;
			return media1.getTitle().compareToIgnoreCase(media2.getTitle());
		}
	}
	private static class MediaComparatorByTitleCost implements Comparator<Media>
	{
		public int compare(Media media1, Media media2)
		{
			int titleCompare = media1.getTitle().compareToIgnoreCase(media2.getTitle());
			if(titleCompare != 0) return titleCompare;
			return Float.compare(media1.getCost(), media2.getCost());
		}
	}
}
