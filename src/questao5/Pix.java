package src.questao5;

import java.math.BigDecimal;

public class Pix  extends  FormaPagamento{

    private String chavePix;

    public Pix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        if(chavePix == null || chavePix.isEmpty()){
            throw  new PagamentoInvalidoException("Chave Pix inválida!");
        }

    }

    @Override
    public void processarPagamento(BigDecimal valor) throws PagamentoInvalidoException {

        if(valor.compareTo(BigDecimal.ZERO) < 0){
            throw  new PagamentoInvalidoException("O valor para realizar o pagamento precisa ser maior que zero");
        }

        validarPagamento();

        System.out.println("Pagamento de R$ " + valor + " realizado via Pix");
    }
}
