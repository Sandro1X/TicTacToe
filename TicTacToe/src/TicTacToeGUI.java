
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class TicTacToeGUI extends JFrame {

    private JLabel[] labels = new JLabel[9];
    private TicTacToeBL bl = new TicTacToeBL();
    private int count = 1;

    public TicTacToeGUI() throws HeadlessException {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 3));

        JPopupMenu menu = new JPopupMenu();
        menu.add(new JMenuItem("Restart"));
        menu.add(new JMenuItem("Close"));

        menu.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    menu.setVisible(true);
                }
                menu.show(e.getComponent(), e.getX(), e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    menu.setVisible(true);
                }
                menu.show(e.getComponent(), e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    menu.setVisible(true);
                }
                menu.show(e.getComponent(), e.getX(), e.getY());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

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
                    if (e.getButton() == 1) {
                        count++;
                        e.getComponent().setBackground(bl.getColor(count, (JLabel) e.getComponent()));
                    }else if(e.getButton() == 3){
                        menu.setVisible(true);
                    }
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
