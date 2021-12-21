package mainbody;

public class Turma {
    private int idturma;
    private String nomeTurma;

    public Turma(){

    }



    public Turma(String nomeTur) {
        this.nomeTurma = nomeTur;
    }
    
    public int getIdturma() {
        return idturma;
    }
    public String getNomeTurma() {
        return nomeTurma;
    }
    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }
    public void setIdturma(int idturma) {
        this.idturma = idturma;
    }

    
}