package conDAO;

import mainbody.*;
import java.sql.*;
import java.util.ArrayList;
import connection.MySQLcon;

public class TurmaDAO {

    public void create(Turma turma) {

        Connection connection = MySQLcon.iniciarconexao();
        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(" INSERT INTO turma (idturma, nome_turma) VALUES (?,?)");
            stmt.setInt(1, turma.getIdturma());
            stmt.setString(2, turma.getNomeTurma());
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            MySQLcon.encerrarcon(connection,stmt);
        }

    }

    public ArrayList<Turma> read() {

        Connection connection = MySQLcon.iniciarconexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Turma> turmas = new ArrayList<>();

        try {
            stmt = connection.prepareStatement(" SELECT * FROM turma");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Turma tur = new Turma();
                
                tur.setIdturma(rs.getInt("idturma"));
                tur.setNomeTurma(rs.getString("nome_turma"));
                turmas.add(tur);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return turmas;
    }

    public void update(Turma turma) {

        Connection connection = MySQLcon.iniciarconexao();
        PreparedStatement stmt = null;

        try {
            
            stmt = connection.prepareStatement(" UPDATE turma SET idturma = ?, nome_turma = ?, idade = ?, notas = ?");
            stmt.setInt(1, turma.getIdturma());
            stmt.setString(2, turma.getNomeTurma());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            MySQLcon.encerrarcon(connection,stmt);
        }
    }

    public void delete(Turma turma) {
        Connection connection = MySQLcon.iniciarconexao();
        PreparedStatement stmt = null;

        try {
            
            stmt = connection.prepareStatement("DELETE from turma WHERE idturma = ?");
            stmt.setInt(1, turma.getIdturma());
            stmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            MySQLcon.encerrarcon(connection,stmt);
        }
    }
    public void delete(int turma) {
        Connection connection = MySQLcon.iniciarconexao();
        PreparedStatement stmt = null;

        try {
            
            stmt = connection.prepareStatement("DELETE from turma WHERE idturma = ?");
            stmt.setInt(1, turma);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            MySQLcon.encerrarcon(connection,stmt);
        }
    }



}
