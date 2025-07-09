package aula0107;

import java.util.Scanner;

public class Aula0107 {

    public static void main(String[] args) {
       Scanner sc = new Scanner (System.in);
       int i;
       float soma = 0, media;
       float temp[] = new float[7];
       for( i=0; i <temp.length; i++){
           System.out.println("Temperatura (dia "+ (i+1)+"): ");
           temp[i] = sc.nextFloat();
           soma += temp[i];
       }
       
       media = soma/temp.length;
       System.out.printf("Media: %.2f", media);
       
          for( i=0; i <temp.length; i++){
           if(temp[i] > media){
               System.out.println(temp[i]);
           }
       }
      
        
    }
    
}
