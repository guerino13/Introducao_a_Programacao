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
      int ataqueLinha, ataqueColuna;
      int rodada = 1;
      
      
      
      
        while(rodada < 40){
         
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
                  ataqueLinha = sc.nextInt();
                  System.out.println("Selecione a coluna a ser atacada.");
                  ataqueColuna = sc.nextInt(); 
                  atacar(ataqueLinha, ataqueColuna, ataqueJog1, defesaJog2); //Chamada da função "atacar", que atualiza as posições ja atacadas pelo jogador.
                  if (verificarVitoria (defesaJog2)) {
                        System.out.println("FIM DE JOGO! O JOGADOR 1 VENCEU! Todos os navios adversários foram destruídos! \n");
                        System.out.println("Tabuleiros do jogador 2: \n");
                        imprimirTabuleiro(ataqueJog2);
                        imprimirTabuleiro(defesaJog2);
                        System.out.println("\nTabuleiros do jogador 1: \n");
                        imprimirTabuleiro(ataqueJog1);
                        imprimirTabuleiro(defesaJog1);
                        rodada = 50;
                    }
                  break;
                  //Caso 2 é a ação de ataque do jogador.
              case 3:   
                  imprimirTabuleiro(ataqueJog1);
                  //Cria o for para exibir a matriz que representa o tabuleiro de ataque do jogador.
                  break;
                  
              case 4:
                  System.out.println("O numero de rodadas restantes eh de: "+ (40 - rodada)+"\n");
                  break;
                  //Caso 4 exibe o numero de rodadas restantes
              case 5:
                  rodada = 50;
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
                  ataqueLinha = sc.nextInt();
                  System.out.println("Selecione a coluna a ser atacada.");
                  ataqueColuna = sc.nextInt(); 
                  atacar(ataqueLinha, ataqueColuna, ataqueJog2, defesaJog1); //Chamada da função "atacar", que atualiza as posições ja atacadas pelo jogador.
                  
                  if (verificarVitoria (defesaJog2)) {
                        System.out.println("FIM DE JOGO! O JOGADOR 2 VENCEU! Todos os navios adversários foram destruídos! \n");
                        System.out.println("Tabuleiros do jogador 2: \n");
                        imprimirTabuleiro(ataqueJog2);
                        imprimirTabuleiro(defesaJog2);
                        System.out.println("\nTabuleiros do jogador 1: \n");
                        imprimirTabuleiro(ataqueJog1);
                        imprimirTabuleiro(defesaJog1);
                        rodada = 50;
                    }
                  break;
                  //Caso 2 é a ação de ataque do jogador.
              case 3:    
                  imprimirTabuleiro(ataqueJog2);
                  //Criar o for para exibir a matriz que representa o tabuleiro de ataque do jogador.
                  break;
                  
              case 4:
                  System.out.println("O numero de rodadas restantes eh de: "+ (40 - rodada)+"\n");
                  break;
                  //Caso 4 exibe o numero de rodadas restantes
              case 5:
                  rodada = 50;
                  break;
                  //Caso 5 finaliza o jogo, caso o jogador deseje.
                 
          }
          
            if(rodada == 40 && verificarVitoria(defesaJog2) == false && verificarVitoria(defesaJog1) == false){
                System.out.println("FIM DE JOGO! O jogo terminou empatado! \n");
                System.out.println("Tabuleiros do jogador 2: \n");
                imprimirTabuleiro(ataqueJog2);
                imprimirTabuleiro(defesaJog2);
                System.out.println("\nTabuleiros do jogador 1: \n");
                imprimirTabuleiro(ataqueJog1);
                imprimirTabuleiro(defesaJog1);
                
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
                    
                    switch (posLinha) {
                        case 0:
                            tabuleiro[posLinha + j][posColuna] = '#';
                            break;
                        case 7:
                            tabuleiro[posLinha - j][posColuna] = '#';
                            break;
                        case 6:
                            tabuleiro[posLinha - j][posColuna] = '#';
                            break;
                        default:
                            tabuleiro[posLinha + j][posColuna] = '#';
                            break;
                    }
                   
             }
                
                
           }else
                {for(int j = 0; j < 3; j++) {
                if(tabuleiro[posLinha][posColuna] != '~'){
                    System.out.println("Posicao ja preenchida");
                    break;
                }    
                    
                    switch (posLinha) {
                        case 0:
                            tabuleiro[posLinha][posColuna + j] = '#';
                            break;
                        case 7:
                            tabuleiro[posLinha][posColuna - j] = '#';
                            break;
                        case 6:
                            tabuleiro[posLinha][posColuna - j] = '#';
                            break;
                        default:
                            tabuleiro[posLinha][posColuna + j] = '#';
                            break;
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
                    
                    switch (posLinha) {
                        case 0:
                            tabuleiro[posLinha + j][posColuna] = '#';
                            break;
                        case 7:
                            tabuleiro[posLinha - j][posColuna] = '#';
                            break;
                        case 6:
                            tabuleiro[posLinha - j][posColuna] = '#';
                            break;
                        default:
                            tabuleiro[posLinha + j][posColuna] = '#';
                            break;
                    }
                   
             }
                
                
           }else
                {for(int j = 0; j < 3; j++) {
                if(tabuleiro[posLinha][posColuna] != '~'){
                    System.out.println("Posicao ja preenchida");
                    break;
                }    
                    
                    switch (posLinha) {
                        case 0:
                            tabuleiro[posLinha][posColuna + j] = '#';
                            break;
                        case 7:
                            tabuleiro[posLinha][posColuna - j] = '#';
                            break;
                        case 6:
                            tabuleiro[posLinha][posColuna - j] = '#';
                            break;
                        default:
                            tabuleiro[posLinha][posColuna + j] = '#';
                            break;
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
                    
                    switch (posLinha) {
                        case 0:
                            tabuleiro[posLinha + j][posColuna] = '#';
                            break;
                        case 7:
                            tabuleiro[posLinha - j][posColuna] = '#';
                            break;
                        case 6:
                            tabuleiro[posLinha - j][posColuna] = '#';
                            break;
                        default:
                            tabuleiro[posLinha + j][posColuna] = '#';
                            break;
                    }
                   
             }
                
                
           }else
                {for(int j = 0; j < 3; j++) {
                if(tabuleiro[posLinha][posColuna] != '~'){
                    System.out.println("Posicao ja preenchida");
                    break;
                }    
                    
                    switch (posLinha) {
                        case 0:
                            tabuleiro[posLinha][posColuna + j] = '#';
                            break;
                        case 7:
                            tabuleiro[posLinha][posColuna - j] = '#';
                            break;
                        case 6:
                            tabuleiro[posLinha][posColuna - j] = '#';
                            break;
                        default:
                            tabuleiro[posLinha][posColuna + j] = '#';
                            break;
                    }
                   
             }
               
           }
        }
        return tabuleiro;
    }
    public static char[][] atacar(int linha, int coluna, char[][]ataque, char[][] defesa){
        
        if(defesa[linha][coluna] == '#'){
        ataque[linha][coluna] = 'X';
        defesa[linha][coluna] = 'X';
        }else{
            ataque[linha][coluna] = 'O';
            defesa[linha][coluna] = 'O';
        }
        
        return ataque;
    }

    public static boolean verificarVitoria(char[][] tabuleiroDefesa) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tabuleiroDefesa[i][j] == '#') {
                    // Se encontrar qualquer parte de navio não atingida, o jogo não acabou
                    return false;
                }
            }
        }
        // Se o loop terminar e não encontrar nenhum '#', todos os navios foram afundados
        return true;
    }
    
    public static void imprimirTabuleiro(char[][] tabuleiro) {
        System.out.print("  ");
        for (int i = 0; i < 8; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < 8; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }
}
