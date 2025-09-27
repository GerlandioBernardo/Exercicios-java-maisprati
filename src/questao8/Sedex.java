package src.questao8;

import java.math.BigDecimal;

public class Sedex implements CalculadoraFrete{

    private  void validarCep(String cep){
        if (cep == null || !cep.matches("\\d{8}")){
            throw new IllegalArgumentException("Cep Inválido");
        }
    }

    @Override
    public BigDecimal calcular(Pedido pedido) {
        validarCep(pedido.getCep());

        return new BigDecimal("20.00");
    }
}
