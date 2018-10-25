package model.bean;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.time.LocalTime;
import java.util.Locale;

public class Turma{
    private Curso curso;
    private int codCurso;
    private Professor professor;
    private String turno;
    
    private int ano;
    private int semestre;
    private int totVagas;
    //totVagas - count(Alunos)
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private ArrayList<String> dias = new ArrayList<>(6);
    private ArrayList<LocalTime> horaInicio = new ArrayList<>();
    private ArrayList<LocalTime> horaFim = new ArrayList<>();
    
    public Turma(){
        
    }
    
    public Turma(Curso curso, Professor professor, int codCurso, String turno, 
            ArrayList<LocalTime> horaInicio, ArrayList<LocalTime> horaFim,
            int ano, int semestre, int totVagas, ArrayList<String> dias) {
        this.curso = curso;
        this.codCurso = codCurso;
        this.horaInicio = horaInicio;
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

    public ArrayList<LocalTime> getHoraInicioArray() {
        return horaInicio;
    }
    
    public LocalTime getHoraInicio(int i){
        return horaInicio.get(i);
    }

    public String getHoraInicioString(){
        String aux = "";
        for(int i = 0; i < horaInicio.size(); i++){
            aux = aux + horaInicio.get(i) + ", ";
        }
        return aux;
    }
    
    public void setHoraInicio(String time) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        formatter = formatter.withLocale( Locale.ROOT );  
        // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        horaInicio.add(LocalTime.parse(time, formatter));
        
        
    }

    public ArrayList<LocalTime> getHoraFimArray() {
        return horaFim;
    }
    
    public LocalTime getHoraFim(int i){
        return horaFim.get(i);
    }
    
    public String getHoraFimString(){
        String aux = "";
        for(int i = 0; i < horaFim.size(); i++){
            aux = aux + horaFim.get(i) + ", ";
        }
        return aux;
    }

    public void setHoraFim(String time) throws ParseException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
        formatter = formatter.withLocale( Locale.ROOT );  
        // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        horaFim.add(LocalTime.parse(time, formatter));
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

    public ArrayList<String> getDias(){
        return dias;
    }
    
    public String getDiasString(){
        String aux = "";
        for(int i = 0; i < dias.size(); i++){
            aux = aux + dias.get(i) + ", ";
        }
        return aux;
    }
    
    public String getDia(int i) {
        return dias.get(i);
    }

    public void setDias(ArrayList<String> dias) {
        this.dias = dias;
    }

    public void addDia(String dia) {
        if(dias.size() < 6){
            if(!dias.contains(dia)){
                this.dias.add(dia);
            } else {
                //dia ja adicionado
            }
        } else {
            //mais dias cadastrados do que o permitido
        }
    }
    
    public void removeDias(int int_){
        this.dias.remove(int_);
    }
    
    public String getHorario(){
        String aux = "";
        for(int i = 0; i < dias.size(); i++){
            if(dias.get(i) != null && horaInicio.get(i) != null && horaFim != null){
                aux = aux + dias.get(i) + ":\n" +
                    "-> Início: " + horaInicio.get(i) + "\n" +
                    "-> Fim: " + horaFim.get(i) + "\n\n";
            }
        }
        return aux;
    }
    
    
}