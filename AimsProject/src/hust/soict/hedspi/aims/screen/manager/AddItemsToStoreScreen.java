package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.screen.manager.*;
import javax.swing.*;
import java.awt.*;

public abstract class AddItemsToStoreScreen extends JFrame {
    protected Store store;
    protected JTextField titleField, categoryField, costField;
    protected JButton addButton;

	JPanel createNorth()
	{
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
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
	
    public AddItemsToStoreScreen(Store store) {
        this.store = store;
        
        setSize(500, 400);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        
        // Tạo các thành phần chung
        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        
        // Panel cho các nút
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        addButton = new JButton("Add");
        
        buttonPanel.add(addButton);
        
        // Thêm các thành phần vào frame
        add(createNorth(), BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
    }
    
    protected abstract void addButtonAction();
}