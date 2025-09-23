package src.questao1e2;

public class Main {
    public static void main(String[] args) {
        Produto produto = new Produto();

        produto.setNome("Caderno");
        produto.setPreco(15.50);
        produto.setQuantidadeEmEstoque(10);


        System.out.println("Produto criado:");
        System.out.println("Nome: " + produto.getNome());
        System.out.println("Preço: " + produto.getPreco());
        System.out.println("Quantidade em estoque: " + produto.getQuantidadeEmEstoque());

        // Alterando com valores válidos;
        produto.setPreco(20.0);
        produto.setQuantidadeEmEstoque(20);
        System.out.println("\nValores alterados:");
        System.out.println("Preço: " + produto.getPreco());
        System.out.println("Quantidade em estoque: " + produto.getQuantidadeEmEstoque());

        System.out.println("\nMensagens de erro:");

        // Tentando atribuições inválidas
        try {
            produto.setNome(" ");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        try {
            produto.setPreco(-10.0);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        try {
            produto.setQuantidadeEmEstoque(-5);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


        // Teste para questão 2

        Desconto produtoDesconto = new Desconto();
        produtoDesconto.setNome("Livro");
        produtoDesconto.setPreco(60.0);
        produtoDesconto.setQuantidadeEmEstoque(5);

        System.out.println("\nQuestão 2: ");

        // Desconto válido
        try {
            produtoDesconto.aplicarDesconto(20);
            System.out.println("Preço após 20% de desconto é: " + produtoDesconto.getPreco());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        // Desconto inválido
        System.out.println("\nErro ao aplicar desconto: ");
        try {
            produtoDesconto.aplicarDesconto(70);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());

        }

    }
}
