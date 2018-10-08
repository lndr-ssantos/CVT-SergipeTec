package model.bean;

import java.time.LocalDate;

public class Professor extends Pessoa{
    
    private int codProf;

    public Professor(String nome, String sexo, String CPF, String RG, LocalDate datNasc, int codProf) {
        super(nome, sexo, CPF, RG, datNasc);
        this.codProf = codProf;
    }

    public int getCodProf() {
        return codProf;
    }

    public void setCodProf(int codProf) {
        this.codProf = codProf;
    }
    
    
}
