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
import model.bean.Aluno;
import model.bean.Turma;

/**
 *
 * @author rodrygo.matos
 */
public class MatriculaDAO {

    private Connection con = null;

    public void save(String Aluno_CPF, int Turmas_codTurma) {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;
        try {

            stmt3 = con.prepareStatement("Select * from Turmas where codTurma is \n"
                    + "values (Turmas_codTurma)");

            stmt2 = con.prepareStatement("Select * from Alunos where cpf is \n"
                    + "values (Aluno_CPF)");

            stmt = con.prepareStatement("insert into Matricula(Alunos_CPF, Turmas_codTurma)\n"
                    + "values (?, ?)");
            stmt.setString(1, Aluno_CPF);
            stmt.setInt(2, Turmas_codTurma);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Aluno cadastrado na turma com sucesso!");

        } catch (SQLException ex) {
            boolean erro = true;
            System.err.println("Erro ao cadastrar aluno na turma: " + ex);
            if (ex.toString().equals("java.sql.SQLIntegrityConstraintViolationException: Cannot add or update a child row: a foreign key constraint fails (`cvt`.`Matricula`, CONSTRAINT `fk_Alunos_has_Turmas_Alunos1` FOREIGN KEY (`Alunos_CPF`) REFERENCES `Alunos` (`cpf`))")) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno na turma: CPF inválido");
                erro = false;
            }
            if (ex.toString().equals("java.sql.SQLIntegrityConstraintViolationException: Cannot add or update a child row: a foreign key constraint fails (`cvt`.`Matricula`, CONSTRAINT `fk_Alunos_has_Turmas_Turmas1` FOREIGN KEY (`Turmas_codTurma`) REFERENCES `Turmas` (`codTurma`))")) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno na turma: Código da turma inválida");
                erro = false;
            }
            if (erro == true) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno na turma: " + ex);
            }

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
            ConnectionFactory.closeConnection(con, stmt2);
            ConnectionFactory.closeConnection(con, stmt3);
        }
    }
}
