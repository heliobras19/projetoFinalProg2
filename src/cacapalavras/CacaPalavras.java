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
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        state.cacaPalavra = cacaPalavra();
        System.out.println("quantos cacas palavras");
        state.qtdCacaPalavra = input.nextInt();
        System.out.println("Quantas palavras");
        state.qtdPalavras = input.nextInt();
        state.palavras = new Palavra[state.qtdPalavras];
        for (int i = 0; i < state.qtdPalavras; i++) {
            System.out.println(i+1 +"º palavra: ");
            state.palavras[i] = new Palavra();
            String palavra = input.nextLine();
            state.palavras[i].content = palavra;
        }
    }

    static char [] [] cacaPalavra (){
        char[][] cacaPalavra = {
                {'a', 'a', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'g', 'g'},
                {'h', 'n', 'j', 'p', 'r', 'o', 'g', 'r', 'a', 'm', 'a'},
                {'a', 'g', 'u', 'a', 'k', 'a', 'o', 'o', 's', 'i', 't'},
                {'w', 'u', 'l', 'k', 'v', 'k', 'f', 'l', 'm', 'c', 'n'},
                {'f', 'l', 'q', 'o', 'g', 'a', 'y', 'w', 'i', 'h', 'd'},
                {'b', 'a', 'a', 'v', 'x', 'j', 'n', 's', 'u', 'p', 'w'},
                {'s', 'r', 'r', 'a', 'e', 't', 'y', 'b', 'h', 'r', 'b'},
                {'y', 'u', 'i', 'q', 'l', 'x', 'c', 'n', 'b', 'j', 'f'}
        };
        return  cacaPalavra;
    }

    static void procurarPalavaras (){

    }
}
