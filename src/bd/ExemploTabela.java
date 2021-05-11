package bd;

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
import java.math.BigDecimal;


// Não se esqueça de adicionar cada @Entity no arquivo src/resources/hibernate.cfg.xml .
// Essa classe vai aparecer como bd.ExemploTabela nesse arquivo por conta do package declarado na linha 1.
@Entity

// Por default, o nome da tabela seria igual o nome da classe. Mas é bom substituir o nome no BD pelo nome que consta
// nos nossos documentos de modelo de banco de dados.
@Table(name = "TabelaDeExemplo")
public class ExemploTabela {


    // Similar ao nome da tabela, sempre é com renomear as colunas para um nome que bata com os nossos modelos de dados.
    // @Id @GeneratedValue é o mesmo que PRIMARY KEY e AUTOINCREMENT.
    @Column(name = "USER_ID")
    @Id @GeneratedValue
    private int id;


    @Column(name = "Campo_Numero_1")
    private String primeiroCampo;

    // Por default, todos os campos são nuláveis, então é importante especificar quando uma coluna não é nulável.
    // veja outras opções para cada coluna aqui: https://www.objectdb.com/api/java/jpa/Column
    @Column(nullable = false)
    private String campoNãoNulável;
    private String campoNulável;

    // Um campo que é transiente não vai aparecer como uma coluna no banco de dados.
    @Transient private int nãoApareceNoBD;

    @Column(name = "Só_Aparece_Uma_vez", unique = true)
    private int campoÚnico;

    // Esse é um número com 10 casas, das quais 5 ficam após a vírgula.
    // Ele não tem erros de arredondamento. Equivale ao DECIMAL do MySQL ou o BigDecimal do Java.
    // veja: https://stackoverflow.com/questions/4078559/how-to-specify-doubles-precision-on-hibernate
    // veja: https://stackoverflow.com/questions/3413448/double-vs-bigdecimal/3413493#3413493
    // Quando for usar um BigDecimal, lembre-se de fornecê-lo como string, veja: https://stackoverflow.com/questions/28783918/convert-string-to-bigdecimal-in-java
    @Column(name = "Preço", scale = 10, precision = 5)
    private BigDecimal numeroPrecisoSemErrosDeArredondamento;

    // Falta alguns exemplos usando ForeignKey.
    // veja: https://stackoverflow.com/questions/15426736/how-can-i-mark-a-foreign-key-constraint-using-hibernate-annotations
    // veja: https://docs.jboss.org/hibernate/core/4.2/manual/en-US/html_single/

    public ExemploTabela(String primeiroCampo, String campoNãoNulável, int nãoApareceNoBD,
                         int campoÚnico, BigDecimal preço, String campoNulável) {
        this.primeiroCampo = primeiroCampo;
        this.campoNãoNulável = campoNãoNulável;
        this.nãoApareceNoBD = nãoApareceNoBD;
        this.campoÚnico = campoÚnico;
        this.numeroPrecisoSemErrosDeArredondamento = preço;
        this.campoNulável = campoNulável;
    }
}
