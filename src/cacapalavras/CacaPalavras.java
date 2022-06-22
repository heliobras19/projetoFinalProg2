/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cacapalavras;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.Palavra;

/**
 *
 * @author heliobras
 */
public class CacaPalavras {

    static State state = new State();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
    //setState();
    //procurarPalavarasFrente();

    Scanner key = new Scanner(System.in);
    int number = key.nextInt(), antCaca = 0;

    System.out.println();
    
    for(int i=1; i <= number;i++){
        antCaca += caca_Palavras(antCaca);
        System.out.println();
     }
}

static int caca_Palavras(int antCaca) {
    Scanner key = new Scanner(System.in);
    int m = key.nextInt(), n = key.nextInt(); // m-> numero de linhas e n-> numero de colunas

    //entrada_Manual(m, n);
    
    busca_Palavras(entrada_Ficheiro(m, n, antCaca));
    return (m*n);
}

static char[][] entrada_Manual(int m, int n) {
    char tabela[][] = new char[m][n];

    for(int i=0; i < m; i++){
        Scanner key = new Scanner(System.in);
        String word = key.nextLine();
        String linha[] = word.split(" ");
        for(int j=0; j < n; j++){
            tabela[i][j] = linha[j].charAt(0);
        }
    }
  
    return tabela;
}

static char[][] entrada_Ficheiro(int m, int n, int antCaca) {
    char tabela[][] = new char[m][n];
    
    int linha=0, coluna=0, cont=0;
    char letra;

    Scanner ficheiro; 
    try { 
        ficheiro = new Scanner(new File("cacaPalavras.txt"));
        while (ficheiro.hasNext()) {
            letra = ficheiro.next().charAt(0);
            if(cont >= antCaca){
                tabela[linha][coluna] = letra;
                coluna++;
            
                if(coluna == n){
                    linha++;
                    coluna = 0;
                }
            
                if(linha == m){
                    break;
                }  
            }
            cont++;
        }
        
        ficheiro.close();
        
    } catch (FileNotFoundException e) {
        System.out.println(e.getMessage());
    }
    
    for(int i=0; i < m; i++){
        for(int j=0; j < n; j++){
            System.out.print(tabela[i][j] + " ");
        }
        System.out.println();
    }
    
    return tabela;
}

static void busca_Palavras(char tabela[][]) {
    Scanner ficheiro;
    Scanner key = new Scanner(System.in);
    
    int k = key.nextInt();
    
    try { 
        ficheiro = new Scanner(new File("palavras.txt"));
        
        while (ficheiro.hasNext()) {
            System.out.println( ficheiro.next());// -> gera as palavras que estao no ficheiro para procurar no caÇa palavras       
        }
        
        ficheiro.close();
        
    } catch (FileNotFoundException e) {
        System.out.println(e.getMessage());
    }
}
    static char [] [] sopaPalavra (){
        char[][] sopaPalavra = {
                {'a', 'a', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'g', 'g'},
                {'h', 'n', 'j', 'p', 'r', 'o', 'g', 'r', 'a', 'm', 'a'},
                {'a', 'g', 'u', 'a', 'k', 'a', 'o', 'o', 's', 'i', 't'},
                {'w', 'u', 'l', 'k', 'v', 'k', 'f', 'l', 'm', 'c', 'n'},
                {'f', 'l', 'q', 'o', 'g', 'a', 'y', 'w', 'i', 'h', 'd'},
                {'b', 'a', 'a', 'v', 'x', 'j', 'n', 's', 'u', 'p', 'w'},
                {'s', 'r', 'r', 'a', 'e', 't', 'y', 'b', 'h', 'r', 'b'},
                {'y', 'u', 'i', 'q', 'l', 'x', 'c', 'n', 'b', 'j', 'f'}
        };
        return  sopaPalavra;
    }

    static void setState(){
        state.cacaPalavra = sopaPalavra();
        System.out.println("quantos cacas palavras ? ");
        state.qtdCacaPalavra = input.nextInt();
        System.out.println("Quantas palavras");
        state.qtdPalavras = input.nextInt();
        state.palavras = new Palavra[state.qtdPalavras];
        state.palavras[0] = new Palavra();
        state.palavras[0].content = input.nextLine();
        for (int i = 1; i < state.qtdPalavras; i++) {
            System.out.println(i +"º palavra: ");
            state.palavras[i-1] = new Palavra();
            String palavra = input.nextLine();
            state.palavras[i-1].content = palavra;
        }
    }

    static void procurarPalavarasFrente (){
        StringBuilder palavra = new StringBuilder();
        char [][] sopaPalavras = state.cacaPalavra;
        String procurada = "higg";
        int caracter = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 11; j++) {
                if (palavra.toString().equals(procurada)){
                    break;
                }
                if (sopaPalavras[i][j] == procurada.charAt(caracter)){
                    palavra.append(sopaPalavras[i][j]);
                    caracter++;
                }else {
                    caracter = 0;
                }
            }
        }
        System.out.println("Encotrou "+palavra.toString());
    }
}
