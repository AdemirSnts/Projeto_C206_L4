package br.Catalogo.Cutelaria.Cadastro;

public class Cadastro {

    private String modelo;
    private String nome;
    private int numId;
    private String tipoAco;

    private double preco;

    public String getModelo() {

        return modelo;
    }

    public void setModelo(String modelo) {

        this.modelo = modelo;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public int getNumId() {

        return numId;
    }

    public void setNumId(int numId) {

        this.numId = numId;
    }

    public String getTipoAco() {

        return tipoAco;
    }

    public void setTipoAco(String tipoAco) {

        this.tipoAco = tipoAco;
    }

    public double getPreco() {

        return preco;
    }

    public void setPreco(double preco) {

        this.preco = preco;
    }

    public void mostrarInfos(){
        //System.out.println("Modelo: " + cadastros.get(i).getModelo());
        //System.out.println("Nome: " + cadastros.get(i).getNome());
        //System.out.println("Numero de identificacao: " +cadastros.get(i).getNumId());
        //System.out.println("Tipo de aco: " +cadastros.get(i).getTipoAco());
        //System.out.println("Valor do item: " + cadastros.get(i).getPreco()+ " R$");


        System.out.println("Modelo: " + getModelo());
        System.out.println("Nome: " + this.nome);
        System.out.println("Numero de identificacao: " +this.numId);
        System.out.println("Tipo de aco: " +this.tipoAco);
        System.out.println("Valor do item: " + this.preco+ " R$");
    }
}
