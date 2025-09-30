package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;

public class AddBookToStoreScreen extends AddItemsToStoreScreen {
    private JTextField authorsField;
    
    public AddBookToStoreScreen(Store store) {
        super(store);
        
        JPanel inputPanel = (JPanel) getContentPane().getComponent(0);
        setTitle("Add book to store");
        titleField = new JTextField();
        categoryField = new JTextField();
        costField = new JTextField();
        
        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Category:"));
        inputPanel.add(categoryField);
        inputPanel.add(new JLabel("Cost:"));
        inputPanel.add(costField);
        authorsField = new JTextField();
        inputPanel.add(new JLabel("Authors (comma separated):"));
        inputPanel.add(authorsField);
        
        addButton.addActionListener(e -> addButtonAction());
        
        setVisible(true);
    }
    
    public void addButtonAction() {
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());
        String[] authors = authorsField.getText().split(",");
        
        Book book = new Book(title, category, cost);
        for (String author : authors) {
            book.addAuthor(author.trim());
        }
        
        store.addMedia(book);
        JOptionPane.showMessageDialog(this, "Book added successfully!");
        
        titleField.setText("");
        categoryField.setText("");
        costField.setText("");
        authorsField.setText("");
    }
}