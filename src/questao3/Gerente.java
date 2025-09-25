package src.questao3;

import java.math.BigDecimal;

public class Gerente extends Funcionario{

    public Gerente(String nome, BigDecimal salario) {
        super(nome, salario);
    }

    @Override
    public BigDecimal calcularBonus() {
        return salario.multiply(BigDecimal.valueOf(0.2));
    }
}
