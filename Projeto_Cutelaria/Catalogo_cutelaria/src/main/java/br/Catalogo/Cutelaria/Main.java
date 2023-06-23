package br.Catalogo.Cutelaria;

import br.Catalogo.Cutelaria.Cadastro.Cadastro;
import br.Catalogo.Cutelaria.Cadastro.NullException;
import br.Catalogo.Cutelaria.Vendas.Comprador;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Criando um comprador
        Comprador cliente = new Comprador();


        //Criando um array para mostrar as infos
        ArrayList<Cadastro> cadastros ;

        //Variavel que será usada para o cadastro
        Cadastro cadAuxiliar = new Cadastro();

        //Criando um arquivo
        Arquivos arq = new Arquivos();

        //Criando um menu de vendas
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        //Var auxiliar para colocar a opção de cadastro
        int op;
        while (flag){
            cadastros= arq.ler();

            System.out.println("1- Para fazer o cadastro de Facas e Canivetes");
            System.out.println("2- Mostrar os itens que estao para a venda");
            System.out.println("3- Sair do cadastro");

            op= sc.nextInt();

            switch (op){
                case 1:{


                    //Limpando o buffer
                    sc.nextLine();
                    System.out.println("Coloque o modelo: FACA OU CANIVETE ");
                    cadAuxiliar.setModelo( sc.nextLine());
                    System.out.println("Insira o nome: ");
                    cadAuxiliar.setNome( sc.nextLine());
                    System.out.println("Numero de identificacao: ");
                    cadAuxiliar.setNumId( sc.nextInt());
                    //Limpando o buffer
                    sc.nextLine();
                    try {
                        System.out.println("Tipo de aco: ");
                        cadAuxiliar.setTipoAco(sc.nextLine());
                        if (!(cadAuxiliar.getTipoAco().equalsIgnoreCase("carbono")))
                            if (!(cadAuxiliar.getTipoAco().equalsIgnoreCase("inox")))
                                if (!(cadAuxiliar.getTipoAco().equalsIgnoreCase("damasco")))

                                    throw new NullException("Insira um dos três tipoos de aço: CARBONO - INOX - DAMASCO ");

                    }catch(NullException s) {
                        System.out.println(s);
                        //Para a execução e não realiza mais o cadastro de facas e canivetes
                        break;
                    }

                    System.out.println("Preco: ");
                    cadAuxiliar.setPreco( sc.nextDouble());

                    //Escrevendo as informacoes do cadastro no arquivo
                    arq.escrever(cadAuxiliar);
                    break;
                }
                case 2: {
                    System.out.println("****MOSTRANDO AS FACAS E CANIVETES QUE ESTAO PARA A VENDA****");


                        for (int i = 0; i < cadastros.size(); i++) {
                           cadastros.get(i).mostrarInfos();
                    }
                    break;
                }
                case 3:{

                    flag=false;

                    break;
                }
            }
        }
        //Limpando o buffer
        sc.nextLine();

        System.out.println("---ENTRANDO COM AS INFOS DO CLIENTE---");
        System.out.println("Nome: ");
        cliente.setNome(sc.nextLine());
        System.out.println("Idade: ");
        cliente.setIdade(sc.nextInt());
        //Limpando o buffer
        sc.nextLine();
        System.out.println("Cidade e estado onde mora: ");
        cliente.setLocalidade(sc.nextLine());

        cliente.mostrarInfos();
        try {
            System.out.println("Digite o item que deseja comprar: ");
            cliente.setItemCompra(sc.nextLine());

            if(!(cliente.getItemCompra().equalsIgnoreCase("faca")))
            if(!(cliente.getItemCompra().equalsIgnoreCase("canivete")))
                throw new NullException("Escolha somente entre FACA ou CANIVETE");
        }catch (NullException s){
            System.out.println(s);
        }

            System.out.println("Digite o modelo que deseja comprar: ");
            cliente.setModeloCompra(sc.nextLine());
            cliente.comprarItem(cadAuxiliar);



        //Finalizando a entrada de dados
        sc.close();
    }
}
