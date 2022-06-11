//Nome: Uemerson Silva dos Santos
//Universidade: Faculdade Impacta Tecnologia
//Curso: Analise e Desenvolvimento de Sistemas
//Semestre atual: 2º Semestre
//Previsão de conclusão: Dez/2023


package application;

import entities.Pacote;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Program {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("c:\\temp\\codigosDeBarras.txt"))) {

            List<Pacote> pacotes = new ArrayList<>();

            String linha = br.readLine();
            while (linha != null) {
                Integer codigoDeOrigem = Integer.parseInt(linha.substring(0,3));
                Integer codigoDeDestino = Integer.parseInt(linha.substring(3,6));
                Integer codigoLoggi = Integer.parseInt(linha.substring(6,9));
                Integer codigoVendedor = Integer.parseInt(linha.substring(9,12));
                Integer codigoTipoProduto = Integer.parseInt(linha.substring(12,15));

                pacotes.add(new Pacote(codigoDeOrigem, codigoDeDestino, codigoLoggi, codigoVendedor, codigoTipoProduto));

                linha = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


