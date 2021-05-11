package core.models;

import bd.ItemEstocado;
import bd.Lote;
import bd.Mercadoria;
import mvc.Controller;
import padrõesdeprojeto.observador.Evento0Args;
import padrõesdeprojeto.observador.Listener0Args;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ItemEstocadoModel implements ItemEstocadoModelWritable, ItemEstocadoModelReadable{
    private ItemEstocado itemEstocado;
    private Evento0Args eventoValoresMudaram;

    // Getters
    public int getId() {return itemEstocado.id;}
    public int getQuantidade() {return itemEstocado.quantidade;}
    // public ItemEstocadoModel getModel(){ return itemEstocado; }
    public MercadoriaModel getMercadoria(){return new MercadoriaModel(itemEstocado.mercadoria);}
    public LoteModel getLote(){return new LoteModel(itemEstocado.lote);}
    public ItemEstocado getDBEntity(){return itemEstocado;}

    // Setters
    private void setId(int id){
        this.itemEstocado.id = id;
        notificarMudouValores();
    }
    private void setQuantidade(int quantidade){
        this.itemEstocado.quantidade = quantidade;
        notificarMudouValores();
    }
    private void setMercadoria(MercadoriaModel mercadoria){
        this.itemEstocado.mercadoria = mercadoria.getDBEntity();
        notificarMudouValores();
    }
    private void setLote(LoteModel lote){
        this.itemEstocado.lote = lote.getDBEntity();
        notificarMudouValores();
    }

    // Eventos
    public void quandoMudarValores(Listener0Args callback){eventoValoresMudaram.addListener(callback);}
    public void notificarMudouValores(){eventoValoresMudaram.broadcast();}

    // Implementa ItemEstocadoModelReadable
    public MercadoriaModelReadable getMercadoriaReadable(){return getMercadoria();}
    public LoteModelReadable getLoteReadable(){return getLote();}

    // Implementa ItemEstocadoModelWritable
    public void setId(Controller.Chave _chave, int id){setId(id);}
    public void setQuantidade(Controller.Chave _chave, int quantidade){setQuantidade(quantidade);}
    public void setMercadoria(Controller.Chave _chave, MercadoriaModelWritable mercadoria){
        setMercadoria(mercadoria.getModel());
    }
    public void setLote(Controller.Chave _chave, LoteModelWritable lote){
        setLote(lote.getModel(_chave));
    }

    // Construtores
    public ItemEstocadoModel(ItemEstocado itemEstocado) {
        System.out.println("Criando Item Estocado Model");
        this.itemEstocado = itemEstocado;
        this.eventoValoresMudaram = new Evento0Args();
    }

    public ItemEstocadoModel() {
        this(new ItemEstocado());
    }

    public static List<? extends ItemEstocadoModel> findAll(){
        List<bd.ItemEstocado> itens_no_bd = ItemEstocado.findAll();
        List<ItemEstocadoModel> resultado = itens_no_bd.stream().map(ItemEstocadoModel::new).collect(Collectors.toList());
        return resultado;
    }

    public static Optional<ItemEstocadoModel> findByID(int id){
        Optional<ItemEstocado> itemEstocado = ItemEstocado.findById(id);

        if (itemEstocado.isPresent()){
            return Optional.of(new ItemEstocadoModel(itemEstocado.get()));
        } else{
            return Optional.empty();
        }
    }
}
