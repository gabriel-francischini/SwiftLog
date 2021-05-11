package core.interfacesgraficas.listagemmercadorias;

// Listas para armazenamento de dados.
import java.util.List;

// Import das classes "genéricas" para construção dos atributos e métodos
// das classes envolvidas no MVC. (Escrito por Eduardo Augusto)
import core.models.ItemEstocadoModelReadable;
import core.models.ItemEstocadoModelWritable;
import mvc.Controller;

// Import das classes "Model" relacionadas à entidade Mercadoria. (Escrito por Eduardo Augusto)
// "Push-Model": necessário para gravação de dados no BD. (Escrito por Eduardo Augusto)
// "Pull-Model": necessário para atualizar dados na view. (Escrito por Eduardo Augusto)


public class ListagemItemEstocadoController extends Controller {
    // Atributos (Escrito por Eduardo Augusto)
    // private List<MercadoriaModelWritable> mercadorias;
    private List<? extends ItemEstocadoModelReadable> itensEstocados;
    public ListagemItemEstocadoView view;

    public ListagemItemEstocadoController(List<? extends ItemEstocadoModelReadable> itensEstocados){
        // Implicitamente converte de List<ItemEstocadoModel> para List<ItemEstocadoModelWritable>
        this.itensEstocados = itensEstocados;

        view = new ListagemItemEstocadoView(this);
        // Implicitamente converte de List<ItemEstocadoModelWritable> para List<ItemEstocadoModelReadable>
        view.setarConformeModel(this.itensEstocados);
    }
}
