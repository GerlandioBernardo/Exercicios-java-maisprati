package src.questao3;

import java.math.BigDecimal;

public class Desenvolvedor extends  Funcionario{

    public Desenvolvedor(String nome, BigDecimal salario) {
        super(nome, salario);
    }

    @Override
    public BigDecimal calcularBonus() {
        return salario.multiply(BigDecimal.valueOf(0.1));
    }
}
