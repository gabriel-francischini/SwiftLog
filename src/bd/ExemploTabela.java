package br.com.ies.bd;

// @Entity marca uma classe que deve corresponder a uma tabela do banco de dados.
// Não se esqueça de adicionar cada @Entity no arquivo src/resources/hibernate.cfg.xml .
import javax.persistence.Entity;

// @Table é para caso queiramos dar um nome específico para a tabela correspondente no banco de dados.
import javax.persistence.Table;

// Qualquer propriedade que não é marcada com @Transient é assumida que corresponde a uma coluna no
// banco de dados. @Column nos permite especificar em detalhes extras as características de cada coluna
// (lembrando que cada coluna corresponde a um atributo).
import javax.persistence.Column;
import javax.persistence.Transient;

// Use ambos @Id e @GeneratedValue para marcar uma primary key.
// @GeneratedValue na verdade significa AutoIncrement, mas isso é necessário numa primary key.
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


// Não se esqueça de adicionar cada @Entity no arquivo src/resources/hibernate.cfg.xml .
// Essa classe vai aparecer como br.com.ies.bd.ExemploTabela nesse arquivo por conta do package declarado na linha 1.
@Entity

// Por default, o nome da tabela seria igual o nome da classe. Mas é bom substituir o nome no BD pelo nome que consta
// nos nossos documentos de modelo de banco de dados.
@Table(name = "TabelaDeExemplo")
public class ExemploTabela {


    // Similar ao nome da tabela, sempre é com renomear as colunas para um nome que bata com os nossos modelos de dados.
    @Column(name = "USER_ID")
    // @Id @GeneratedValue é o mesmo que PRIMARY KEY e AUTOINCREMENT
    @Id @GeneratedValue
    private int id;

    //@Column(name = "Campo_Numero_1")
    //private String primeiroCampo;

    private String firstName;
    private String lastName;

    private int age;

    public ExemploTabela(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
