package aula0107;

import java.util.Scanner;


public class aula0807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float[][] m = new float[5][4];    
        float media;
        for(int i=0;i<m.length;i++){
            System.out.println("Digite as notas do aluno "+ (i+1));
            for(int j=0;j<m[i].length;j++){
                System.out.println("Prova "+ (j+1) + ": ");
                 m[i][j] = sc.nextFloat();
            }
        }
        
         System.out.println("Notas: ");
          for (int i = 0; i < 5; i++) {
            System.out.print("\nAluno " + (i + 1) + ": \n");
            float soma = 0;
            for (int j = 0; j < 4; j++) {
                System.out.print(m[i][j] + " | ");
                soma += m[i][j];
            }
            media = soma / 4;
            System.out.println(" Média: " + media);
          }
           
    }
}
