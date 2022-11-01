package model;

public class Condutor {

    private String nome;
    private long documento;
    private int telefone;

    public Condutor(){

    }
    public Condutor(String nome, long documento, int telefone) {
        this.nome = nome;
        this.documento = documento;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Nome: '" + nome + '\'' +
                ", Documento: " + documento +
                ", Telefone: " + telefone;
    }
}
