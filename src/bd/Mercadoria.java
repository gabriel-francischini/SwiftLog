package br.com.ies.bd;

import javax.persistence.Entity;

import javax.persistence.Table;
import javax.persistence.Column;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Entity @Table(name="mercadorias")
public class Mercadoria {

    @Column(name="ID_mercadoria", unique=true)
    @Id @GeneratedValue
    public int id;

    @Column(name="nome")
    public String nome;

    @Column(name="tamanho")
    public String tamanho;

    @Column(name="marca")
    public String marca;

    @Column(name="descricao")
    public String descrição;
}
