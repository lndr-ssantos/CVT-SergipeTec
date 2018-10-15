package model.bean;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.time.LocalDate;
import java.util.Locale;

public class Turma{
    private Curso curso;
    private int codCurso;
    private Professor professor;
    private String turno;
    private LocalDate horaInicio1;
    private LocalDate horaFim1;
    private LocalDate horaInicio2;
    private LocalDate horaFim2;
    private int ano;
    private int semestre;
    private int totVagas;
    //totVagas - count(Alunos)
    private ArrayList<Aluno> alunos = new ArrayList();
    private ArrayList<String> dias = new ArrayList(2);
    
    public Turma(){
        
    }
    
    public Turma(Curso curso, Professor professor, int codCurso, String turno, 
            LocalDate horaInicio, LocalDate horaFim, LocalDate horaInicio2, LocalDate horaFim2, 
            int ano, int semestre, int totVagas, ArrayList<String> dias) {
        this.curso = curso;
        this.codCurso = codCurso;
        this.horaInicio1 = horaInicio;
        this.horaFim1 = horaFim;
        this.horaInicio2 = horaInicio2;
        this.horaFim2 = horaFim2;
        this.ano = ano;
        this.semestre = semestre;
        this.totVagas = totVagas;
        this.turno = turno;
        this.professor = professor;
        this.dias = dias;
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

    public LocalDate getHoraInicio1() {
        return horaInicio1;
    }

    public void setHoraInicio1(String time) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        formatter = formatter.withLocale( Locale.ROOT );  
        // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        horaInicio1 = LocalDate.parse(time, formatter);
    }

    public LocalDate getHoraFim1() {
        return horaFim1;
    }

    public void setHoraFim1(String time) throws ParseException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        formatter = formatter.withLocale( Locale.ROOT );  
        // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        horaFim1 = LocalDate.parse(time, formatter);
    }

    public LocalDate getHoraInicio2() {
        return horaInicio2;
    }

    public void setHoraInicio2(String time) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        formatter = formatter.withLocale( Locale.ROOT );  
        // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        horaInicio2 = LocalDate.parse(time, formatter);
    }

    public LocalDate getHoraFim2() {
        return horaFim2;
    }

    public void setHoraFim2(String time) throws ParseException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        formatter = formatter.withLocale( Locale.ROOT );  
        // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        horaFim2 = LocalDate.parse(time, formatter);
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

    public String getDias(int i) {
        return dias.get(i);
    }

    public void setDias(ArrayList<String> dias) {
        this.dias = dias;
    }

    public void addDia(String dia) {
        if(dias.size() < 2){
            this.dias.add(dia);
        } else {
            
        }
    }
    
    public void removeDias(int int_){
        this.dias.remove(int_);
    }
    
}