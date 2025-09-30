package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.screen.manager.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.ArrayList;
public class StoreManagerScreen extends JFrame{
	protected Store store;
	JPanel createNorth()
	{
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	private JMenuBar createMenuBar() {
	    JMenuBar menuBar = new JMenuBar();
	    
	    JMenuItem viewStore = new JMenuItem("View Store");
	    viewStore.addActionListener(e -> {
	        new StoreManagerScreen(store);
	        dispose();
	    });
	    menuBar.add(viewStore);
	    
	    JMenu menuUpdate = new JMenu("Update Store");
	    
	    JMenuItem addBook = new JMenuItem("Add Book");
	    JMenuItem addCD = new JMenuItem("Add CD");
	    JMenuItem addDVD = new JMenuItem("Add DVD");
	    
	    addBook.addActionListener(e -> {
	        new AddBookToStoreScreen(store);
	        dispose();
	    });
	    
	    addCD.addActionListener(e -> {
	        new AddCompactDiscToStoreScreen(store);
	        dispose();
	    });
	    
	    addDVD.addActionListener(e -> {
	        new AddDVDToStoreScreen(store);
	        dispose();
	    });
	    
	    menuUpdate.add(addBook);
	    menuUpdate.add(addCD);
	    menuUpdate.add(addDVD);
	    menuBar.add(menuUpdate);
	    menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    
	    return menuBar;
	}
	
	JPanel createHeader()
	{
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	JPanel createCenter()
	{
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for(int i = 0; i < mediaInStore.size(); i++)
		{
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		
		return center;
	}
	
	public class MediaStore extends JPanel{
		private Media media;
		public MediaStore(Media media)
		{
			this.media = media;
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			JLabel title = new JLabel(media.getTitle());
			title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
			title.setAlignmentX(CENTER_ALIGNMENT);
			
			JLabel cost = new JLabel("" + media.getCost() + " $");
			cost.setAlignmentX(CENTER_ALIGNMENT);
			
			JPanel container = new JPanel();
			container.setLayout(new FlowLayout(FlowLayout.CENTER));
			
			if (media instanceof Playable) {
	            JButton playButton = new JButton("Play");
	            playButton.addActionListener(new PlayButtonListener());
	            container.add(playButton);
	        }
			this.add(Box.createVerticalGlue());
			this.add(title);
			this.add(cost);
			this.add(Box.createVerticalGlue());
			this.add(container);
			
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
		private class PlayButtonListener implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            showPlayDialog();
	        }
	    }


	    private void showPlayDialog() {
	        if (media instanceof Playable) {
	            Playable playableMedia = (Playable) media;

	            JDialog playDialog = new JDialog();
	            playDialog.setTitle("Playing: " + media.getTitle());
	            playDialog.setSize(400, 200);
	            playDialog.setLocationRelativeTo(null);
	            playDialog.setModal(true);
	            
	            JPanel contentPanel = new JPanel(new BorderLayout());
	            contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	            
	            JLabel infoLabel = new JLabel(playableMedia.playGUIString(), JLabel.CENTER);
	            infoLabel.setFont(new Font(infoLabel.getFont().getName(), Font.PLAIN, 14));
	            contentPanel.add(infoLabel, BorderLayout.CENTER);
	            
	            JButton closeButton = new JButton("Close");
	            closeButton.addActionListener(e -> playDialog.dispose());
	            
	            JPanel buttonPanel = new JPanel();
	            buttonPanel.add(closeButton);
	            contentPanel.add(buttonPanel, BorderLayout.SOUTH);
	            
	            playDialog.add(contentPanel);
	            playDialog.setVisible(true);
	            
	            try {
	                Thread playThread = new Thread(() -> {
	                    try {
	                        for (int i = 0; i < 3; i++) {
	                            final int progress = i + 1;
	                            SwingUtilities.invokeLater(() -> {
	                                infoLabel.setText(playableMedia.playGUIString() + 
	                                    "\nPlaying... (" + progress + "/3)");
	                            });
	                            Thread.sleep(1000);
	                        }
	                    } catch (InterruptedException ex) {
	                        ex.printStackTrace();
	                    }
	                });
	                playThread.start();
	            } catch (Exception ex) {
	                JOptionPane.showMessageDialog(this, 
	                    "Error playing media: " + ex.getMessage(), 
	                    "Play Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    }
	}
	public StoreManagerScreen(Store store)
	{
		this.store = store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		Store store = new Store();
		DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(dvd1);
		DVD dvd2 = new DVD("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(dvd2);
		DVD dvd3 = new DVD("Aladin", "Animation", 18.99f);
		store.addMedia(dvd3);
		new StoreManagerScreen(store);
	}
}
