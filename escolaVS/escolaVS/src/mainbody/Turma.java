package mainbody;

import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import conDAO.TurmaDAO;

public class Turma {
    private int idturma;
    private String nomeTurma;

    public Turma(){

    }

    public Turma(int idTur,String nomeTur) {
        this.nomeTurma = nomeTur;
        this.idturma = idTur;
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