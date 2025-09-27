package src.questao5;

import java.math.BigDecimal;

public class Boleto extends FormaPagamento{

    private  String codigoBarras;

    public Boleto(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        if (codigoBarras == null || !codigoBarras.matches("\\d{47}")){
            throw  new PagamentoInvalidoException("Codigo de barras inválido");
        }

    }

    @Override
    public void processarPagamento(BigDecimal valor) throws PagamentoInvalidoException {

        if(valor.compareTo(BigDecimal.ZERO) < 0){
            throw  new PagamentoInvalidoException("O valor para realizar o pagamento precisa ser maior que zero");
        }
        validarPagamento();

        System.out.println("Pagamento de R$ " + valor + " realizado via Boleto.");

    }
}
