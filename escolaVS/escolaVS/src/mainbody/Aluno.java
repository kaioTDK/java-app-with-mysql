package mainbody;

public class Aluno extends Pessoa {
    
    private int idaluno;
    private int idpessoa;
    private int idturma;
    private double notas;
    
    public Aluno() {

    }

    public Aluno(int idturma, String nome, int idade, double notas) {
        this.setIdturma(idturma);
        this.setNome(nome);
        this.setIdade(idade);
        this.setNotas(notas);
    }

    public int getIdaluno() {
        return idaluno;
    }

    public void setIdaluno(int idaluno) {
        this.idaluno = idaluno;
    }

    public int getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(int idpessoa) {
        this.idpessoa = idpessoa;
    }

    public int getIdturma() {
        return idturma;
    }

    public void setIdturma(int idturma) {
        this.idturma = idturma;
    }

    public double getNotas() {
        return notas;
    }

    public void setNotas(double notas) {
        this.notas = notas;
    }
}
