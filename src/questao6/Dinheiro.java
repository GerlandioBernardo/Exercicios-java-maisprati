package src.questao6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class Dinheiro implements Comparable<Dinheiro> {

    private  static final int SCALE = 2;
    private  static  final RoundingMode ROUNDING = RoundingMode.HALF_EVEN;

    private  final BigDecimal valor;
    private  final Moeda moeda;

    public Dinheiro(BigDecimal valor, Moeda moeda) {

        Objects.requireNonNull(valor, "valor");
        Objects.requireNonNull(moeda, "Moeda");

        BigDecimal normalized = valor.setScale(SCALE, ROUNDING);
        if(normalized.compareTo(BigDecimal.ZERO) < 0 ){
            throw new IllegalArgumentException("Valor de dinheiro não pode ser negativo");
        }

        this.valor = normalized;
        this.moeda = moeda;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Moeda getMoeda() {
        return moeda;
    }

    private void verificarMesmaMoeda(Dinheiro outra) {
        if(!this.moeda.equals(outra.moeda)){
            throw  new IllegalArgumentException("Não pode somar moedas diferentes");
        }
    }
    public  Dinheiro adicionar(Dinheiro outra){
        verificarMesmaMoeda(outra);
        return new Dinheiro(this.valor.add(outra.valor), moeda);
    }

    public  Dinheiro subtracao(Dinheiro dinheiro){
        verificarMesmaMoeda(dinheiro);

        BigDecimal resultado = this.valor.subtract(dinheiro.valor).setScale(SCALE, ROUNDING);

        if(resultado.compareTo(BigDecimal.ZERO) < 0){
            throw  new IllegalArgumentException("Resultado da subtração não pode ser negativo");
        }
        return  new Dinheiro(resultado, moeda);
    }
    public Dinheiro multiplicacao(int factor) {
        if (factor < 0){
            throw new IllegalArgumentException("Fator negativo");
        }
        return new Dinheiro(this.valor.multiply(BigDecimal.valueOf(factor)), moeda);
    }

    public Dinheiro multiplicacao(BigDecimal factor) {
        if (factor == null) throw new NullPointerException("factor");
        return new Dinheiro(this.valor.multiply(factor), moeda);
    }
    public static Dinheiro of(BigDecimal valor, Moeda moeda) {
        return new Dinheiro(valor, moeda);
    }

    public static Dinheiro of(String valor, Moeda moeda) {
        return new Dinheiro(new BigDecimal(valor), moeda);
    }

    public static Dinheiro zero(Moeda moeda) {
        return new Dinheiro(BigDecimal.ZERO, moeda);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dinheiro)) return false;
        Dinheiro other = (Dinheiro) o;
        return valor.equals(other.valor) && moeda == other.moeda;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, moeda);
    }

    @Override
    public String toString() {
        return moeda + " " + valor.toPlainString();
    }

    @Override
    public int compareTo(Dinheiro dinheiro) {
        verificarMesmaMoeda(dinheiro);
        return this.valor.compareTo(dinheiro.valor);
    }

}
