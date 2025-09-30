package hust.soict.hedspi.aims.media;

public class DVD extends Disc implements Playable{
	public DVD(String title) {
		this.title = title;
	}
	public DVD(String title, String category, float cost)
	{
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public DVD(String title, String category, String director, int length, float cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	public DVD(String title, String category, String director, float cost)
	{
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	public void setTitle(String title)
	{
		this.title = title;
		return;
	}
	public void play()
	{
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD Length: " + this.getLength());
	}
	
    public String playGUIString() {
        return "Playing DVD: " + getTitle() + "\n" +
               "Director: " + getDirector() + "\n" +
               "Length: " + getLength() + " minutes";
    }
}
