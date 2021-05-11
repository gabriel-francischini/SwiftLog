package core.models;

import java.math.BigDecimal;

import mvc.Controller;
import padrõesdeprojeto.observador.Listener0Args;

public interface MercadoriaModelWritable{
    public abstract void setId(Controller.Chave _chave, int id);
    public abstract void setNome(Controller.Chave _chave, String nome);
    public abstract void setTamanho(Controller.Chave _chave, String tamanho);
    public abstract void setMarca(Controller.Chave _chave, String marca);
    public abstract void setDescrição(Controller.Chave _chave, String descrição);
    public abstract void setPreçoBase(Controller.Chave _chave, BigDecimal preço_base);
    public abstract MercadoriaModel getModel();
}
