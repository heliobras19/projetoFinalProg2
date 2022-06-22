/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cacapalavras;

import models.Palavra;

import java.util.Scanner;

/**
 *
 * @author heliobras
 */
public class CacaPalavras {

    static State state = new State();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
    setState();
    procurarPalavarasFrente();
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
