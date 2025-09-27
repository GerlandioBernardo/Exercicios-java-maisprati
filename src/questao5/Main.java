package src.questao5;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<FormaPagamento> formaPagamentos = new ArrayList<>();

        formaPagamentos.add(new CartaoCredito("1234567890123456"));
        formaPagamentos.add(new Boleto("12345678901234567890123456789012345678901234567"));
        formaPagamentos.add(new Pix("exemplo@gmail.com"));

        formaPagamentos.add(new CartaoCredito("1234")); // inválido para testar exceção

        for (FormaPagamento pagamento : formaPagamentos){
            try{
                pagamento.processarPagamento(new BigDecimal(200));

            }catch (PagamentoInvalidoException pagamentoInvalidoException){
                System.out.println("Erro: " + pagamentoInvalidoException.getMessage());
            }
        }
    }
}
