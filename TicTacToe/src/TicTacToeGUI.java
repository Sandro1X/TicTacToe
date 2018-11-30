
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class TicTacToeGUI extends JFrame{

    public TicTacToeGUI() throws HeadlessException {
        this.setSize(800,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPopupMenu popMenu = new JPopupMenu();
        JMenu menu = new JMenu();
        JMenuItem item = new JMenuItem("Close");
        popMenu.add(item);
        this.add(popMenu);
    }
    
    public static void main(String[] args) {
        new TicTacToeGUI().setVisible(true);
    }
}