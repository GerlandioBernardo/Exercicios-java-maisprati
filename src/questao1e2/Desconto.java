package src.questao1e2;

public class Desconto extends  Produto{

    public void  aplicarDesconto(double porcentagem){

        if (porcentagem < 0 || porcentagem > 50){
            throw  new IllegalArgumentException("Desconto deve ser entre 0 e 50%");
        }

        double desconto = getPreco() * (porcentagem / 100);
        setPreco(getPreco() - desconto);
    }
}
