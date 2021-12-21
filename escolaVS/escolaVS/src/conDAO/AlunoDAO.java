package conDAO;

import connection.*;
import mainbody.*;
import java.sql.*;
import java.util.ArrayList;

public class AlunoDAO {
    
    public void create(Aluno aluno) {

        Connection connection = MySQLcon.iniciarconexao();
        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(" INSERT INTO aluno (idturma, nome, idade, notas) VALUES (?,?,?,?)");
            stmt.setInt(1, aluno.getIdturma());
            stmt.setString(2, aluno.getNome());
            stmt.setInt(3, aluno.getIdade());
            stmt.setDouble(4, aluno.getNotas());
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            MySQLcon.encerrarcon(connection,stmt);
        }

    }

    public ArrayList<Aluno> read(Aluno aluno) {

        Connection connection = MySQLcon.iniciarconexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Aluno> alunos = new ArrayList<>();

        try {
            stmt = connection.prepareStatement(" SELECT * FROM aluno");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Aluno alun = new Aluno();
                
                alun.setIdturma(rs.getInt("idturma"));
                alun.setNome(rs.getString("nome"));
                alun.setIdade(rs.getInt("idade"));
                alun.setIdaluno(rs.getInt("idaluno"));
                alun.setNotas(rs.getDouble("notas"));
                alunos.add(alun);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        finally {MySQLcon.encerrarcon(connection, stmt);
        }
        return alunos;
        
        
    }

     public ArrayList<Aluno> read ( Aluno aluno, int turma ) {

        Connection connection = MySQLcon.iniciarconexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Aluno> alunos = new ArrayList<>();

        try {
            stmt = connection.prepareStatement(" SELECT * FROM aluno WHERE idturma = ?");
            stmt.setInt(1, turma);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Aluno alun = new Aluno();
                
                alun.setIdturma(rs.getInt("idturma"));
                alun.setNome(rs.getString("nome"));
                alun.setIdade(rs.getInt("idade"));
                alun.setIdaluno(rs.getInt("idaluno"));
                alun.setNotas(rs.getDouble("notas"));
                alunos.add(alun);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            
            MySQLcon.encerrarcon(connection, stmt);
        }
        
        return alunos;
    }

    public void update(Aluno aluno) {

        Connection connection = MySQLcon.iniciarconexao();
        PreparedStatement stmt = null;

        try {
            
            stmt = connection.prepareStatement(" UPDATE aluno SET idturma = ?, nome = ?, idade = ?, notas = ?");
            stmt.setInt(1, aluno.getIdturma());
            stmt.setString(2, aluno.getNome());
            stmt.setInt(3, aluno.getIdade());
            stmt.setDouble(4, aluno.getNotas());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            MySQLcon.encerrarcon(connection,stmt);
        }
    }

    public void delete(Aluno aluno) {
        Connection connection = MySQLcon.iniciarconexao();
        PreparedStatement stmt = null;

        try {
            
            stmt = connection.prepareStatement("DELETE aluno WHERE idaluno = ?");
            stmt.setInt(1, aluno.getIdaluno());
            stmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            MySQLcon.encerrarcon(connection,stmt);
        }
    }
}
