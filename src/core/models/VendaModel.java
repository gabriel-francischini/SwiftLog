package core.models;


import bd.Cliente;
import bd.Venda;
import mvc.Controller;
import padrõesdeprojeto.observador.Evento0Args;
import padrõesdeprojeto.observador.Listener0Args;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class VendaModel implements VendaModelWritable, VendaModelReadable{
    private Venda venda;
    private padrõesdeprojeto.observador.Evento0Args eventoValoresMudaram;

    public VendaModel(){
        this(new Venda());
    }

    // Construtor que aceita uma entidade
    public VendaModel(Venda venda){
        this.venda = venda;
        this.eventoValoresMudaram = new padrõesdeprojeto.observador.Evento0Args();
    }

//    public void quandoMudarValores()
//    public

    // Para obter o Model correspondente

    /* Getters, implementa VendaModelReadable */
    public int getId() { return this.venda.id; }
    public Cliente getCliente() { return this.venda.cliente; }
    public int getQuantidade() { return this.venda.quantidade; }
    public BigDecimal getValor() { return this.venda.valor; }
    public LocalDate getDataVenda() { return null; }
    public LocalTime getHoraVenda() { return null; }

    // Eventos, implementa VendaModelReadable
    public void quandoMudarValores(Listener0Args callback){eventoValoresMudaram.addListener(callback);}
    public void notificarMudouValores(){eventoValoresMudaram.broadcast();}

    /* Setters, implementa VendaModelWritable */
    public void setID(Controller.Chave _chave, int id) {
        this.venda.id = id;
        notificarMudouValores();
    }

    public void setCliente(Controller.Chave _chave, Cliente cliente){
        this.venda.cliente = cliente;
        notificarMudouValores();
    }

    public void setQuantidade(Controller.Chave _chave, int quantidade) {
        // Implementação mais específica. Necessário pegar a
        // quantidade de todos os itens vendidos, somar e depois setar
        // utilizando a implementação desse método.
        notificarMudouValores();
    }

    public void setValor(Controller.Chave _chave, BigDecimal valor) {
        // Implementação mais específica. Necessário pegar o
        // valor de todos os itens vendidos, somar e depois setar
        // utilizando a implementação desse método.
        notificarMudouValores();
    }

    public void setDataVenda(Controller.Chave _chave, LocalDate dataVenda){
        this.venda.dataVenda = dataVenda;
        notificarMudouValores();
    }

    public void setHoraVenda(Controller.Chave _chave, LocalTime horaVenda) {
        this.venda.horaVenda = horaVenda;
        notificarMudouValores();
    }
}
