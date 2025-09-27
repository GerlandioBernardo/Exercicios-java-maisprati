package src.questao8;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Pedido pedido = new Pedido("12345678", new BigDecimal("100.00"), new Sedex());
        System.out.println("Frete com SEDEX: " + pedido.calcularFrete());

        // Trocar a estratégia em tempo de execução para PAC
        pedido.setEstrategiaFrete(new Pac());
        System.out.println("Frete com PAC: " + pedido.calcularFrete());

        // Trocar a estrategia para retirada na loja
        pedido.setEstrategiaFrete(new RetiradaNaLoja());
        System.out.println("Retirada na Loja: " + pedido.calcularFrete());

        // Estratégia promocional via lambda
        CalculadoraFrete fretePromocional = produto -> {
            if(produto.getValorTotal().compareTo(new BigDecimal("200")) >= 0){
                return BigDecimal.ZERO;
            }
            return  new BigDecimal("5");
        };

        pedido.setEstrategiaFrete(fretePromocional);
        System.out.println("Frete Promocional (lambda): " + pedido.calcularFrete());

        // Testar CEP inválido (lança exceção)
        try {
            Pedido pedidoInvalido = new Pedido("abc123", new BigDecimal("100.00"), new Sedex());
            System.out.println(pedidoInvalido.calcularFrete());
        }catch (IllegalArgumentException e){
            System.out.println("\nErro: " + e.getMessage());

        }
    }
}
