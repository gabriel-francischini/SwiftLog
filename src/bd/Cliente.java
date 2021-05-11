package bd;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity @Table(name="clientes")
public class Cliente {

    @Column(name="ID_cliente", unique=true)
    @Id @GeneratedValue
    public int id;

    public Cliente() {}

}
