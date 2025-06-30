package exerciciosip;

import java.util.Scanner;

public class ExerciciosIP {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int id;
       String nome;
       String op;
       
        
       
       do{
                
       System.out.println("Informe seu nome: ");
       nome = sc.next();
       
       System.out.println("Informe sua idade: ");
       id = sc.nextInt();
       
       if(id < 10){
           System.out.println("Sua faixa etaria eh: Crianca");
           
       }else if(id < 16){
           System.out.println("Sua faixa etaria eh: Adolescente");
           
       }else if(id < 26){
           System.out.println("Sua faixa etaria eh: Jovem");
           
       }else{
           System.out.println("Sua faixa etaria eh: Adulto");
           
       }
           System.out.println("Deseja continuar? S/N");
           op = sc.next();
        
      }while("S".equals(op));
       
    }
    
}
