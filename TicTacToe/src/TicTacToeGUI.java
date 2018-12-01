
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TicTacToeGUI extends JFrame {

    private JLabel[] labels = new JLabel[9];
    private TicTacToeBL bl = new TicTacToeBL();
    private int count = 1;
    
    public TicTacToeGUI() throws HeadlessException {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
            labels[i].setBackground(Color.black);
            labels[i].setOpaque(true);
            labels[i].setBorder(BorderFactory.createLineBorder(Color.white));
            labels[i].setName("" + (i + 1));
            this.add(labels[i]);
            labels[i].addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    count ++;
                    e.getComponent().setBackground(bl.getColor(count, (JLabel) e.getComponent()));
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });

        }
    }

    public static void main(String[] args) {
        new TicTacToeGUI().setVisible(true);
    }
}
