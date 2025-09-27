package src.questao6;

import src.questao6.*;

import java.math.BigDecimal;

public class Main{
    public static void main(String[] args) {

        // Criação dos produtos
        Produto caneta = new Produto("p1", "Caneta", Dinheiro.of("2.50", Moeda.BR));
        Produto caderno = new Produto("p2", "Caderno", Dinheiro.of("15.00", Moeda.BR));
        Produto mochila = new Produto("p3", "Mochila", Dinheiro.of("120.00", Moeda.BR));

        System.out.println("=== Produtos disponíveis ===");
        System.out.println(caneta.getNome() + " - " + caneta.getPreco());
        System.out.println(caderno.getNome() + " - " + caderno.getPreco());
        System.out.println(mochila.getNome() + " - " + mochila.getPreco());

        // Criação do carrinho vazio
        Carrinho carrinho = Carrinho.vazio(Moeda.BR);
        System.out.println("\nCarrinho inicial: " + carrinho);

        // Adicionando Itens
        carrinho = carrinho.adicionarItem(caneta, 3);
        carrinho = carrinho.adicionarItem(caderno, 2);
        carrinho = carrinho.adicionarItem(mochila, 1);

        System.out.println("\nCarrinho após adicionar itens:");
        for (ItemCarrinho item : carrinho.getItens()) {
            System.out.println(item.getQuantidade() + " " + item.getProduto().getNome()
                    + " = " + item.total());
        }
        System.out.println("Total sem desconto: " + carrinho.calcularTotalSemDesconto());

        // Aplicando Cupom
        Cupom cupom20 = new Cupom("PROMO20", new BigDecimal("0.20"));
        Carrinho carrinhoComDesconto = carrinho.aplicarCupom(cupom20);

        System.out.println("\nCarrinho após aplicar cupom de 20%:");
        System.out.println("Cupom aplicado: " + carrinhoComDesconto.getCupom().get().getCodigo());
        System.out.println("Total com desconto: " + carrinhoComDesconto.calcularTotalComDesconto());

        // Removendo Item
        Carrinho carrinhoAposRemocao = carrinhoComDesconto.removeItem("p2");

        System.out.println("\nCarrinho após remover o Caderno:");
        for (ItemCarrinho item : carrinhoAposRemocao.getItens()) {
            System.out.println(item.getQuantidade() + " " + item.getProduto().getNome()
                    + " = " + item.total());
        }
        System.out.println("Total sem desconto: " + carrinhoAposRemocao.calcularTotalSemDesconto());
        System.out.println("Total com desconto: " + carrinhoAposRemocao.calcularTotalComDesconto());

        // Testando Exceções
        try {
            carrinho.adicionarItem(caneta, 0); // quantidade inválida
        } catch (IllegalArgumentException e) {
            System.out.println("\nErro: " + e.getMessage());
        }

        try {
            new Cupom("PROMO50", new BigDecimal("0.50")); // cupom maior que 30%
        } catch (IllegalArgumentException e) {
            System.out.println("Erro (cupom inválido): " + e.getMessage());
        }
    }
}

