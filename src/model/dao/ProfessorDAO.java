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
    
    public void save (Professor professor){
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("insert into Professor(nome, CPF, RG, sexo, fone1, dataNasc, CEP, numResidencia, complemento, codProf)\n" +
            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getCPF());
            stmt.setString(3, professor.getRG());
            stmt.setString(4, professor.getSexo());
            stmt.setString(5, professor.getFone1());
            stmt.setString(6, professor.getDatNasc().toString());
            stmt.setString(7, professor.getCEP());
            stmt.setInt(8, professor.getNumResidencia());
            stmt.setString(9, professor.getComplemento());
            stmt.setString(10, Integer.toString(professor.getCodProf()));
            
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
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
