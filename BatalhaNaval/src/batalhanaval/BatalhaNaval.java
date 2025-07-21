package batalhanaval;

import java.util.Random;
import java.util.Scanner;

public class BatalhaNaval {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      char [][]ataqueJog1  = new char [8][8];
      char [][]defesaJog1  = new char [8][8];
      char [][]ataqueJog2  = new char [8][8];
      char [][]defesaJog2  = new char [8][8];
      int op = 0;
      int ataque;
      int rodada = 1;
      
      
      
        while(rodada <= 40){
         
            System.out.println("Vez do jogador 1. Escolha sua proxima acao.\n");
            System.out.println("======= MENU =======\n" +
                "1- Posicionar navios automaticamente\n" +
                "2- Atacar oponente\n" +
                "3- Ver tabuleiro de ataques\n" +
                "4- Ver rodadas restantes\n" +
                "5 - Sair do jogo\n" +
                "====================\n");
          
          op = sc.nextInt();
          
          switch(op){
              case 1:
                  System.out.println("Posicionando seus navios...");
                  posNavio(defesaJog1);
                  
                  break;
               //Caso 1 é o inicio do jogo, posicionando os navios dos jogadores de maneira aleatória.
              case 2:
                  System.out.println("Selecione a linha a ser atacada.");
                  ataque = sc.nextInt();
                  System.out.println("Selecione a coluna a ser atacada.");
                  ataque = sc.nextInt(); 
                  atacar(ataque, ataque, ataqueJog1, defesaJog2); //Chamada da função "atacar", que atualiza as posições ja atacadas pelo jogador.
                  
                  break;
                  //Caso 2 é a ação de ataque do jogador.
              case 3:    
                  //Criar o for para exibir a matriz que representa o tabuleiro de ataque do jogador.
                  break;
                  
              case 4:
                  System.out.println("O numero de rodadas restantes eh de: "+ (40 - rodada)+"\n");
                  break;
                  //Caso 4 exibe o numero de rodadas restantes
              case 5:
                  rodada = 40;
                  break;
                  //Caso 5 finaliza o jogo, caso o jogador deseje.
                 
          }
          
            System.out.println("Vez do jogador 2. Escolha sua proxima acao.\n");
            System.out.println("======= MENU =======\n" +
                "1- Posicionar navios automaticamente\n" +
                "2- Atacar oponente\n" +
                "3- Ver tabuleiro de ataques\n" +
                "4- Ver rodadas restantes\n" +
                "5 - Sair do jogo\n" +
                "====================\n");
            op = sc.nextInt();
            switch(op){
              case 1:
                  System.out.println("Posicionando seus navios...");
                  posNavio(defesaJog2);
                  
                  break;
               //Caso 1 é o inicio do jogo, posicionando os navios dos jogadores de maneira aleatória.
              case 2:
                  System.out.println("Selecione a linha a ser atacada.");
                  ataque = sc.nextInt();
                  System.out.println("Selecione a coluna a ser atacada.");
                  ataque = sc.nextInt(); 
                  atacar(ataque, ataque, ataqueJog2, defesaJog1); //Chamada da função "atacar", que atualiza as posições ja atacadas pelo jogador.
                  
                  break;
                  //Caso 2 é a ação de ataque do jogador.
              case 3:    
                  //Criar o for para exibir a matriz que representa o tabuleiro de ataque do jogador.
                  break;
                  
              case 4:
                  System.out.println("O numero de rodadas restantes eh de: "+ (40 - rodada)+"\n");
                  break;
                  //Caso 4 exibe o numero de rodadas restantes
              case 5:
                  rodada = 40;
                  break;
                  //Caso 5 finaliza o jogo, caso o jogador deseje.
                 
          }
          
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
        int contAcerto = 0; //Contar o acerto para verificar caso de vitoria.
        if(defesa[linha][coluna] != '~'){
        ataque[linha][coluna] = 'X';
        contAcerto++;
        }else{
            ataque[linha][coluna] = 'O';
        }
        return ataque;
    }
}
