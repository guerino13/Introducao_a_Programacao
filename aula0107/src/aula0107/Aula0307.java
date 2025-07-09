package aula0107;

import java.util.Scanner;

public class Aula0307 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n[] = new int[10];
        int conta = 0;
        int i;
        
        for(i=0; i<n.length; i++){
            System.out.println("N["+(i+1)+"]: ");
            n[i] = sc.nextInt();
         
          }
        
            for(i = 0;i<5;i++){
               System.out.println("Posição [" + (i+1) + "]: " + n[i]);
            }
            
            System.out.println("Voce tem "+ conta + " numeros a mais que a posicao 5.");
        
        
    }
}
