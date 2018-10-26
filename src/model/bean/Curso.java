package model.bean;

import java.util.ArrayList;

public class Curso {
    private int codCurso;
    private String nomeCurso;
    private String nomeCursoConsulta;
    private int cargaHoraria;
    
    private ArrayList<Turma> turmas = new ArrayList();
            
    public Curso(int codCurso, String nomeCurso, ArrayList<Turma> turmas) {
        this.codCurso = codCurso;
        this.nomeCurso = nomeCurso;
    }
    
    public Curso() {
        this.codCurso = 0;
        this.nomeCurso = "";
    }

    public void cadastraTurma(Turma turma){
        turmas.add(turma);
    }
    
    public void removeTurma(Turma turma){
        turmas.remove(turma);
    }
    
    //retorna uma lista com todas as turmas do curso
    public String turmasToString(){
        String string = "";
        Turma turmaAux;
        if(!string.isEmpty()){
            for(int i = 0; i < turmas.size(); i++){
                turmaAux = turmas.get(i);
                string = Integer.toString(turmaAux.getCodCurso()) + " | " + turmaAux.getNomeCurso() + 
                    " | " + turmaAux.getTurno() + " | " + Integer.toString(turmaAux.getAno()) + "." +
                Integer.toString(turmaAux.getSemestre()) + "\n";
            }
        }else{
            string = "Não há turmas cadastradas para esse curso.";
        }
        return string;
    }
    
    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
    }
    
    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getNomeCursoConsulta() {
        return nomeCursoConsulta;
    }

    public void setNomeCursoConsulta(String nomeCursoConsulta) {
        this.nomeCursoConsulta = nomeCursoConsulta;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

}

