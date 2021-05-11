package bd;

import org.hibernate.SQLQuery;

import javax.persistence.Entity;

import javax.persistence.Table;
import javax.persistence.Column;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


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

    @Column(name="preço_base")
    public BigDecimal preçoBase;

    public Mercadoria() {
    }

    public Mercadoria(String nome, String tamanho, String marca, String descrição, BigDecimal preço_base) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.marca = marca;
        this.descrição = descrição;
        this.preçoBase = preço_base;
    }

    // Método oferecido pelo Model para listar somente um objeto da entidade pelo campo "id" correspondente
    // passado no parâmetro.
    public static Optional<Mercadoria> findById(int id){
        String sql = "SELECT * FROM mercadorias WHERE ID_mercadoria = :id";

        var transaction = HibernateConfig.getSessão().beginTransaction();

        SQLQuery query = HibernateConfig.createSQLQuery(sql);

        query.addEntity(Mercadoria.class);
        query.setParameter("id", id);
        List<Mercadoria> results = query.list();
        transaction.commit();

        if(results.isEmpty()){
            return Optional.empty();
        } else {
            return Optional.of(results.get(0));
        }
    }

    // Método oferecido pelo Model para listar todos os objetos da entidade.
    public static List<Mercadoria> findAll(){
        String sql = "SELECT * FROM mercadorias";

        var transaction = HibernateConfig.getSessão().beginTransaction();

        SQLQuery query = HibernateConfig.createSQLQuery(sql);

        query.addEntity(Mercadoria.class);
        List<Mercadoria> results = query.list();
        transaction.commit();

        return results;
    }

    public static List<Mercadoria> findByNome(String nome){
        String sql = "SELECT * FROM mercadorias WHERE nome like " + nome + "%;";

        var transaction = HibernateConfig.getSessão().beginTransaction();

        SQLQuery query = HibernateConfig.createSQLQuery(sql);

        query.addEntity(Mercadoria.class);
        List<Mercadoria> results = query.list();
        transaction.commit();

        return results;
    }

    public static List<Mercadoria> findByMarca(String marca){
        String sql = "SELECT * FROM mercadorias" + marca + "%;";

        var transaction = HibernateConfig.getSessão().beginTransaction();

        SQLQuery query = HibernateConfig.createSQLQuery(sql);

        query.addEntity(Mercadoria.class);
        List<Mercadoria> results = query.list();
        transaction.commit();

        return results;
    }
}
