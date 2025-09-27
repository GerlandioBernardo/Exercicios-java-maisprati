package src.questao7;

public class Main {
    public static void main(String[] args) {
        IRepository<Produto, Long> produtoRepository = new InMemoryRepository<>();
        IRepository<Funcionario, String> funcionarioRepository = new InMemoryRepository<>();

        produtoRepository.salvar(new Produto("Notebook", 1L));
        produtoRepository.salvar(new Produto("Mouse", 2L));

        funcionarioRepository.salvar(new Funcionario("A123", "Maria"));
        funcionarioRepository.salvar(new Funcionario("B456", "João"));

        System.out.println("Produtos: ");
        produtoRepository.listarTodos().forEach(
                produto -> System.out.println(produto));

        System.out.println("\nFuncionarios: ");
        funcionarioRepository.listarTodos().forEach(
                funcionario -> System.out.println(funcionario));

        produtoRepository.buscarPorId(1L).ifPresent(
                produto -> System.out.println("\nProduto Encontrado: " + produto));

        produtoRepository.remover(2L);
        System.out.println("\nApós remover:");
        produtoRepository.listarTodos().forEach(System.out::println);

        // Tentar remover uma entidade inexistente (gera exceção)
        try {
            produtoRepository.remover(99L);
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("\nErro: " + e.getMessage());
        }
    }
}
