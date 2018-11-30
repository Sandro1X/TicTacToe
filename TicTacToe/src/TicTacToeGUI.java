
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TicTacToeGUI extends JFrame{
    private JLabel[] labels = new JLabel[9];
    
    public TicTacToeGUI() throws HeadlessException {
        this.setSize(800,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3,3));
        
        
        for(int i = 0; i < labels.length; i++){
            labels[i] = new JLabel();
            labels[i].setBackground(Color.black);
            labels[i].setOpaque(true);
            labels[i].setBorder(BorderFactory.createLineBorder(Color.white));
            labels[i].setName(""+ i);
            this.add(labels[i]);
            labels[i].addMouseListener(new MouseListener() {
                
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println(e.getComponent().getName());
                    e.getComponent().setBackground(Color.red);
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
        TicTacToeBL bl = new TicTacToeBL();
    }
}