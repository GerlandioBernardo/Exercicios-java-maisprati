package src.questao3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Gerente("Alice", BigDecimal.valueOf(5000)));
        funcionarios.add(new Desenvolvedor("Bob", BigDecimal.valueOf(3000)));
        funcionarios.add(new Desenvolvedor("Diana", BigDecimal.valueOf(4000)));
        funcionarios.add(new Gerente("Carlos", BigDecimal.valueOf(7000)));

        for (Funcionario funcionario: funcionarios){
            System.out.println(funcionario.getNome() + " - Salário: " + funcionario.getSalario() +
                    " - Bônus: " + funcionario.calcularBonus());
        }

        // Testando com salario negativo

        try{
            Funcionario funcionarioSalarioNegativo = new Desenvolvedor("João",
                    BigDecimal.valueOf(-1000));
        }catch (IllegalArgumentException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
