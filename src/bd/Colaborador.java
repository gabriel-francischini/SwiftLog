package bd;

import javax.persistence.Entity;

import javax.persistence.Table;
import javax.persistence.Column;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Entity @Table(name="colaborador")
class Colaborador {

    @Column(name="ID_colaborador", unique=true)
    @Id @GeneratedValue
    public int id;

    @Column(name="nome_colaborador", length=45)
    public String nome;

    @Column public int CPF;
    @Column public int CEP;
}