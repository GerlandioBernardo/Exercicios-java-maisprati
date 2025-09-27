package src.questao7;

public class Produto implements Identificavel<Long> {
    private  String nome;
    private  Long id;

    public Produto(String nome, Long id) {
        this.nome = nome;
        this.id = id;
    }

    @Override
    public Long getID() {
        return  id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Produto{ " +
                "nome=' " + nome + '\'' +
                ", id= " + id +
                '}';
    }
}
