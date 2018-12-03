
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
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

public class TicTacToeGUI extends JFrame {

    private JLabel[] labels = new JLabel[9];
    private TicTacToeBL bl = new TicTacToeBL();
    private static TicTacToeGUI gui = new TicTacToeGUI();
    private int count = 1;

    //ca. 30 Minuten
    public TicTacToeGUI() throws HeadlessException {
        this.setSize(1300, 1300);
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
                bl.setOver(false); //Alles neustarten
                bl.restart();
                restart();
                count = 1;
            }
        });
        
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.dispose(); //Schließen
            }
        });

        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
            labels[i].setBackground(Color.black);
            labels[i].setOpaque(true);
            labels[i].setBorder(BorderFactory.createLineBorder(Color.white));
            labels[i].setName("" + i);
            labels[i].setComponentPopupMenu(menu);
            this.add(labels[i]);
            labels[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == 1) {
                        if(e.getComponent().getBackground() == Color.black){
                           count++; 
                        }
                        e.getComponent().setBackground(bl.setColor(count, (JLabel) e.getComponent()));
                        if(bl.prove((JLabel) e.getComponent())){
                            if(e.getComponent().getBackground() == Color.RED){
                                JOptionPane.showMessageDialog(null, "Red won!");
                            }else if(e.getComponent().getBackground() == Color.BLUE){
                                JOptionPane.showMessageDialog(null, "Blue won!");
                            }
                            bl.setOver(true);
                        }else if(bl.proveDraw()){
                            JOptionPane.showMessageDialog(null, "Nobody won!");
                            bl.setOver(true);
                        }
                    } else if (e.getButton() == 3) {
//                        menu.setVisible(true);
//                        menu.show(gui, e.getXOnScreen(), e.getYOnScreen());
                    }
                }
            });
        }
    }

    //ca. 10 Sekunden
    public void restart(){
        for(int i = 0; i < 9; i++){ //Setze farbe auf schwarz zurück
            labels[i].setBackground(Color.black);
        }
    }
    
    public static void main(String[] args) {
        gui.setVisible(true);
    }
}
