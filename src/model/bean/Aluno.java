package model.bean;

//imports para datas
import java.time.LocalDate; 
//imports para imagem
import java.awt.image.BufferedImage;
import java.util.ArrayList;//prob tirar depois

//holy moly esse classe é grande
public class Aluno extends Pessoa{
    private Responsavel responsavel;
    private Curso curso;
    private String nomePai;
    private String nomeMae;
    private int matricula;
    /*os dados do responsável só são necessário se o aluno for menor de idade*/
    private String dadosEscolaridade;
    private String dadosProfissionais;
    

    
    //busca todas as turmas em que o aluno está cadastrado
    public ArrayList<Turma> buscaTurmas(){
        ArrayList<Turma> aux = new ArrayList();
        //TODO
        return aux;
    }
    
    //instanciando a classe
<<<<<<< HEAD
    public Aluno() {
=======
    
    public Aluno(){
        //construtor vazio por causa da linha 6696 do SistemaDeCadastro.java
    }
    
    public Aluno(){
        //construtor vazio por causa da linha 6696 do SistemaDeCadastro.java
    }
    
    public Aluno(){
        //construtor vazio por causa da linha 6696 do SistemaDeCadastro.java
    }
    
    public Aluno(String cpf){
        super();
        super.setCPF(cpf);
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
>>>>>>> 98fc059b058ca4da4debd98724b84b819be0aef5
=======
>>>>>>> 98fc059b058ca4da4debd98724b84b819be0aef5
>>>>>>> Stashed changes
    }
    
    public Aluno(String nome, String sexo, String CPF, String RG, String CEP, String fone1, 
            String cidadeNasc, String estadoNasc, LocalDate datNasc, int numResidencia, String complemento,
            Responsavel responsavel, int matricula, String nomePai, 
            String nomeMae, String dadosEscolaridade, String dadosProfissionais, Curso curso) {
        super(nome, sexo, CPF, RG, CEP, fone1, cidadeNasc, estadoNasc, datNasc, numResidencia, complemento);
        this.responsavel = responsavel;
        this.matricula = matricula;
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        //dados de escolaridade
        //dados profissionais
        this.dadosEscolaridade = dadosEscolaridade;
        this.dadosProfissionais = dadosProfissionais;  
        this.curso = curso;
    }

    /*Gets e Sets do Aluno*/
    
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getDadosEscolaridade() {
        return dadosEscolaridade;
    }

    public void setDadosEscolaridade(String dadosEscolaridade) {
        this.dadosEscolaridade = dadosEscolaridade;
    }

    public String getDadosProfissionais() {
        return dadosProfissionais;
    }

    public void setDadosProfissionais(String dadosProfissionais) {
        this.dadosProfissionais = dadosProfissionais;
    }
    /*Termina Gets e Sets do Aluno*/
    
    /*começa gets e sets dos responsaveis*/
    public void setResponsavel(Responsavel responsavel){
        this.responsavel = responsavel;
    }
    
    public Responsavel getResponsavel(){
        return responsavel;
    }
    
    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }
    
    public String getNomePai(){
        return nomePai;
    }
    
    public String getNomeMae(){
        return nomeMae;
    }
    
    public String getCPFResponsavel(){
        String CPFResponsavel = responsavel.getCPF();
        return CPFResponsavel;
    }

    public void setCPFResp(String CPF){
        this.responsavel.setCPF(CPF);
    }
}