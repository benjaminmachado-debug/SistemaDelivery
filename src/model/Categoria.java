package model;

// classe simples que representa uma Categoria de produto (ex: Lanches, Bebidas)
public class Categoria {

    private int id;
    private String nome;

    public Categoria() {
    }

    public Categoria(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        // usado para exibir a categoria dentro do JComboBox da tela de Produto
        return id + " - " + nome;
    }
}
