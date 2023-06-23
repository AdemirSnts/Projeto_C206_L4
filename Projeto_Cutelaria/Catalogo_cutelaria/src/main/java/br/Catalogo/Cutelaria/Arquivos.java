package br.Catalogo.Cutelaria;

import br.Catalogo.Cutelaria.Cadastro.Cadastro;

import java.io.*;
import java.util.ArrayList;

public class Arquivos {
    public void escrever(Cadastro cadastro){
        // Importando as classes que nos permitirão escrever no Arquivo
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;


        try {
            // Recebe o nome do meu arquivo
            os = new FileOutputStream("Cadastro.txt", true);

            // Mostra em qual arquivo estaremos escrevendo
            osw = new OutputStreamWriter(os);

            // Permite que escrevamos no arquivo
            bw = new BufferedWriter(osw);

            // Efetivamente escrevendo no arquivo
            bw.write("***CADASTRO***\n");
            bw.write(cadastro.getModelo() + "\n");
            bw.write(cadastro.getNome() + "\n");
            bw.write(cadastro.getNumId() + "\n");
            bw.write(cadastro.getTipoAco() + "\n");
            bw.write(cadastro.getPreco() + "\n");


        }catch (Exception e) {
            System.out.println("ERRO: "+e);
        } finally {
            //Fechando a entrada de dados
            try {
                bw.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
        }

    }

    public ArrayList<Cadastro> ler() {

        //criando um array list que realiza o cadastro das facas e canivetes no arquivo
        ArrayList<Cadastro> cadastroEfetuado = new ArrayList<>();
        // Estruturas que servirão para a leitura dos dados
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        String linhaLer; // Auxiliar que servirá como ponteiro para ler o arquivo

        try {
            is = new FileInputStream("Cadastro.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);


            // Posiciando o cursor no inicio do Arquivo
            linhaLer = br.readLine();

            // Verificando e rodando o código enquanto tiver informações no txt
            while (linhaLer != null) {
                // Verificando se já estamos na estrutura do cadastro
                if (linhaLer.contains("***CADASTRO***")) {

                    //Criando uma variavel auxiliar para o cadastro
                    Cadastro auxCadastro = new Cadastro();

                    // Preenchendo as informações para o cadastro
                    auxCadastro.setModelo(br.readLine());
                    auxCadastro.setNome(br.readLine());
                    auxCadastro.setNumId(Integer.parseInt(br.readLine()));
                    auxCadastro.setTipoAco(br.readLine());
                    auxCadastro.setPreco(Double.parseDouble(br.readLine()));

                    //Adicionando o cadastro ao ArrayList
                    cadastroEfetuado.add(auxCadastro);
                }
                // Passando para a próxima linha
                linhaLer = br.readLine();
            }
        } catch (Exception e) {

        }finally{
            //Fechando o arquivo
            try{
                br.close();
            }catch(Exception e){
                System.out.println("ERRO: "+e);
            }
        }

        return cadastroEfetuado;
    }
}
