package src.questao1e2;

public class Produto {
    private  String nome;
    private Double preco;
    private  int quantidadeEmEstoque;

    public  Produto(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()){
            throw  new IllegalArgumentException("O nome  não pode ser nulo ou vazio");
        }
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        if(preco < 0 ){
            throw  new IllegalArgumentException("O Preço não pode ser negativo");
        }
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        if (quantidadeEmEstoque < 0){
            throw  new IllegalArgumentException("A quantidade em estoque não pode ser negativa");
        }
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
}
