package aula0107;

import java.util.Scanner;


public class aula0807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float[][] m = new float[5][4];    
        
        for(int i=0;i<m.length;i++){
            System.out.println("Digite a nota do aluno "+ (i+1));
            for(int j=0;j<m[i].length;j++){
                 m[i][j] = sc.nextFloat();
            }
        }
        
         System.out.println("Notas: ");
          for (int i = 0; i < 5; i++) {
            System.out.print("\nAluno " + (i + 1) + ": \n");
            for (int j = 0; j < 4; j++) {
                System.out.print(m[i][j] + " | ");
            }
          }
       
    }
}
