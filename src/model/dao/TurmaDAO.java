package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import model.bean.Turma;

/**
 *
 * @author rodrygo.matos
 */
public class TurmaDAO {
    
    private Connection con = null;
    private Calendar cal = Calendar.getInstance();
    
    public void save (Turma turma){
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("insert into Turmas(Cursos_codCurso, dias, horaInicio, horaFim, totVagas, Professor_codProf, ano, semestre)\n" + 
            "values (?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, turma.getCodCurso());
            stmt.setString(2, turma.getDiasString());
            //stmt.setDate(3, Date.valueOf(turma.getHoraInicioString()));
            stmt.setString(3, turma.getHoraInicioString());
            stmt.setString(4, turma.getHoraFimString());
            stmt.setInt(5, turma.getTotVagas());
            stmt.setInt(6, turma.getCodProf());
            stmt.setInt(7, cal.get(Calendar.YEAR));
            if((cal.get(Calendar.MONTH) + 1) < 7){
                stmt.setInt(8, 1);
            } else {
                stmt.setInt(8, 2);
            }
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Turma cadastrada com sucesso!");
            
        } catch (SQLException ex) {
            System.err.println("Erro ao cadastrar a turma: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void update (Turma turma){
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("update Turma set nomeTurma = ? where codTurma = ?");
            //stmt.setString(1, curso.getNovoNomeCurso());
            //stmt.setInt(2, curso.getID());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Turma atualizada com sucesso!");
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete (Turma turma){
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("delete from Turma where codTurma = ?");
            //stmt.setInt(2, curso.getID());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Turma excluída com sucesso!");
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}