
import java.awt.Color;
import javax.swing.JLabel;

public class TicTacToeBL {

    public TicTacToeBL() {
    }

    public Color getColor(int i, JLabel label) {
        if(label.getBackground() != Color.BLACK){
            return label.getBackground();
        }
        
        if(i % 2 == 0){
            return Color.RED;
        }else if(i % 2 == 1){
            return Color.BLUE;
        }
        return Color.BLACK;
    }
}
