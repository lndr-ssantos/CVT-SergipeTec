/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Turma;

/**
 *
 * @author rodrygo.matos
 */
public class TurmaDAO {
    private Connection con = null;
    
    public void save (Turma turma){
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("insert into Turma(x, y, z)\n" + "values (?, ?, ?)");
//            stmt.setString(1, turma.getx);
//            stmt.setString(1, );
//            stmt.setString(1, ;
            
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