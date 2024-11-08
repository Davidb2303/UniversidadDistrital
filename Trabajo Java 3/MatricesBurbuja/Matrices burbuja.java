package tutos;
import javax.swing.JOptionPane; 
public class matricesburbuja {
public static void main(String[] args){
int matris [] [] = new int [3] [3];
for (int i=0;i<3;i++){
    for (int g=0;g<3;g++){
        matris[i][g]=Integer.parseInt(JOptionPane.showInputDialog("Dame un numero"));
    }

}
for (int i=0;i<3;i++){
    for (int g=0;g<3;g++){
        for (int r=0;r<3;r++){
            for (int h=0;h<3;h++){
                if(matris[i][g]>=matris[r][h]){
                    matris[i][g]=matris[i][g];
                }else{
                    int temp=matris[r][h];
                    matris[r][h]=matris[i][g];
                    matris[i][g]=temp;
                    
                }
            }
        }
    }
}
for(int i=0;i<3;i++){
    for(int g=0;g<3;g++){
        System.out.print(matris[i][g]+"\t");

}
System.out.println("");
}




}

}