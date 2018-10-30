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
import model.bean.Responsavel;

/**
 *
 * @author rodrygo.matos
 */
public class ResponsavelDAO {

    private Connection con = null;

    public void save(Responsavel responsavel) {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("insert into Responsaveis(nome, CPF, RG)\n" + "values (?, ?, ?)");
            stmt.setString(1, responsavel.getNome());
            stmt.setString(2, responsavel.getCPF());
            stmt.setString(3, responsavel.getRG());
            if(responsavel.getCPF() != null){
               stmt.executeUpdate(); 
               JOptionPane.showMessageDialog(null, "Responsavel cadastrado com sucesso!");
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro ao cadastrar o responsavel: " + ex);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar responsavel: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

//    public void update(Responsavel responsavel) {
//        con = ConnectionFactory.getConnection();
//        PreparedStatement stmt = null;
//        try {
//            stmt = con.prepareStatement("update Responsavel set nomeResponsavel = ? where cpf = ?");
//            //stmt.setString(1, curso.getNovoNomeCurso());
//            //stmt.setInt(2, curso.getID());
//            stmt.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Responsavel atualizado com sucesso!");
//        } catch (SQLException ex) {
//            System.err.println("Erro ao atualizar: " + ex);
//        } finally {
//            ConnectionFactory.closeConnection(con, stmt);
//        }
//    }
//
//    public void delete(Responsavel responsavel) {
//        con = ConnectionFactory.getConnection();
//        PreparedStatement stmt = null;
//        try {
//            stmt = con.prepareStatement("delete from Responsavel where cpf = ?");
//            //stmt.setInt(2, curso.getID());
//            stmt.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Responsavel excluído com sucesso!");
//        } catch (SQLException ex) {
//            System.err.println("Erro ao excluir: " + ex);
//        } finally {
//            ConnectionFactory.closeConnection(con, stmt);
//        }
//    }
}
