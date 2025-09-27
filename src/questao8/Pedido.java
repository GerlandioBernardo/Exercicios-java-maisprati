package src.questao8;

import java.math.BigDecimal;

public class Pedido {
    private  String cep;
    private BigDecimal valorTotal;
    private CalculadoraFrete estrategiaFrete;

    public Pedido(String cep, BigDecimal valorTotal, CalculadoraFrete estrategiaFrete) {
        this.cep = cep;
        this.valorTotal = valorTotal;
        this.estrategiaFrete = estrategiaFrete;
    }

    public String getCep() {
        return cep;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public CalculadoraFrete getEstrategiaFrete() {
        return estrategiaFrete;
    }

    public void setEstrategiaFrete(CalculadoraFrete estrategiaFrete) {
        this.estrategiaFrete = estrategiaFrete;
    }

    public BigDecimal calcularFrete(){
        return  estrategiaFrete.calcular(this);
    }
}
