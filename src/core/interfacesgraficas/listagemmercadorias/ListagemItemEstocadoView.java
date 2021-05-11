package core.interfacesgraficas.listagemmercadorias;

import core.models.*;
import mvc.Controller;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class ListagemItemEstocadoView {
    List<? extends ItemEstocadoModelReadable> itensEstocados;
    ListagemItemEstocadoController controller;
    ListagemItemEstocadoForm form;
    JFrame janela;

    // Uso de "constructor-chaining"; (Escrito por Eduardo Augusto)
    public ListagemItemEstocadoView(){
        this(new ListagemItemEstocadoController(new ArrayList<ItemEstocadoModelReadable>()));
    }

    public ListagemItemEstocadoView(ListagemItemEstocadoController controller){
        itensEstocados = new ArrayList<>();
//        mercadorias = new ArrayList<MercadoriaModel>();
        this.controller = controller;
        form = new ListagemItemEstocadoForm();
        janela = new JFrame("Listagem de Mercadorias");
    }

    public void mostrarJanela(){
        janela.add(form);
        janela.pack();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(500, 320);
        janela.setVisible(true);
    }

    public void setarConformeModel(List<? extends ItemEstocadoModelReadable> itensEstocados){
        form.modelo.setNumRows(0);
        for (var i : itensEstocados) {
            MercadoriaModelReadable m = i.getMercadoriaReadable();
            form.modelo.addRow(new Object[]{
                m.getNome(),
                m.getMarca(),
                i.getQuantidade(),
                m.getTamanho(),
                i.getLoteReadable().toString()
            });
        }

        this.itensEstocados = itensEstocados;
    }
}
