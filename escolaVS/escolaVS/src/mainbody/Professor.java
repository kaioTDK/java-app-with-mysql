package mainbody;

public class Professor extends Pessoa {
    private int idprofessor;
    private int idpessoa;
    private int idturma;
    private String nome;
    private int idade;
    private double salario;

    public Professor() {
        
    }
    
    public Professor(int idturma, String nome, int idade, double salario) {
        this.idturma = idturma;
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }
    public int getIdpessoa() {
        return idpessoa;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdturma() {
        return idturma;
    }
    public void setIdturma(int idturma) {
        this.idturma = idturma;
    }
    public int getIdprofessor() {
        return idprofessor;
    }
    public void setIdprofessor(int idprofessor) {
        this.idprofessor = idprofessor;
    }
    public void setIdpessoa(int idpessoa) {
        this.idpessoa = idpessoa;
    }
}
