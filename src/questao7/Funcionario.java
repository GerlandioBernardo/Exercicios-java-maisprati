package src.questao7;

public class Funcionario implements  Identificavel<String>{

    private  String matricula;
    private  String nome;

    public Funcionario(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    @Override
    public String getID() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Funcionario{ " +
                "matricula=' " + matricula + '\'' +
                ", nome=' " + nome + '\'' +
                '}';
    }
}
