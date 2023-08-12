import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        SwingUtilities.invokeLater(() -> new Calculator());
    }
}
