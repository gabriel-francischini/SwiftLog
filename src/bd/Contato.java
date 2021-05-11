package bd;

import javax.persistence.Entity;

import javax.persistence.Table;
import javax.persistence.Column;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Entity @Table(name="contato")
class Contato {

    @Column(name="ID_contato", unique=true)
    @Id @GeneratedValue
    public int id;

    @Column(name="telefone")
    public int telefone;

    public Contato() {
    }

    public Contato(int telefone) {
        this.telefone = telefone;
    }
}
