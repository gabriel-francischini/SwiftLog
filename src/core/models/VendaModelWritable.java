package core.models;
/**
 * @author Eduardo Augusto
 * <b>Interface para Model que declara a assinatura
 * dos métodos setAtributos() da entidade Venda do BD
 * mais a obtenção do Model correspondente</b>
 */

import bd.Cliente;
import mvc.Controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import static mvc.Controller.*;

public interface VendaModelWritable{
    public abstract void setID(Chave _chave, int id);
    public abstract void setCliente(Chave _chave, Cliente cliente);
    public abstract void setQuantidade(Chave _chave, int quantidade);
    public abstract void setValor(Chave _chave, BigDecimal valor);
    public abstract void setDataVenda(Chave _chave, LocalDate dataVenda);
    public abstract void setHoraVenda(Chave _chave, LocalTime horaVenda);

    //public abstract VendaModel getModel(Chave _chave);
}
