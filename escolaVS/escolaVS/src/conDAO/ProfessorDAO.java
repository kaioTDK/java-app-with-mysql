package conDAO;

import connection.*;
import mainbody.*;
import java.sql.*;
import java.util.ArrayList;

public class ProfessorDAO {
    
    public void create(Professor professor) {

        Connection connection = MySQLcon.iniciarconexao();
        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(" INSERT INTO professor (idturma, nome, idade, Salario) VALUES (?,?,?,?)");
            stmt.setInt(1, professor.getIdturma());
            stmt.setString(2, professor.getNome());
            stmt.setInt(3, professor.getIdade());
            stmt.setDouble(4, professor.getSalario());
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            MySQLcon.encerrarcon(connection,stmt);
        }

    }

    public void read(Professor professor) {

        Connection connection = MySQLcon.iniciarconexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Professor> professors = new ArrayList<>();

        try {
            stmt = connection.prepareStatement(" SELECT * FROM professor");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Professor alun = new Professor();
                
                alun.setIdturma(rs.getInt("idturma"));
                alun.setNome(rs.getString("nome"));
                alun.setIdade(rs.getInt("idade"));
                alun.setIdprofessor(rs.getInt("idprofessor"));
                alun.setSalario(rs.getDouble("Salario"));
                professors.add(alun);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Professor professor) {

        Connection connection = MySQLcon.iniciarconexao();
        PreparedStatement stmt = null;

        try {
            
            stmt = connection.prepareStatement(" UPDATE professor SET idturma = ?, nome = ?, idade = ?, Salario = ?");
            stmt.setInt(1, professor.getIdturma());
            stmt.setString(2, professor.getNome());
            stmt.setInt(3, professor.getIdade());
            stmt.setDouble(4, professor.getSalario());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            MySQLcon.encerrarcon(connection,stmt);
        }
    }

    public void delete(Professor professor) {
        Connection connection = MySQLcon.iniciarconexao();
        PreparedStatement stmt = null;

        try {
            
            stmt = connection.prepareStatement("DELETE professor WHERE idprofessor = ?");
            stmt.setInt(1, professor.getIdprofessor());
            stmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            MySQLcon.encerrarcon(connection,stmt);
        }
    }
}
