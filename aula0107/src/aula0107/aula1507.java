package aula0107;

import java.util.Scanner;


public class aula1507 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int n = sc.nextInt();
        float temp[][] = new float[n][7];
        float media[] = new float[n];
        String cidade[] = new String[n];
        String dia[] ={"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"}; 
        float soma = 0, somaCidade;
        int idxDiaSemana = -1;
        float maiorTemp = Float.MIN_VALUE;
        for(int i=0;i<temp.length;i++){
            somaCidade = 0;
            System.out.printf("Cidade[%d]: ",i);
            cidade[i] = sc2.nextLine();
            for(int j=0;j<temp[i].length;j++){
                System.out.printf("temp[%d,%d]: ",i,j);
               temp[i][j] = sc.nextFloat();
               if(temp[i][j] > maiorTemp){
                maiorTemp = temp[i][j];
                idxDiaSemana = j;
            }
               somaCidade += temp[i][j];
               soma += temp[i][j];
            }
            media[i] = somaCidade/temp[i].length;
        }
        float mediaGeral = soma/(n*7);
        System.out.printf("\nMedia [%d]: %.2f\n",mediaGeral);
         for(int i=0;i<media.length;i++){
             System.out.printf("\nMedia [%d]: %.2f\n",i, media[i]);
         }
        System.out.printf("\n %s foi o dia mais quente da semana com temperatura de %.2f", dia[idxDiaSemana]);
    }
}
