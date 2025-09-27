package src.questao5;

import java.math.BigDecimal;

public class CartaoCredito extends  FormaPagamento{

    private  String numeroCartao;

    public CartaoCredito(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        if(numeroCartao == null || !numeroCartao.matches("\\d{16}")){
            throw  new PagamentoInvalidoException("Número do cartão de credito inválido!");
        }

    }

    @Override
    public void processarPagamento(BigDecimal valor) throws PagamentoInvalidoException {

        if(valor.compareTo(BigDecimal.ZERO) < 0){
            throw  new PagamentoInvalidoException("O valor para realizar o pagamento precisa ser maior que zero");
        }
        validarPagamento();

        System.out.println("Pagamento de R$ " + valor + " realizado com Cartão de Crédito.");

    }
}
