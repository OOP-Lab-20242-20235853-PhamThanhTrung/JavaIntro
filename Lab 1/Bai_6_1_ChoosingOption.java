import javax.swing.JOptionPane;
public class Bai_6_1_ChoosingOption {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?");
        JOptionPane.showMessageDialog(null, "You've chosen: "+ (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
        System.exit(0);
    }
}