package bd;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity @Table(name="item_vendido")
public class ItemVendido {

    @Column(name="ID_item_vendido", unique=true)
    @Id @GeneratedValue
    public int id;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="ID_item_estocado")
    public ItemEstocado itemEstocado;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="ID_venda")
    public Venda venda;
    
    @Column(name="quantidade", unique=true)
    public int quantidade;

    @Column(name="preço", unique=true)
    public BigDecimal preco;

    public ItemVendido() {
    }

    public ItemVendido(ItemEstocado itemEstocado, Venda venda, int quantidade, BigDecimal preco) {
        this.itemEstocado = itemEstocado;
        this.venda = venda;
        this.quantidade = quantidade;
        this.preco = preco;
    }
}
