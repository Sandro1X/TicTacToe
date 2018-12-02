
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
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
    private static TicTacToeGUI gui = new TicTacToeGUI();
    private int count = 1;

    public TicTacToeGUI() throws HeadlessException {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 3));

        JPopupMenu menu = new JPopupMenu();
        JMenuItem item1 = new JMenuItem("Restart");
        JMenuItem item2 = new JMenuItem("Close");

        menu.add(item1);
        menu.add(item2);
        
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.dispose();
            }
        });

        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
            labels[i].setBackground(Color.black);
            labels[i].setOpaque(true);
            labels[i].setBorder(BorderFactory.createLineBorder(Color.white));
            labels[i].setName("" + i);
            this.add(labels[i]);
            labels[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == 1) {
                        if(e.getComponent().getBackground() == Color.black){
                           count++; 
                        }
                        e.getComponent().setBackground(bl.getColor(count, (JLabel) e.getComponent()));
                        bl.prove((JLabel) e.getComponent());
                    } else if (e.getButton() == 3) {
                        menu.setVisible(true);
                        menu.show(gui, e.getXOnScreen(), e.getYOnScreen());
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        gui.setVisible(true);
    }
}
