package core.interfacesgraficas.venda;

import bd.Mercadoria;
import core.interfacesgraficas.venda.VendaViewForm;
import core.models.ItemEstocadoModel;
import core.models.VendaModel;
import core.models.VendaModelReadable;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VendaView {
    // Composição do Model e do Controller
    VendaModelReadable vendaModel;
    VendaController vendaController;
    VendaViewForm vendaForm;
    JFrame window;

    public void mostrarJanela(){
        window.setTitle("Registrar Venda");
        window.setContentPane(vendaForm.contentPanel);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.pack();
        window.setVisible(true);


        // Esse código é pra usar depois, quando já tivermos o código 
        //ItemEstocadoModelReadable meu_item_estocado = ItemEstocadoModelReadable.findById(0);
        //System.out.println(meu_item_estocado);
    }
    public void setarConformeModel(){}
}
