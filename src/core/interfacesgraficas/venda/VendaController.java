package core.interfacesgraficas.venda;

import core.models.VendaModel;
import core.interfacesgraficas.venda.VendaView;
import core.interfacesgraficas.venda.VendaController;

import bd.Venda;
import core.models.VendaModel;
import core.interfacesgraficas.venda.VendaView;
import core.models.VendaModelWritable;
import mvc.Controller;

public class VendaController extends Controller {
    //VendaModel
    private VendaModelWritable vendaModel;
    public VendaView vendaView;

    public VendaController(VendaView view, VendaModelWritable model){
        vendaView = view;
        vendaModel = model;
    }


    public void salvarAlterações(VendaModelWritable vendaModel){

        // Métodos setAtrib. do objeto vendaModel
//        vendaModel.setID(this.chave, null);
//        vendaModel.setCliente(this.chave, null);
//        vendaModel.setQuantidade(this.chave, null);
//        vendaModel.setValor(this.chave, null);
//        vendaModel.setDataVenda(this.chave, null);
//        vendaModel.setHoraVenda(this.chave, null);


        // ...

    }


}
