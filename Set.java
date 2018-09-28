import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.util.Scanner;
public class Set {
    public static void main(String[] args) {
        PossibleSets PS = new PossibleSets();
        String[] number = {"1", "2", "3"};
        String[] color = {"red", "green", "purple"};
        String[] shape = {"oval", "diamond", "s"};
        String[] shading = {"empty", "lined", "full"};
        int[][] SetPiece = new int[12][4];
        ArrayList<int[]> SetsFound = new ArrayList<int[]> ();
        int [][] com = PS.get();
        boolean match = false;
        int i;
        int a;
        int b;
        int c;
        int x;
        for (i = 0; i < 12; i++) {
            SetPiece[i][0] = input(number,i);
            SetPiece[i][1] = input(color,i);
            SetPiece[i][2] = input(shape,i);
            SetPiece[i][3] = input(shading,i);
        }        
        for (i=0;i<220;i++) {
            a=com[i][0];
            b=com[i][1];
            c=com[i][2];
            match = false;
            x=0;
            while (match==false) {
                if (SetPiece[a][x] != SetPiece[b][x]
                    &SetPiece[a][x] != SetPiece[c][x]
                    &SetPiece[b][x] != SetPiece[c][x]) {
                    x++;
                }
                else {
                    if (SetPiece[a][x] == SetPiece[b][x]
                        &SetPiece[a][x] == SetPiece[c][x]) {
                        x++;
                    }
                    else {
                        match=true;
                    }
                }
                if (x==4) {
                    int[] NewSetFound = new int[3];
                    NewSetFound[0]=a+1;
                    NewSetFound[1]=b+1;
                    NewSetFound[2]=c+1;
                    SetsFound.add(NewSetFound);
                    match=true;
                }
            }
        }
        for (i=0;i<SetsFound.size();i++) {
            System.out.println(Arrays.toString(SetsFound.get(i)));
            //JOptionPane.showMessageDialog(null,Arrays.toString(SetsFound.get(i)));
        }
    }
    public static int input (String[]x, int z) {
        String y = (String)JOptionPane.showInputDialog(null,"Set Piece: "+(z+1),"Choose:",
                                JOptionPane.QUESTION_MESSAGE,null,x,x[0]);
        if (y.equals(x[0])) {
            return 1;
        }
        if (y.equals(x[1])) {
            return 2;
        }
        if (y.equals(x[2])) {
            return 3;
        }
        else {
            return 0;
        }
    }
}