
import java.awt.Color;
import javax.swing.JLabel;

public class TicTacToeBL {

    private int[][] field = new int[3][3];
    private boolean over;

    public TicTacToeBL() {
    }

    //ca. 10 Minuten
    public boolean prove(JLabel label) {
        if (!over) {
            int row = -1; //Unnötig
            int pos = Integer.parseInt(label.getName()); //Unnötig
            int col = pos % 3; //Unnötig

            if (pos <= 2) { //Unnötig
                row = 0; //Unnötig
            } else if ((pos == 3 || pos == 4 || pos == 5)) { //Unnötig
                row = 1; //Unnötig
            } else if ((pos == 6 || pos == 7 || pos == 8)) { //Unnötig
                row = 2; //Unnötig
            }

            for (int i = 0; i < 1; i++) { //Schaut horizontal alle Spalten durch
                if (field[0][i] == field[0][i + 1] && field[0][i + 1] == field[0][i + 2] && field[0][i] != 0) {
                    return true;
                } else if (field[1][i] == field[1][i + 1] && field[1][i + 1] == field[1][i + 2] && field[1][i] != 0) {
                    return true;
                } else if (field[2][i] == field[2][i + 1] && field[2][i + 1] == field[2][i + 2] && field[2][i] != 0) {
                    return true;
                }
            }

            for (int i = 0; i < 1; i++) { //Schaut vertiakl alle Reihen durch
                if (field[i][0] == field[i + 1][0] && field[i + 1][0] == field[i + 2][0] && field[i][0] != 0) {
                    return true;
                } else if (field[i][1] == field[i + 1][1] && field[i + 1][1] == field[i + 2][1] && field[i][1] != 0) {
                    return true;
                } else if (field[i][2] == field[i + 1][2] && field[i + 1][2] == field[i + 2][2] && field[i][2] != 0) {
                    return true;
                }
            }

            if (field[0][0] == field[1][1] && field[1][1] == field[2][2] && field[1][1] != 0) { //Schaut diagonal
                return true;
            } else if (field[2][0] == field[1][1] && field[1][1] == field[0][2] && field[1][1] != 0) {
                return true;
            }

            return false;
        }
        return false;
    }

    //ca. 2 Minuten
    public boolean proveDraw() { //Schaut ob alle schwarz sind
        if (!over) {
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (field[i][j] == 0) {
                        return false;
                    }
                }
            }
            return true;
        }
        return true;
    }

    //ca. 20 Minuten
    public Color setColor(int i, JLabel label) { //0 = Black, 1 = Red, 2 = Blue
        if (!over) {
            int color = -1;
            if (label.getBackground() != Color.black) {
                label.setBackground(label.getBackground());
            }

            if (i % 2 == 0 && label.getBackground() == Color.black) { //Setze farben
                label.setBackground(Color.RED);
            } else if (i % 2 == 1 && label.getBackground() == Color.black) {
                label.setBackground(Color.BLUE);
            }

            if (label.getBackground() == Color.black) { //0 = Black, 1 = Red, 2 = Blue
                color = 0;
            } else if (label.getBackground() == Color.RED) {
                color = 1;
            } else if (label.getBackground() == Color.BLUE) {
                color = 2;
            }

            int pos = Integer.parseInt(label.getName());
            if (pos <= 2 && color != -1) { //Setze die Werte in 2D Array
                field[0][pos] = color;
            } else if ((pos == 3 || pos == 4 || pos == 5) && color != -1) {
                field[1][pos % 3] = color;
            } else if ((pos == 6 || pos == 7 || pos == 8) && color != -1) {
                field[2][pos % 3] = color;
            }
            return label.getBackground();
        }
        return label.getBackground();
    }

    //ca. 15 Sekunden
    public void restart() {
        for (int i = 0; i <= 2; i++) { //Setze alle Werte zurück
            for (int j = 0; j <= 2; j++) {
                field[i][j] = 0;
            }
        }
    }

    public void setOver(boolean over) { //Setter
        this.over = over;
    }
}
