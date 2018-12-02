
import java.awt.Color;
import javax.swing.JLabel;

public class TicTacToeBL {

    private int[][] field = new int[3][3];
    
    public TicTacToeBL() {
    }

    public void prove(JLabel label){
        
    }
    
    public Color getColor(int i, JLabel label) { //0 = Black, 1 = Red, 2 = Blue
        int color = -1;
        if(label.getBackground() != Color.BLACK){
            return label.getBackground();
        }
        
        if(label.getBackground() == Color.BLACK){
            color = 0;
        }else if(label.getBackground() == Color.RED){
            color = 1;
        }else if(label.getBackground() == Color.BLUE){
            color = 2;
        }
        
        int pos = Integer.parseInt(label.getName());
        
        if(pos <= 2 && color != -1){
            field[0][pos] = color;
        }else if((pos == 3 || pos == 4 || pos == 5) && color != -1){
            field[1][pos % 3] = color;
        }else if((pos == 6 || pos == 7 || pos == 8) && color != -1){
            field[2][pos % 3] = color;
        }
        
        if(i % 2 == 0){
            return Color.RED;
        }else if(i % 2 == 1){
            return Color.BLUE;
        }
        return Color.BLACK;
    }
}