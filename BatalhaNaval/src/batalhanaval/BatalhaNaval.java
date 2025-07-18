package batalhanaval;

import java.util.Random;

public class BatalhaNaval {

    public static void main(String[] args) {
      char [][]ataqueJog1  = new char [8][8];
      char [][]defesaJog1  = new char [8][8];
      char [][]ataqueJog2  = new char [8][8];
      char [][]defesaJog2  = new char [8][8];
      
      int rodada = 1;
      
      
      while(rodada <= 40){
          
          
          
          rodada++;
      }
        
    }
    
    public static char[][] posNavio(char[][] tabuleiro){
        int navioG = 1;
        int navioM = 2;
        int navioP = 3;
        Random al = new Random();
        int posLinha;
        int posColuna;
        int alinhamento;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabuleiro[i][j] = '~';
            }
        }
        
        for(int i=0; i<navioG; i++){
           posLinha = al.nextInt(8);
           posColuna =al.nextInt(8);
           alinhamento = al.nextInt(1, 3); //1 para vertical, 2 para horizontal
           
           if(alinhamento == 1){
                for(int j = 0; j < 3; j++) {
                if(tabuleiro[posLinha][posColuna] != '~'){
                    System.out.println("Posicao ja preenchida");
                    break;
                }    
                    
                if(posLinha == 0){
                tabuleiro[posLinha + j][posColuna] = '#';
                
                }else if(posLinha == 7){
                tabuleiro[posLinha - j][posColuna] = '#';
                
                }else if(posLinha == 6){
                tabuleiro[posLinha - j][posColuna] = '#';
                
                }else{
                 tabuleiro[posLinha + j][posColuna] = '#';  
                 
                }
                   
             }
                
                
           }else
                {for(int j = 0; j < 3; j++) {
                if(tabuleiro[posLinha][posColuna] != '~'){
                    System.out.println("Posicao ja preenchida");
                    break;
                }    
                    
                if(posLinha == 0){
                tabuleiro[posLinha][posColuna + j] = '#';
                
                }else if(posLinha == 7){
                tabuleiro[posLinha][posColuna - j] = '#';
                
                }else if(posLinha == 6){
                tabuleiro[posLinha][posColuna - j] = '#';
                
                }else{
                 tabuleiro[posLinha][posColuna + j] = '#';  
                 
                }
                   
             }
               
           }
        }
       
        for (int i = 0; i < navioM; i++) {
           posLinha = al.nextInt(8);
           posColuna =al.nextInt(8);
           
           posLinha = al.nextInt(8);
           posColuna =al.nextInt(8);
           alinhamento = al.nextInt(1, 3); //1 para vertical, 2 para horizontal
           
           if(alinhamento == 1){
                for(int j = 0; j < 3; j++) {
                if(tabuleiro[posLinha][posColuna] != '~'){
                    System.out.println("Posicao ja preenchida");
                    break;
                }    
                    
                if(posLinha == 0){
                tabuleiro[posLinha + j][posColuna] = '#';
                
                }else if(posLinha == 7){
                tabuleiro[posLinha - j][posColuna] = '#';
                
                }else if(posLinha == 6){
                tabuleiro[posLinha - j][posColuna] = '#';
                
                }else{
                 tabuleiro[posLinha + j][posColuna] = '#';  
                 
                }
                   
             }
                
                
           }else
                {for(int j = 0; j < 3; j++) {
                if(tabuleiro[posLinha][posColuna] != '~'){
                    System.out.println("Posicao ja preenchida");
                    break;
                }    
                    
                if(posLinha == 0){
                tabuleiro[posLinha][posColuna + j] = '#';
                
                }else if(posLinha == 7){
                tabuleiro[posLinha][posColuna - j] = '#';
                
                }else if(posLinha == 6){
                tabuleiro[posLinha][posColuna - j] = '#';
                
                }else{
                 tabuleiro[posLinha][posColuna + j] = '#';  
                 
                }
                   
             }
               
           }
        }
        for (int i = 0; i < navioP; i++) {
           posLinha = al.nextInt(8);
           posColuna =al.nextInt(8);
           posLinha = al.nextInt(8);
           posColuna =al.nextInt(8);
           alinhamento = al.nextInt(1, 3); //1 para vertical, 2 para horizontal
           
           if(alinhamento == 1){
                for(int j = 0; j < 3; j++) {
                if(tabuleiro[posLinha][posColuna] != '~'){
                    System.out.println("Posicao ja preenchida");
                    break;
                }    
                    
                if(posLinha == 0){
                tabuleiro[posLinha + j][posColuna] = '#';
                
                }else if(posLinha == 7){
                tabuleiro[posLinha - j][posColuna] = '#';
                
                }else if(posLinha == 6){
                tabuleiro[posLinha - j][posColuna] = '#';
                
                }else{
                 tabuleiro[posLinha + j][posColuna] = '#';  
                 
                }
                   
             }  
           }else
                {for(int j = 0; j < 3; j++) {
                if(tabuleiro[posLinha][posColuna] != '~'){
                    System.out.println("Posicao ja preenchida");
                    break;
                }    
                    
                if(posLinha == 0){
                tabuleiro[posLinha][posColuna + j] = '#';
                
                }else if(posLinha == 7){
                tabuleiro[posLinha][posColuna - j] = '#';
                
                }else if(posLinha == 6){
                tabuleiro[posLinha][posColuna - j] = '#';
                
                }else{
                 tabuleiro[posLinha][posColuna + j] = '#';  
                 
                }
                   
             }
               
           }
        }
        return tabuleiro;
    }
    public static char[][] atacar(int linha, int coluna, char[][]ataque, char[][] defesa){
        if(defesa[linha][coluna] != '~'){
        ataque[linha][coluna] = 'X';
        }else{
            ataque[linha][coluna] = 'O';
        }
        return ataque;
    }
}
