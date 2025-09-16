/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculosprimos_theades_v4;

/**
 *
 * @author HenriqueBrosa
 * teste
 */
public class Principal {

    public static void main(String[] args) {

        long inicio = 1;  
        long fim = 500000000;     
        long n = 4;        
        
        System.out.println("Números primos do intervalo " + inicio + " e " + fim + ":");
        
        
        long tamanho = (fim - inicio + 1);      
        long passo = tamanho / n;               
        long resto = tamanho % n;               
        long atual = inicio;                    
        for (long i = 1; i <= n; i++) {
            long extra = (i <= resto) ? 1 : 0;  
            long fimIntervalo = atual + passo + extra - 1;

            System.out.println("Sub-intervalo " + i + ": [" + atual + ", " + fimIntervalo + "]");

            
            CalculosPrimos cp = new CalculosPrimos(atual, fimIntervalo);
            
            
            Thread t = new Thread(cp);        
            t.start();
            
            
            atual = fimIntervalo + 1;
        }
    }
}