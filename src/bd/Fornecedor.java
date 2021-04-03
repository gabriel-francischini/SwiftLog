package br.com.ies.bd;

import javax.persistence.Entity;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Transient;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.math.BigDecimal;


@Entity @Table(name="fornecedores")
class Fornecedor {

    @Column(name="ID_fornecedor", unique=true)
    @Id @GeneratedValue
    public int id;

    @Column(name="CNPJ", length=45)
    public String nome;

    @Column public int CPF;
    @Column public int CEP;
}