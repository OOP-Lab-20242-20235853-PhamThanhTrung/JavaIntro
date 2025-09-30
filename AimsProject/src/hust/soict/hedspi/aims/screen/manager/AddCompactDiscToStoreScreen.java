package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AddCompactDiscToStoreScreen extends AddItemsToStoreScreen {
    private JTextField artistField;
    private JPanel tracksPanel;
    private List<TrackInput> trackInputs;
    
    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        
        JPanel inputPanel = (JPanel) getContentPane().getComponent(0);
        
        artistField = new JTextField();
        
        inputPanel.add(new JLabel("Artist:"));
        inputPanel.add(artistField);
        
        trackInputs = new ArrayList<>();
        tracksPanel = new JPanel();
        tracksPanel.setLayout(new BoxLayout(tracksPanel, BoxLayout.Y_AXIS));
        tracksPanel.setBorder(BorderFactory.createTitledBorder("Tracks"));
        
        JButton addTrackButton = new JButton("Add Track");
        addTrackButton.addActionListener(e -> addTrackInput());
        
        JScrollPane scrollPane = new JScrollPane(tracksPanel);
        inputPanel.add(new JLabel("Tracks:"));
        inputPanel.add(addTrackButton);
        add(scrollPane, BorderLayout.EAST);
        
        addButton.addActionListener(e -> addButtonAction());
        
        setSize(700, 500);
        setVisible(true);
    }
    
    private void addTrackInput() {
        TrackInput trackInput = new TrackInput();
        trackInputs.add(trackInput);
        tracksPanel.add(trackInput);
        revalidate();
        repaint();
    }
    
    public void addButtonAction() {
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());
        String artist = artistField.getText();
        
        CompactDisc cd = new CompactDisc(title, category, artist, cost);
        
        for (TrackInput trackInput : trackInputs) {
            String trackTitle = trackInput.getTitle();
            int trackLength = trackInput.getLength();
            if (!trackTitle.isEmpty() && trackLength > 0) {
                cd.addTrack(new Track(trackTitle, trackLength));
            }
        }
        
        store.addMedia(cd);
        JOptionPane.showMessageDialog(this, "CD added successful");
        
        titleField.setText("");
        categoryField.setText("");
        costField.setText("");
        artistField.setText("");
        tracksPanel.removeAll();
        trackInputs.clear();
        revalidate();
        repaint();
    }
    
    private class TrackInput extends JPanel {
        private JTextField titleField, lengthField;
        
        public TrackInput() {
            setLayout(new FlowLayout(FlowLayout.LEFT));
            
            titleField = new JTextField(15);
            lengthField = new JTextField(5);
            
            add(new JLabel("Title:"));
            add(titleField);
            add(new JLabel("Length:"));
            add(lengthField);
            
            JButton addButton = new JButton("Add");
            addButton.addActionListener(e -> {
                trackInputs.add(this);
                tracksPanel.add(this);
                tracksPanel.revalidate();
                tracksPanel.repaint();
            });
            add(addButton);
        }
        
        public String getTitle() {
            return titleField.getText();
        }
        
        public int getLength() {
            try {
                return Integer.parseInt(lengthField.getText());
            } catch (NumberFormatException e) {
                return 0;
            }
        }
    }
}