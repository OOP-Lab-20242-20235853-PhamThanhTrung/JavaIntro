package hust.soict.hedspi.aims.media;

public class Track implements Playable{
	private String title;
	private int length;
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public Track()
	{
		this.title = "No_name";
		this.length = 0;
	}
	public Track(String title)
	{
		this.title = title;
		this.length = 0;
	}
	public Track(String title, int length)
	{
		this.title = title;
		this.length = length;
	}
	public void play()
	{
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD Length: " + this.getLength());
	}
	public boolean equals(Track t)
	{
		if(this.getTitle() == t.getTitle() && this.getLength() == t.getLength())
			return true;
		else return false;
	}
	@Override
    public String playGUIString() {
        return "Playing DVD: " + getTitle() + "\n" +
               "Length: " + getLength() + " minutes";
    }
}
