package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.DVD;
import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;

public class AddDVDToStoreScreen extends AddItemsToStoreScreen {
    private JTextField directorField, lengthField;
    
    public AddDVDToStoreScreen(Store store) {
        super(store);
        setTitle("Add DVD to store");
        JPanel inputPanel = (JPanel) getContentPane().getComponent(0);
        
        directorField = new JTextField();
        lengthField = new JTextField();
        titleField = new JTextField();
        categoryField = new JTextField();
        costField = new JTextField();
        
        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Category:"));
        inputPanel.add(categoryField);
        inputPanel.add(new JLabel("Cost:"));
        inputPanel.add(costField);
        inputPanel.add(new JLabel("Director:"));
        inputPanel.add(directorField);
        inputPanel.add(new JLabel("Length (minutes):"));
        inputPanel.add(lengthField);
        
        addButton.addActionListener(e -> addButtonAction());
        
        setVisible(true);
    }
    
    public void addButtonAction() {
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());
        String director = directorField.getText();
        int length = Integer.parseInt(lengthField.getText());
        
        DVD dvd = new DVD(title, category, director, length, cost);
        store.addMedia(dvd);
        JOptionPane.showMessageDialog(this, "DVD added successfully!");
        
        titleField.setText("");
        categoryField.setText("");
        costField.setText("");
        directorField.setText("");
        lengthField.setText("");
    }
}