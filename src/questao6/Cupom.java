package src.questao6;

import java.math.BigDecimal;
import java.util.Objects;

public class Cupom {

    private  final BigDecimal percentual;
    private final String codigo;

    private static final BigDecimal PERCENTUAL_MAX = new BigDecimal("0.30");

    public Cupom(String codigo, BigDecimal percentual) {
        this.percentual = Objects.requireNonNull(percentual);
        this.codigo = Objects.requireNonNull(codigo);

        if(percentual.compareTo(BigDecimal.ZERO) < 0 || percentual.compareTo(PERCENTUAL_MAX) > 0){
            throw new IllegalArgumentException("O percentual do cupom deve estar entre 0% e 30%");
        }
    }

    public BigDecimal getPercentual() {
        return percentual;
    }

    public String getCodigo() {
        return codigo;
    }
}
