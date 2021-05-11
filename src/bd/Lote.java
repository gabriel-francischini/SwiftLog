package bd;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity @Table(name="lote")
public class Lote {
    
    @Column(name="ID_Lote", unique=true)
    @Id @GeneratedValue
    public int id;
    /**
        Falsificar a implementação do recebimento
     */
    // public String recebimento;
    @Column(name="Data_Fabricacao")
    public LocalDate dataFabricacao;

    @Column(name="Data_Vencimento")
    public LocalDate dataVencimento;

    public Lote() {
    }

    public Lote(LocalDate dataFabricacao, LocalDate dataVencimento) {
        this.dataFabricacao = dataFabricacao;
        this.dataVencimento = dataVencimento;
    }
}