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

    public ArrayList<Professor> read() {

        Connection connection = MySQLcon.iniciarconexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Professor> professors = new ArrayList<>();

        try {
            stmt = connection.prepareStatement(" SELECT * FROM professor");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Professor prof = new Professor();
                
                prof.setIdturma(rs.getInt("idturma"));
                prof.setNome(rs.getString("nome"));
                prof.setIdade(rs.getInt("idade"));
                prof.setIdprofessor(rs.getInt("idprofessor"));
                prof.setSalario(rs.getDouble("Salario"));
                professors.add(prof);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professors;
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
            
            stmt = connection.prepareStatement("DELETE from professor WHERE idprofessor = ?");
            stmt.setInt(1, professor.getIdprofessor());
            stmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            MySQLcon.encerrarcon(connection,stmt);
        }
    }
    public void delete(int professor) {
        Connection connection = MySQLcon.iniciarconexao();
        PreparedStatement stmt = null;

        try {
            
            stmt = connection.prepareStatement("DELETE from professor WHERE idprofessor = ?");
            stmt.setInt(1, professor);
            stmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            MySQLcon.encerrarcon(connection,stmt);
        }
    }
}
