/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Curso;

/**
 *
 * @author rodrygo.matos
 */

// Data Access Object (Objeto de acesso a dados)
public class CursoDAO {
    private Connection con = null;
    
    public void save (Curso curso){
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("insert into Cursos(nomeCurso, cargaHoraria)\n" + 
                    "values (?, ?)");
            stmt.setString(1, curso.getNomeCurso());
            stmt.setInt(2, curso.getCargaHoraria());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso!");
        } catch (SQLException ex) {
            System.err.println("Erro ao cadastrar o curso: "+ex);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o curso: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void update (Curso curso){
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("update Cursos set nomeCurso = ? where id = ?");
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
    
    public void delete (Curso curso){
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("delete from Cursos where id = ?");
            //stmt.setInt(2, curso.getID());
            //primeiro executa um delete cascade em Turmas?
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Curso excluído com sucesso!");
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
   
    public List<Curso> show(String nomeConsulta){
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Curso> cursosConsulta = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement("Select * from Cursos where nomeCurso like ?");
            stmt.setString(1, "%" + nomeConsulta + "%");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                
                Curso curso = new Curso();
                curso.setCodCurso(rs.getInt("codCurso"));
                curso.setNomeCurso(rs.getString("nomeCurso"));
                cursosConsulta.add(curso);
            }
            
            
        }catch (SQLException ex){
            System.err.println("Erro ao consultar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return cursosConsulta;
    }
    
    public List<Curso> read(){
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Curso> cursos = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement("Select * from Curso");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                
                Curso curso = new Curso();
                curso.setCodCurso(rs.getInt("codCurso"));
                curso.setNomeCurso(rs.getString("nomeCurso"));
                cursos.add(curso);
            }
            
            
        }catch (SQLException ex){
            System.err.println("Erro ao consultar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return cursos;
    }
}
