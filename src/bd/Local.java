package bd;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity @Table(name="local")
public class Local {
    
    @Column(name="ID_Local", unique=true)
    @Id @GeneratedValue
    public int id;

    @Column(name="CEP")
    public int cep;
    
    @Column(name="Capacidade")
    public BigDecimal capacidade;
    
    @Column(name="Setor")
    public String setor;

    public Local() {
    }

    public Local(int cep, BigDecimal capacidade, String setor) {
        this.cep = cep;
        this.capacidade = capacidade;
        this.setor = setor;
    }
}