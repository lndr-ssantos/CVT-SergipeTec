package model.bean;

import java.awt.image.BufferedImage;
import java.time.LocalDate;

public abstract class Pessoa {
    private String nome;
    private String sexo; //M, F, O
    private String CPF;
    private String RG; 
    private String RGUF;
    private String CEP;
    private String fone1;//obrigatório
    private String fone2;
    private String cidadeNasc;
    private String estadoNasc;
    private LocalDate datNasc;
    private int numResidencia;
    private String estado, cidade, bairro, rua;
    private String complemento;
    private BufferedImage foto;
    
    //Vazio
    public Pessoa(){
        
    }
    
    //Aluno
    public Pessoa(String nome, String sexo, String CPF, String RG, String CEP, String fone1, String cidadeNasc, String estadoNasc, LocalDate datNasc, int numResidencia, String complemento) {
        this.nome = nome;
        this.sexo = sexo;
        this.CPF = CPF;
        this.RG = RG;
        this.CEP = CEP;
        this.fone1 = fone1;
        this.cidadeNasc = cidadeNasc;
        this.estadoNasc = estadoNasc;
        this.datNasc = datNasc;
        this.numResidencia = numResidencia;
        this.complemento = complemento;
    }
    
    //Professor
    public Pessoa(String nome, String sexo, String CPF, String RG, LocalDate datNasc) {
        this.nome = nome;
        this.sexo = sexo;
        this.CPF = CPF;
        this.RG = RG;
        this.datNasc = datNasc;
    }
    
    //Responsavel
    public Pessoa(String nome, String CPF, String RG){
        this.nome = nome;
        this.CPF = CPF;
        this.RG = RG;
    }
    
    public long getIdade(){
        LocalDate now = LocalDate.now();
        long idade = java.time.temporal.ChronoUnit.YEARS.between(datNasc, now);
        return idade;
    }
    
    public boolean isMenor(){
        //pega a data atual
        LocalDate now = LocalDate.now();
        //checa os anos entre datNasc e now
        long idade = java.time.temporal.ChronoUnit.YEARS.between(datNasc, now);
        int i = (int) idade;
        
        return i < 18;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getRGUF() {
        return RGUF;
    }

    public void setRGUF(String RGUF) {
        this.RGUF = RGUF;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getFone1() {
        return fone1;
    }

    public void setFone1(String fone1) {
        this.fone1 = fone1;
    }

    public String getFone2() {
        return fone2;
    }

    public void setFone2(String fone2) {
        this.fone2 = fone2;
    }

    public String getCidadeNasc() {
        return cidadeNasc;
    }

    public void setCidadeNasc(String cidadeNasc) {
        this.cidadeNasc = cidadeNasc;
    }

    public String getEstadoNasc() {
        return estadoNasc;
    }

    public void setEstadoNasc(String estadoNasc) {
        this.estadoNasc = estadoNasc;
    }

    public LocalDate getDatNasc() {
        return datNasc;
    }

    public void setDatNasc(String datNasc) {
        //formata a String DD/MM/YYYY para um LocalDate
        java.time.format.DateTimeFormatter formatter = 
                java.time.format.DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate localDate = LocalDate.parse(datNasc, formatter);
        this.datNasc = localDate;
    }

    public int getNumResidencia() {
        return numResidencia;
    }

    public void setNumResidencia(int numResidencia) {
        this.numResidencia = numResidencia;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public BufferedImage getFoto() {
        return foto;
    }

    public void setFoto(BufferedImage foto) {
        this.foto = foto;
    }
    
    //DEPRECATED
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String CEP){
        this.CEP = CEP;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro){
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua){
        this.rua = rua;
    }
}
