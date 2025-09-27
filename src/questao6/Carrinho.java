package src.questao6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Carrinho {
    private final Moeda moeda;
    private  final List<ItemCarrinho> itens;
    private  final Optional<Cupom> cupom;
    private static final RoundingMode ROUNDING = RoundingMode.HALF_EVEN;

    public Carrinho(Moeda moeda, List<ItemCarrinho> itens, Cupom cupom) {
        this.moeda = Objects.requireNonNull(moeda);
        this.itens = Collections.unmodifiableList(new ArrayList<>(Objects.requireNonNull(itens)));
        this.cupom = Optional.ofNullable(cupom);
    }

    public  static Carrinho vazio(Moeda moeda){
        return new Carrinho(moeda, Collections.emptyList(), null);
    }

    public Moeda getMoeda() {
        return moeda;
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public Optional<Cupom> getCupom() {
        return cupom;
    }

    public  Carrinho adicionarItem(Produto produto, int quantidade){
        Objects.requireNonNull(produto);

        if(quantidade <= 0 ){
            throw  new IllegalArgumentException("A quantidade precisa ser maior que zero");
        }
        if(!produto.getPreco().getMoeda().equals(this.moeda)){
            throw new IllegalArgumentException("Produto com moeda diferente do carrinho");
        }

        List<ItemCarrinho> copia = new ArrayList<>(this.itens);
        boolean merged = false;

        for(int i = 0; i < copia.size(); i++){
            ItemCarrinho itemCarrinho = copia.get(i);

            if(itemCarrinho.getProduto().equals(produto)){
                int novaQuantidade = itemCarrinho.getQuantidade() + quantidade;
                copia.set(i, new ItemCarrinho(produto, novaQuantidade));
                merged = true;
                break;
            }
        }

        if(!merged){
            copia.add(new ItemCarrinho(produto, quantidade));
        }

        return  new Carrinho(this.moeda, copia, this.cupom.orElse(null));

    }
    public  Carrinho removeItem(String produtoId){
        List<ItemCarrinho> copia = new ArrayList<>();
        for(ItemCarrinho itemCarrinho : itens){
            if(!itemCarrinho.getProduto().getId().equals(produtoId)){
                copia.add(itemCarrinho);
            }
        }
        return new Carrinho(this.moeda, copia, this.cupom.orElse(null));
    }
    public  Carrinho aplicarCupom(Cupom cupom){
        Objects.requireNonNull(cupom);
        return  new Carrinho(this.moeda, this.itens, cupom);
    }

    public  Dinheiro calcularTotalSemDesconto(){
        Dinheiro total = Dinheiro.zero(moeda);
        for(ItemCarrinho itemCarrinho : itens){
            total = total.adicionar(itemCarrinho.total());
        }
        return total;
    }

    public  Dinheiro calcularTotalComDesconto(){
        Dinheiro totalGeral = calcularTotalSemDesconto();

        if(cupom.isPresent()){
            BigDecimal percentualAplicado = cupom.get().getPercentual();

            BigDecimal descontoValor = totalGeral.getValor()
                    .multiply(percentualAplicado)
                    .setScale(2, ROUNDING);

            Dinheiro desconto = Dinheiro.of(descontoValor, moeda);
            return  totalGeral.subtracao(desconto);

        }
        return  totalGeral;
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "moeda= " + moeda +
                ", itens= " + itens +
                ", cupom= " + (cupom.isPresent() ? cupom.get().getCodigo() : "nenhum") +
                '}';
    }
}
