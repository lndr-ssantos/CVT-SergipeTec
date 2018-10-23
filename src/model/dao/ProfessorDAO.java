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
import model.bean.Professor;
/**
 *
 * @author victor.gomes
 */
public class ProfessorDAO {
    
    private Connection con = null;
    
    public boolean save (Professor professor){
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("insert into Professores(nome, CPF, RG, RGUF, sexo, fone1, fone2, dataNasc, CEP, numResidencia, complemento)\n" +
            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getCPF());
            stmt.setString(3, professor.getRG());
            stmt.setString(4, professor.getRGUF());
            stmt.setString(5, professor.getSexo());
            stmt.setString(6, professor.getFone1());
            if(!professor.getFone2().isEmpty()){
                stmt.setString(7, professor.getFone2());
            }
            stmt.setString(8, professor.getDatNasc().toString());
            stmt.setString(9, professor.getCEP());
            stmt.setInt(10, professor.getNumResidencia());
            stmt.setString(11, professor.getComplemento());
            
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
            return true;
        }
    }
    

    
    public void update (Professor professor){
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("update Professor set nomeProf = ? where codProf = ?");
            //stmt.setString(1, curso.getNovoNomeCurso());
            //stmt.setInt(2, curso.getID());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Professor atualizado com sucesso!");
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete (Professor professor){
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("delete from Professor where codProf = ?");
            //stmt.setInt(2, curso.getcpf());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Professor excluído com sucesso!");
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
