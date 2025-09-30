package hust.soict.hedspi.aims.media;
import java.util.ArrayList;
import java.util.List;
public class CompactDisc extends Disc implements Playable{
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	public String getArtist() {
		return artist;
	}
	public CompactDisc()
	{
		super();
		this.artist = "No_Name";
	}
	public CompactDisc(String title, String artistName, String category, float cost)
	{
		super();
		this.title = title;
		this.artist = artistName;
		this.category = category;
		this.cost = cost;
	}
	public CompactDisc(String title, String artistName, String category)
	{
		super();
		this.title = title;
		this.artist = artistName;
		this.category = category;
	}
	public void addTrack(Track track)
	{
		for(Track i : tracks)
		{
			if(i.equals(track) == true)
			{
				System.out.println("This track has already been exist!");
				return;
			}
		}
		tracks.add(track);
		this.length += track.getLength();
		System.out.println("Add completed.");
	}
	public void removeTrack(String trackName)
	{
		for(Track i : tracks)
		{
			if(i.getTitle() == trackName)
			{
				this.length -= i.getLength();
				tracks.remove(i);
				System.out.println("Remove completed.");
				return;
			}
		}
		System.out.println("This track is not exist!");
	}
	public void getCDLength()
	{
		int totalLength = 0;
		for(Track i : tracks)
			totalLength += i.getLength();
		this.length = totalLength;
	}
	public void play()
	{
		for(Track i : tracks)
			i.play();
	}
	 public String playGUIString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("Playing CD: ").append(getTitle()).append("\n");
	        sb.append("Artist: ").append(artist).append("\n");
	        sb.append("Total length: ").append(getLength()).append(" minutes\n");
	        sb.append("Tracks (").append(tracks.size()).append("):\n");
	        
	        for (Track track : tracks) {
	            sb.append("- ").append(track.getTitle())
	              .append(" (").append(track.getLength()).append(" mins)\n");
	        }
	        
	        return sb.toString();
	    }
}
