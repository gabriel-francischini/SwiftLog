package bd;

import org.hibernate.SQLQuery;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Entity @Table(name="item_estocado")
public class ItemEstocado {

    @Id @Column(name="ID_item_estocado")
    @GeneratedValue
    public int id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="ID_Mercadoria")
    public Mercadoria mercadoria;


    // https://www.baeldung.com/jpa-one-to-one
    // https://www.baeldung.com/jpa-join-column
    // https://docs.jboss.org/hibernate/jpa/2.1/api/javax/persistence/JoinTable.html
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_Lote")
    public Lote lote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_Local")
    public Local local;


    public int quantidade;

    public ItemEstocado() {
    }

    public ItemEstocado(Mercadoria mercadoria, Lote lote, Local local, int quantidade) {
        this.mercadoria = mercadoria;
        this.lote = lote;
        this.local = local;
        this.quantidade = quantidade;
    }

    public static List<ItemEstocado> findAll(){
        String sql = "SELECT * FROM item_estocado";

        var transaction = HibernateConfig.getSessão().beginTransaction();

        SQLQuery query = HibernateConfig.createSQLQuery(sql);

        query.addEntity(ItemEstocado.class);
        List<ItemEstocado> results = query.list();
        transaction.commit();

        return results;
    }

    public static Optional<ItemEstocado> findById(int id){
        String sql = "SELECT * FROM item_estocado WHERE item_estocado = :id";

        var transaction = HibernateConfig.getSessão().beginTransaction();

        SQLQuery query = HibernateConfig.createSQLQuery(sql);

        query.addEntity(ItemEstocado.class);
        query.setParameter("id", id);
        List<ItemEstocado> results = query.list();
        transaction.commit();

        if(results.isEmpty()){
            return Optional.empty();
        } else {
            return Optional.of(results.get(0));
        }
    }

    public static List<ItemEstocado> findByNome(String nome){
        String sql = "SELECT * FROM item_estocado INNER JOIN mercadorias on mercadorias.nome = " + nome + "%;";

        var transaction = HibernateConfig.getSessão().beginTransaction();

        SQLQuery query = HibernateConfig.createSQLQuery(sql);

        query.addEntity(ItemEstocado.class);
        List<ItemEstocado> results = query.list();
        transaction.commit();

        return results;
    }
}