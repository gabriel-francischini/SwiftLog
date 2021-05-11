package core.models;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import bd.Lote;
import mvc.Controller;
import bd.Mercadoria;

import bd.HibernateConfig;

// Model da entidade Mercadoria. Só relembrando que o Model oferece a manipulação dos dados presentes no banco de dados,
// tal qual os Controllers acessam para poder
public class MercadoriaModel implements MercadoriaModelReadable, MercadoriaModelWritable {
    // Campo private que representa uma entidade no BD.
    private Mercadoria mercadoria;

    // Importação estática que importa a classe Evento0Args e cria uma variável eventoValoresMudaram de mesmo tipo.
    private padrõesdeprojeto.observador.Evento0Args eventoValoresMudaram;

    // Construtor sem argumento, construindo um Model que não possui nenhuma entidade no BD.
    public MercadoriaModel() {
        // chama MercadoriaModel(Mercadoria mercadoria)
        this(new Mercadoria());
    }
    // Construtor que aceita uma entidade em seu argumento
    public MercadoriaModel(Mercadoria mercadoria) {
        // Cria um MercadoriaModel baseado na entidade Mercadoria do BD. (Escrito por Eduardo Augusto)
        System.out.println("Criando MercadoriaModel(Mercadoria)");

        // Atribui à um objeto MercadoriaModel uma referência à entidade Mercadoria do BD
        // (Escrito por Eduardo Augusto)
        this.mercadoria = mercadoria;

        // Cria um Event-Handler para mudanças nos atributos do MercadoriaModel criado.
        // (Escrito por Eduardo Augusto)
        this.eventoValoresMudaram = new padrõesdeprojeto.observador.Evento0Args();
    }

    /**
    * Getter do atributo "mercadoria", que corresponde a entidade Mercadoria no BD
    * Um controller precisa fornecer uma chave para esse método ser utilizado
    * (Escrito por Eduardo Augusto) 
    */ 
    public Mercadoria getMercadoria(Controller.Chave _chave){return mercadoria;}

    // Getters dos atributos da entidade Mercadoria no BD
    // Implementados da interface MercadoriaModelReadable
    public int getId() { return this.mercadoria.id; }
    public String getNome() { return this.mercadoria.nome; }
    public String getTamanho() { return this.mercadoria.tamanho; }
    public String getMarca() { return this.mercadoria.marca; }
    public String getDescrição() { return this.mercadoria.descrição; }
    public BigDecimal getPreçoBase(){ return this.mercadoria.preçoBase;}


    // Métodos que adicionam eventos e notificam mudança de estado
    // Implementados da interface MercadoriaModelWritable
    public void quandoMudarValores(padrõesdeprojeto.observador.Listener0Args callback){
        eventoValoresMudaram.addListener(callback);
    }
    public void notificarMudouValores(){
        eventoValoresMudaram.broadcast();
    }

    // Setters dos atributos da entidade Mercadoria
    /* Os setters necessitam de uma chave para poderem manipular os dados armazenados no BD.
    * Tal chave é fornecida pelo objeto controller correspondente, que extende a classe Controller.
    * (Escrito por Eduardo Augusto)
    * */
    // Métodos implementados da interface MercadoriaModelWritable
    public void setId(Controller.Chave _chave, int id) {
        this.mercadoria.id = id;
        // Notificação da mudança de um atributo.
        eventoValoresMudaram.broadcast();
    }

    public void setNome(Controller.Chave _chave, String nome) {
        this.mercadoria.nome = nome;
        eventoValoresMudaram.broadcast();
    }

    public void setTamanho(Controller.Chave _chave, String tamanho) {
        this.mercadoria.tamanho = tamanho;
        eventoValoresMudaram.broadcast();
    }

    public void setMarca(Controller.Chave _chave, String marca) {
        this.mercadoria.marca = marca;
        eventoValoresMudaram.broadcast();
    }

    public void setDescrição(Controller.Chave _chave, String descrição) {
        this.mercadoria.descrição = descrição;
        eventoValoresMudaram.broadcast();
    }

    public void setPreçoBase(Controller.Chave _chave, BigDecimal preçoBase) {
        this.mercadoria.preçoBase = preçoBase;
        eventoValoresMudaram.broadcast();
    }

    public MercadoriaModel getModel(Controller.Chave _chave) {
        return this;
    }

    // Realiza uma Query (Consulta) no BD. Se existir ..., se não existir, retorne um objeto Optional vazio.
    // (Escrito por Eduardo Augusto)
    public static Optional<MercadoriaModel> findById(int id){
        Optional<Mercadoria> mercadoria = Mercadoria.findById(id);
        if(mercadoria.isPresent()){
            return Optional.of(new MercadoriaModel(mercadoria.get()));
        } else {
            return Optional.empty();
        }
    }

    public static List<MercadoriaModel> findAll(){
        List<Mercadoria> mercadorias = Mercadoria.findAll();
        List<MercadoriaModel> models = new ArrayList<MercadoriaModel>();

        for(var m : mercadorias){
            models.add(new MercadoriaModel(m));
        }

        return models;
    }

    public MercadoriaModel getModel() { return this; }
    public Mercadoria getDBEntity() { return this.mercadoria; }
}