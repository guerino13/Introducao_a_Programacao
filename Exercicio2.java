
package exercicio2;

import java.util.Scanner;


public class Exercicio2 {
     public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um numero inteiro para calcular seu fatorial: ");
        
        int numero = sc.nextInt();

        if (numero < 0) {
            System.out.println("Nao eh possível calcular o fatorial de um numero negativo.");
        } else {
            
            long fatorial = 1;

           
            for (int i = numero; i > 1; i--) {
                fatorial = fatorial * i;
            }

            
            System.out.println("O fatorial de " + numero + " eh: " + fatorial);
        }
     
     }
}
