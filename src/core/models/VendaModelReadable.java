package core.models;

import bd.Cliente;
import bd.Venda;
import mvc.Controller;
import padrõesdeprojeto.observador.Listener0Args;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Eduardo Augusto
 * <b>Interface para Model que declara a assinatura
 * dos métodos getAtributos() da entidade Venda do BD</b>
 */
public interface VendaModelReadable{
    public abstract int getId();
    public abstract Cliente getCliente();
    public abstract int getQuantidade();
    public abstract BigDecimal getValor();
    public abstract LocalDate getDataVenda();
    public abstract LocalTime getHoraVenda();
    public void quandoMudarValores(Listener0Args callback);
    public void notificarMudouValores();
}
