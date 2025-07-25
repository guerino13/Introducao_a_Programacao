package batalhanaval;

import java.util.Random;
import java.util.Scanner;

public class BatalhaNaval {

    public static int vez = 1; //Variavel global para controlar os turnos de cada jogador. 1 é vez do jogador 1 e 2 do jogador 2

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] ataqueJog1 = inicializarTabuleiro();
        char[][] defesaJog1 = new char[8][8];
        char[][] ataqueJog2 = inicializarTabuleiro();
        char[][] defesaJog2 = new char[8][8];
        int op = 0; //Variavel que comanda a ação do jogador de acordo com sua escolha
        int ataqueLinha, ataqueColuna;
        int rodada = 1;
        


        while (rodada <= 40) {
            char[][] atacante = vez == 1 ? ataqueJog1 : ataqueJog2;
            char[][] defensor = vez == 1 ? defesaJog2 : defesaJog1;

            System.out.println("Vez do jogador " + vez + ". Escolha sua proxima acao.\n");
            System.out.println("======= MENU =======\n" +
                    "1- Posicionar navios automaticamente\n" +
                    "2- Atacar oponente\n" +
                    "3- Ver tabuleiro de ataques\n" +
                    "4- Ver rodadas restantes\n" +
                    "5- Sair do jogo\n" +
                    "====================\n");

            op = sc.nextInt();

            switch (op) {
                //Caso 1 é o inicio do jogo, posicionando os navios dos jogadores de maneira aleatória.
                case 1:
                    System.out.println("Posicionando seus navios...");
                    if(vez == 1){
                        posNavio(defesaJog1);
                        //Posicionamento dos navios.
                    } else {
                        posNavio(defesaJog2);
                        //Posicionamento dos navios.
                    }
                    trocaVez();//Função responsável pela troca de turnos.
                    rodada++;
                    break;

                //Caso 2 é a ação de ataque do jogador.
                case 2:
                    System.out.println("Selecione a linha a ser atacada.");
                    ataqueLinha = sc.nextInt();
                    System.out.println("Selecione a coluna a ser atacada.");
                    ataqueColuna = sc.nextInt();
                    atacar(ataqueLinha, ataqueColuna, atacante, defensor); //Chamada da função "atacar", que atualiza as posições ja atacadas pelo jogador.
                    if (verificarVitoria(defensor)) {
                        System.out.println("FIM DE JOGO! O JOGADOR 1 VENCEU! Todos os navios adversários foram destruídos! \n");
                        System.out.println("Tabuleiros do jogador 2: \n");
                        imprimirTabuleiro(ataqueJog2);
                        imprimirTabuleiro(defesaJog2);
                        System.out.println("\nTabuleiros do jogador 1: \n");
                        imprimirTabuleiro(ataqueJog1);
                        imprimirTabuleiro(defesaJog1);
                        rodada = 50;
                    }
                    trocaVez();
                    rodada++;
                    break;

                //Chama a função para exibir a matriz que representa o tabuleiro de ataque do jogador.
                case 3:
                    imprimirTabuleiro(atacante);
                    break;

                //Caso 4 exibe o numero de rodadas restantes
                case 4:
                    System.out.println("O numero de rodadas restantes eh de: " + (40 - rodada) + "\n");
                    break;

                //Caso 5 finaliza o jogo, caso o jogador deseje.
                case 5:
                    rodada = 50;
                    break;

            }
            if(rodada == 40){
                verificarEmpate(ataqueJog1, ataqueJog2);
                //Função que va verificar o vencedor (ou não) caso nenhum jogador consiga acertar todos os navios antes do limite de rodadas. 
            }
        }

    }
    
    public static void verificarEmpate(char[][] ataqueJ1, char[][] ataqueJ2){
       //Função responsável pela verificação se há ou não algum vencedor, caso o limite de rodadas seja atingido.
        int acertosJ1 = 0;
        int acertosJ2 = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(ataqueJ1[i][j] == 'X'){
                    acertosJ1++;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(ataqueJ2[i][j] == 'X'){
                    acertosJ2++;
                }
            }
        }
        //Os acertos são contados e depois passam para a estrutura condcional para a verificação de condições.
        
        if(acertosJ1 > acertosJ2){
            System.out.println("O Jogador 1 é o vencedor com " + acertosJ1 + " acertos");
        } 
        else if(acertosJ1 == acertosJ2){
            System.out.println("Empate total!");
        }
        else{
            System.out.println("O Jogador 2 é o vencedor com " + acertosJ1 + " acertos");
        }
    }

    public static void trocaVez() {
       //Função responsável por estar sempre atualizando o truno dos jogadores
        if (vez == 1) {
            vez = 2;
        } else {
            vez = 1;
        }
    }

    public static char[][] posNavio(char[][] tabuleiro) {
        //Função responsável pelo posicionamento dos návios no começo do jogo.
        Random rand = new Random();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(tabuleiro[i][j] == '#'){
                    return tabuleiro;
                } else {
                    tabuleiro[i][j] = '~';
                }
            }
        }
        //Laço que impede que os jogadores fiquem reposicionando seus navios sempre, permitindo trapaças.
        
        int navG = 1;
        int navM = 2;
        int navP = 3;
        //Tamanho dos navios.
        
        while(navG > 0){
            int lin = rand.nextInt(6);//Variável que sorteia a posição da linha a ser posicionada.
            int col = rand.nextInt(6);//Variável que sorteia a posição da coluna a ser posicionada.
            boolean horizontal = rand.nextInt(2) == 0;//Variável que cuida do orientação do posicionamento.
                                                      //Em caso verdadeiro, posicionamento será horizontal.

            if(horizontal) {
                if (tabuleiro[lin][col] == '~' && tabuleiro[lin][col + 1] == '~' && tabuleiro[lin][col + 2] == '~'){
                    tabuleiro[lin][col] = '#';
                    tabuleiro[lin][col + 1] = '#';
                    tabuleiro[lin][col + 2] = '#';
                    navG--;
                }
            } else {
                if(tabuleiro[lin][col] == '~' && tabuleiro[lin + 1][col] == '~' && tabuleiro[lin + 2][col] == '~'){
                    tabuleiro[lin][col] = '#';
                    tabuleiro[lin + 1][col] = '#';
                    tabuleiro[lin + 2][col] = '#';
                    navG--;
                }
            }
        }
        //Laço de repetição que faz o posicionamento do respectivo navio.
        //Estrutura condicional faz a verificação da posição sorteada, 
        //vendo se é possível o poisicionamento, evitando que exista sobreposições e criando um limite para que o navio esteja sempre dentro do array. 
        
        while(navM > 0){
            int lin = rand.nextInt(7);
            int col = rand.nextInt(7);
            boolean horizontal = rand.nextInt(2) == 0;

            if(horizontal) {
                if (tabuleiro[lin][col] == '~' && tabuleiro[lin][col + 1] == '~'){
                    tabuleiro[lin][col] = '#';
                    tabuleiro[lin][col + 1] = '#';
                    navM--;
                }
            } else {
                if(tabuleiro[lin][col] == '~' && tabuleiro[lin + 1][col] == '~'){
                    tabuleiro[lin][col] = '#';
                    tabuleiro[lin + 1][col] = '#';
                    navM--;
                }
            }
        }
        //Laço de repetição que faz o posicionamento do respectivo navio.
        //Estrutura condicional faz a verificação da posição sorteada, 
        //vendo se é possível o poisicionamento, evitando que exista sobreposições e criando um limite para que o navio esteja sempre dentro do array. 
        
        while(navP > 0){
            int lin = rand.nextInt(8);
            int col = rand.nextInt(8);

            if(tabuleiro[lin][col] == '~'){
                tabuleiro[lin][col] = '#';
                navP--;
            }
        }
        //Laço de repetição que faz o posicionamento do respectivo navio.
        //Estrutura condicional faz a verificação da posição sorteada, 
        //vendo se é possível o poisicionamento. Neste caso, não é necessário criar limite
        //pois o navio só ocupa uma posição dentro do array.

        return tabuleiro;
    }
    public static char[][] atacar(int linha, int coluna, char[][]ataque, char[][] defesa){
        //Função que realiza o ataque do jogador.
        
        if(defesa[linha][coluna] == '#'){
            ataque[linha][coluna] = 'X';
            defesa[linha][coluna] = 'X';
        }else{
            ataque[linha][coluna] = 'O';
            defesa[linha][coluna] = 'O';
        }
        //A matriz que representa tanto o tabuleiro de ataque do jogador atacante, 
        //quanto o tabuleiro de defesa que será atacado será atualizada com um X indicando acerto
        //ou O indicando um erro
        return ataque;
    }

    public static boolean verificarVitoria(char[][] tabuleiroDefesa) {
       //Função responsável pela verificação de vitória em toda rodada.
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tabuleiroDefesa[i][j] == '#') {
                    return false;
                }
            }
            // Se encontrar qualquer parte de navio não atingida(#), o jogo não acabou
        }
        // Se o loop terminar e não encontrar nenhum '#', todos os navios foram afundados
        return true;
    }

    public static void imprimirTabuleiro(char[][] tabuleiro) {
        //Função responsável apenas pela impressão do tabuleiro, sendo pedido pelo jogador
        //ou então quando o jogo acabar.
        
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

    public static char[][] inicializarTabuleiro() {
        //Função para inicializar o tabuleiro apenas com agua (~), sem navios(#) para poder fazer o posicionamento.
        char[][] tabuleiro = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabuleiro[i][j] = '~';
            }
        }
        return tabuleiro;
    }
}