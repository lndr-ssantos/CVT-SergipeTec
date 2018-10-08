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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Aluno;
import view.SistemaDeCadastro;
/**
 *
 * @author rodrygo.matos
 */
public class AlunoDAO {
    private Connection con = null;

    
    public void save (Aluno aluno){
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("insert into Alunos(nome, sexo, estadoNasc, cidadeNasc, dataNasc, CPF, RG, nomeMae, nomePai, telefone1, telefone2, CEP, numRes, complemento, rua, bairro, cidade, estado, dadosEscolares, dadosProfissionais, CPFResponsavel)\n" +
            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getSexo());
            stmt.setString(3, aluno.getEstadoNasc());
            stmt.setString(4, aluno.getCidadeNasc());
            stmt.setString(5, aluno.getDatNasc().toString());
            stmt.setString(6, aluno.getCPF());
            stmt.setString(7, aluno.getRG());
            stmt.setString(8, aluno.getNomeMae());
            stmt.setString(9, aluno.getNomePai());
            stmt.setString(10, aluno.getFone1());
            stmt.setString(11, aluno.getFone2());
            stmt.setString(12, aluno.getCEP());
            stmt.setString(13, Integer.toString(aluno.getNumResidencia()));
            stmt.setString(14, aluno.getComplemento());
//            stmt.setString(15, aluno.getRua());
//            stmt.setString(16, aluno.getBairro());
//            stmt.setString(17, aluno.getEstado());
//            stmt.setString(18, aluno.getCidade());
            stmt.setString(19, aluno.getDadosEscolaridade());
            stmt.setString(20, aluno.getDadosProfissionais());
            stmt.setString(21, aluno.getCPFResponsavel());
            
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    

    
    public void update (Aluno aluno){
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("update Alunos set nomeAluno = ? where cpf = ?");
            //stmt.setString(1, curso.getNovoNomeCurso());
            //stmt.setInt(2, curso.getID());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Curso atualizado com sucesso!");
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete (Aluno aluno){
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("delete from Alunos where cpf = ?");
            //stmt.setInt(2, curso.getcpf());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Curso excluído com sucesso!");
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
}
