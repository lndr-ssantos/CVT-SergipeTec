package model.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Turma{
    private Curso curso;
    private int codCurso;
    private Professor professor;
    private String turno;
    private Date horaInicio;
    private Date horaFim;
    private int ano;
    private int semestre;
    private int totVagas;
    //totVagas - count(Alunos)
    private ArrayList<Aluno> alunos = new ArrayList();
    
    public Turma(Curso curso, Professor professor, int codCurso, String turno, Date horaInicio, Date horaFim, int ano, int semestre, int totVagas) {
        this.curso = curso;
        this.codCurso = codCurso;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.ano = ano;
        this.semestre = semestre;
        this.totVagas = totVagas;
        this.turno = turno;
        this.professor = professor;
    }
    
    public int getVagasRestantes() {
        return (totVagas)-(alunos.size());
    }
    
    public Aluno buscaCPF(String CPF){
        String CPFaux;
        for (int i = 0; i < alunos.size(); i++){
            CPFaux = alunos.get(i).getCPF();
            if (CPF.equals(CPFaux)){
                return alunos.get(i);
            }
        }
        return null;
    }
    
    /*Busca um aluno pelo nome, ou vários alunos que tenham o mesmo nome
    ex.: "Maria" retorna todas alunas que tem Maria no nome,
    mas pesquisar um nome completo, como "Antonio Carlos Pereira Santos da Costa Pinto"
    provavelmente vai retornar apenas esse aluno.*/
    //tbh, desnecessario, faz pelo DB
    public ArrayList<Aluno> buscaNome(String nome){
        String nomeAux;
        ArrayList<Aluno> arrayAux = new ArrayList();
        for(int i = 0; i < alunos.size(); i++){
            nomeAux = alunos.get(i).getNome();
            /*como contains é case sensitive, deixar todas as letras em upper case
            só pra caso digitarem tudo minusculo na busca*/
            if(nomeAux.toUpperCase().contains(nome.toUpperCase())){
                arrayAux.add(alunos.get(i));
            }
        }
        return arrayAux;
    }
    
    public void addAluno(Aluno aluno){
        if(this.getVagasRestantes() < totVagas){
            alunos.add(aluno);
            //organiza a lista de alunos alfabeticamente
            Collections.sort(alunos, Comparator.comparing(Aluno::getNome));
        }
    }
    
    public void removeAluno(Aluno aluno){
        String CPFaux;
        for(int i = 0; i < alunos.size(); i++){
            CPFaux = alunos.get(i).getCPF();
            if(aluno.getCPF().equals(CPFaux)){
                alunos.remove(i);
                Collections.sort(alunos, Comparator.comparing(Aluno::getNome));
            }
        }
    }
    
    public String getNomeCurso(){
        return curso.getNomeCurso();
    }
    
    public int getTotalAlunos(){
        return alunos.size();
    }
    
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Curso curso) {
        this.codCurso = curso.getCodCurso();
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public int getCodProf() {
        return this.professor.getCodProf();
    }

    public void setCodProf(int codProf) {
        this.professor.setCodProf(codProf);
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm aa");
        this.horaInicio = sdf.parse(time);
    }

    public Date getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String time) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm aa");
        this.horaFim = sdf.parse(time);
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        if (semestre > 0 && semestre < 3){
            this.semestre = semestre;
        } else {
            throw new IllegalArgumentException("Valor do semestre deve ser entre 1 e 2");
        }
    }

    public int getTotVagas() {
        return totVagas;
    }

    public void setTotVagas(int totVagas) {
        this.totVagas = totVagas;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }
    
    /*eu nem sei se esse método é necessário, o arraylist tem um sort(), mas vou 
    deixar ele aqui comentado just because
    */
    /*public void sortList(){
        for(int i = 0; i < alunos.size(); i++){
            if(alunos.get(i) == null){
                if(alunos.get(i+1) != null){
                    alunos.add(i, alunos.get(i++));
                    alunos.remove(i++);
                }
            }
        }
    }*/
    
}