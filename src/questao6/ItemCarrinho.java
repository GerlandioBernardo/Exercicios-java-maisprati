package src.questao6;

import java.util.Objects;

public class ItemCarrinho {
    private  final Produto produto;
    private  final int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) {

        this.produto = Objects.requireNonNull(produto);
        if(quantidade < 0){
            throw  new IllegalArgumentException("A quantidade deve ser maior que zero");
        }
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public  Dinheiro total(){
        return  produto.getPreco().multiplicacao(quantidade);
    }
}
