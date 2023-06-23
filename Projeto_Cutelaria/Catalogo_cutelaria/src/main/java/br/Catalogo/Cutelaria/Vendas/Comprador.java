package br.Catalogo.Cutelaria.Vendas;

import br.Catalogo.Cutelaria.Cadastro.Cadastro;

public class Comprador {
    private String nome;
    private int idade;
   private String localidade;
   private String itemCompra;
   private String modeloCompra;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getItemCompra() {
        return itemCompra;
    }

    public void setItemCompra(String itemCompra) {
        this.itemCompra = itemCompra;
    }

    public String getModeloCompra() {
        return modeloCompra;
    }

    public void setModeloCompra(String modeloCompra) {
        this.modeloCompra = modeloCompra;
    }

    public void comprarItem(Cadastro cadastro){

        if ((itemCompra.equals(cadastro.getModelo())) && (this.modeloCompra.equals(cadastro.getNome()))){
            System.out.println("Comprando um(a) "+cadastro.getModelo()+" com o nome de "+cadastro.getNome()+
                    " feito(a) de aço "+cadastro.getTipoAco()+" de valor: "+cadastro.getPreco()+" reais");
        }
        else {
            System.out.println("Item nao encontrado!");
        }

    }

    public void mostrarInfos(){
        System.out.println("****INFORMAÇÕES DO COMPRADOR****");
        System.out.println("Nome: "+this.getNome());
        System.out.println("Idade: "+this.getIdade()+" anos");
        System.out.println("Localidade: "+this.getLocalidade());
    }


}
