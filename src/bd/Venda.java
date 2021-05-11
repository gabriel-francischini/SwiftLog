package bd;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity @Table(name="venda")
public class Venda {
    
    @Column(name="ID_venda", unique=true)
    @Id @GeneratedValue
    public int id;

    @OneToOne(cascade= CascadeType.ALL)

    /*
    * @JoinColumn representa a coluna referenciada
    * por outra classe (tabela, para o Hibernate.
    */
    @JoinColumn(name="ID_cliente")
    public Cliente cliente;
    
    @Column(name="quantidade", unique=true)
    public int quantidade;

    @Column(name="valor", unique=true)
    public BigDecimal valor;

    /*
    * @Basic indica que é um campo de dados básico, e é mapeado
    * diretamente para um atributo SQL. 
    * Fonte: https://www.baeldung.com/hibernate-date-time
    */
    @Basic
    public LocalDate dataVenda;

    @Basic
    public LocalTime horaVenda;

    public Venda() {

    }

    public Venda(Cliente cliente, int quantidade, BigDecimal valor, LocalDate dataVenda, LocalTime horaVenda) {
        this.cliente = cliente;
        this.quantidade = quantidade;
        this.valor = valor;
        this.dataVenda = dataVenda;
        this.horaVenda = horaVenda;
    }
}

// link: https://www.baeldung.com/hibernate-date-time
// link: https://www.baeldung.com/jpa-one-to-one
// link: https://stackoverflow.com/questions/15426736/how-can-i-mark-a-foreign-key-constraint-using-hibernate-annotations

