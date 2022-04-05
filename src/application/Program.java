//Nome: Uemerson Silva dos Santos
//Universidade: Faculdade Impacta Tecnologia
//Curso: Analise e Desenvolvimento de Sistemas
//Semestre atual: 2º Semestre
//Previsão de conclusão: Dez/2023


package application;

import entities.Pacote;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class Program {
    public static void main(String[] args) {
        List<Pacote> list = new ArrayList<>();
        File listaDeCodigos = new File("c:\\temp\\codigosDeBarras.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(listaDeCodigos);

            while (sc.hasNextLine()) {
                String codigoDeBarras = sc.nextLine();
                String codigoOrigem = codigoDeBarras.substring(0, 3);
                Integer intOrigem = Integer.parseInt(codigoOrigem);
                String codigoDestino = codigoDeBarras.substring(3, 6);
                Integer intDestino = Integer.parseInt(codigoDestino);
                String codigoLoggi = codigoDeBarras.substring(6, 9);
                String codigoVendedor = codigoDeBarras.substring(9, 12);
                String codigoTipoProduto = codigoDeBarras.substring(12, 15);

                Pacote pacote = new Pacote(codigoDeBarras, codigoOrigem, intOrigem, codigoDestino, intDestino, codigoLoggi, codigoVendedor, codigoTipoProduto);


                list.add(pacote);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }

        }
        for (Pacote pacote : list) {
            list.get(list.indexOf(pacote)).identificaCodigoOrigem(pacote.getOrigem());
            list.get(list.indexOf(pacote)).identificaCodigoDestino(pacote.getDestino());
            list.get(list.indexOf(pacote)).identificaCodigoLoggi(pacote.getCodigoLoggi());
            list.get(list.indexOf(pacote)).identificaCodigoVendedor(pacote.getCodigoVendedor());
            list.get(list.indexOf(pacote)).identificaCodigoTipoProduto(pacote.getTipoProduto());
            list.get(list.indexOf(pacote)).restricao();
        }


        System.out.println("1. Identificar a região de destino de cada pacote, com totalização de pacotes (soma região);");


        int sul = 0;
        int sudeste = 0;
        int centroOeste = 0;
        int nordeste = 0;
        int norte = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getValidacao()) {
                switch (list.get(i).getDestino()) {
                    case "região Centro-oeste":
                        centroOeste++;
                        break;
                    case "região Nordeste":
                        nordeste++;
                        break;
                    case "região Norte":
                        norte++;
                        break;
                    case "região Sudeste":
                        sudeste++;
                        break;
                    case "região Sul":
                        sul++;
                        break;
                }
            }
        }

        System.out.println();
        System.out.printf("Região Sul: %d pacotes%n", sul);
        System.out.printf("Região Sudeste: %d pacotes%n", sudeste);
        System.out.printf("Região Centro-Oeste: %d pacotes%n", centroOeste);
        System.out.printf("Região Nordeste: %d pacotes%n", nordeste);
        System.out.printf("Região Norte: %d pacotes%n", norte);

        System.out.println("..............................................................");
        System.out.println();
        System.out.println("2. Saber quais pacotes possuem códigos de barras válidos e/ou inválidos");


        for (Pacote pacote : list) {
            if (!pacote.getValidacao()) {
                System.out.println();
                System.out.printf("Pacote %d codigo de barras: %s invalido%n", (list.indexOf(pacote) + 1), pacote.getCodigoDeBarras());
            } else {
                System.out.println();
                System.out.printf("Pacote %d codigo de barras: %s valido%n", (list.indexOf(pacote) + 1), pacote.getCodigoDeBarras());
            }
        }

        System.out.println("..............................................................");
        System.out.println();
        System.out.println("3. Identificar os pacotes que têm como origem a região Sul e Brinquedos em seu conteúdo;");

        System.out.println();
        int cont = 0;
        for (Pacote pacote : list) {
            if (pacote.getValidacao()) {
                if ((pacote.getOrigem().equals("região Sul") && pacote.getTipoProduto().equals("Brinquedos"))) {
                    System.out.println(pacote);
                    System.out.println("...................................................");
                    cont++;
                }
            }
        }
        if (cont == 0) {
            System.out.println("Não há pacotes que têm como origem a região Sul e Brinquedos em seu conteúdo");
        }
        System.out.println("..............................................................");
        System.out.println();


        System.out.println("4. Listar os pacotes agrupados por região de destino (Considere apenas pacotes válidos);");

        System.out.println(".........Pacotes da região Sul.........");
        for (Pacote pacote : list){
            if (pacote.getValidacao()) {
                if (pacote.getDestino().equals("região Sul")) {
                    System.out.println();
                    System.out.printf("Pacote %d:%n", (list.indexOf(pacote)+1));
                    System.out.println(pacote);
                    System.out.println("...................................................");
                }
            }
        }

        System.out.println(".........Pacotes da região Sudeste.........");
        for (Pacote pacote : list){
            if (pacote.getValidacao()) {
                if (pacote.getDestino().equals("região Sudeste")) {
                    System.out.println();
                    System.out.printf("Pacote %d:%n", (list.indexOf(pacote)+1));
                    System.out.println(pacote);
                    System.out.println("...................................................");
                }
            }
        }

        System.out.println(".........Pacotes da região Centro-Oeste.........");
        for (Pacote pacote : list){
            if (pacote.getValidacao()) {
                if (pacote.getDestino().equals("região Centro-oeste")) {
                    System.out.println();
                    System.out.printf("Pacote %d:%n", (list.indexOf(pacote)+1));
                    System.out.println(pacote);
                    System.out.println("...................................................");
                }
            }
        }

        System.out.println(".........Pacotes da região Nordeste.........");
        for (Pacote pacote : list){
            if (pacote.getValidacao()) {
                if (pacote.getDestino().equals("região Nordeste")) {
                    System.out.println();
                    System.out.printf("Pacote %d:%n", (list.indexOf(pacote)+1));
                    System.out.println(pacote);
                    System.out.println("...................................................");
                }
            }
        }

        System.out.println(".........Pacotes da região Norte.........");
        for (Pacote pacote : list){
            if (pacote.getValidacao()) {
                if (pacote.getDestino().equals("região Norte")) {
                    System.out.println();
                    System.out.printf("Pacote %d:%n", (list.indexOf(pacote)+1));
                    System.out.println(pacote);
                    System.out.println("...................................................");
                }
            }
        }
        System.out.println("..............................................................");
        System.out.println();

        System.out.println("5. Listar o número de pacotes enviados por cada vendedor (Considere apenas pacotes válidos);");

        Map<String, Integer> map = new HashMap<>();
        for (Pacote pacote : list) {
            if (pacote.getValidacao()) {
                if (map.get(pacote.getCodigoVendedor()) == null) {
                    map.put(pacote.getCodigoVendedor(), pacote.getQuantidade());
                } else {
                    map.put(pacote.getCodigoVendedor(), pacote.getQuantidade() + map.get(pacote.getCodigoVendedor()));
                }
            }
        }
        for (String vendedor: map.keySet()) {
            System.out.println("Vendedor " + vendedor + " esta enviando " + map.get(vendedor) + " pacotes");
        }
        System.out.println("..............................................................");
        System.out.println();

        System.out.println("6. Gerar o relatório/lista de pacotes por destino e por tipo (Considere apenas pacotes válidos);");

        System.out.println("Não processado");

        System.out.println("..............................................................");
        System.out.println();

        System.out.println("7. Se o transporte dos pacotes para o Norte passa pela Região Centro-Oeste, quais são os pacotes que devem ser despachados no mesmo caminhão?");

        for (Pacote pacote : list) {
            if (pacote.getValidacao()) {
                if((pacote.getCodDestino() >= 201) && (pacote.getCodDestino() <= 400) ){
                    System.out.println();
                    System.out.printf("Pacote %d:%n", (list.indexOf(pacote)+1));
                    System.out.println(pacote);
                    System.out.println("...................................................");
                }
            }
        }
        System.out.println("..............................................................");
        System.out.println();
        System.out.println("8. Se todos os pacotes fossem uma fila qual seria a ordem de carga para o Norte no caminhão para descarregar os pacotes da Região Centro Oeste primeiro;");

        System.out.println("9. No item acima considerar que as jóias fossem sempre as primeiras a serem descarregadas;");

        Collections.sort(list);
        for (Pacote pacote : list) {
            if (pacote.getValidacao()) {
                if (!pacote.getTipoProduto().equals("Joias") && !pacote.getCodDestino().equals("região Centro-oeste")) {
                    System.out.println();
                    System.out.printf("Pacote %d:%n", (list.indexOf(pacote)+1));
                    System.out.println(pacote);
                    System.out.println("...................................................");
                }
            }
        }

        for (Pacote pacote : list) {
            if (pacote.getValidacao()) {
                if (pacote.getTipoProduto().equals("Joias") || pacote.getCodDestino().equals("região Centro-oeste")) {
                    System.out.println();
                    System.out.printf("Pacote %d:%n", (list.indexOf(pacote)+1));
                    System.out.println(pacote);
                    System.out.println("...................................................");
                }
            }
        }


        System.out.println("..............................................................");
        System.out.println();
        System.out.println("10. Listar os pacotes inválidos.");
        for (Pacote pacote : list) {
            if (!pacote.getValidacao()) {
                System.out.println();
                System.out.printf("Pacote %d:%n", (list.indexOf(pacote)+1));
                System.out.println(pacote);
                System.out.println("...................................................");
            }
        }
    }
}


