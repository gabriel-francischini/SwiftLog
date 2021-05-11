package bd.tests;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import bd.tests.HibernateTestUnit;

import bd.*;

import java.math.BigDecimal;
import java.time.*;
import java.util.Optional;
import java.util.Random;

public class ExpediçãoTest extends HibernateTestUnit {

    @Test
    public void testFazerExpedição() {

        /* No dia 22/01/2021, o entregador João
         * entregou os pacotes de
         * Rações para cães e gatos de diversas marcas
         */

        Mercadoria mercadorias[] = new Mercadoria[] {
            new Mercadoria("Alimento Úmido Cães Adultos Raças Médias 140g", "140 g", "Royal Canin", "", new BigDecimal(20.99)),
            new Mercadoria("Ração Seca Nutrilus Pro Frango & Carne", "15 Kg", "Nutrilus Pro", "", new BigDecimal(122.50)),
            new Mercadoria("Ração Seca PremieR Pet Golden Especial Cães Adulto ", "15 Kg", "GoldenN", "", new BigDecimal(124.90)),
            new Mercadoria("Ração Affinity Guabi Natural Salmão e Cevada para Cães Adultos Raças Média", "2.5 Kg", "Guabi Natural", "", new BigDecimal(97.70)),
            new Mercadoria("Ração Farmina N&D Pumpkin Cordeiro para Cães Adultos de Raças Médias", "10,1 Kg", "Farmina", "", new BigDecimal(341.90)),
            new Mercadoria("Ração Farmina N&D Pumpkin Frango para Cães Adultos de Raças Médias", "10,1 Kg", "Farmina", "", new BigDecimal(332.90))
        };
        for(Mercadoria m : mercadorias) { HibernateConfig.salvar(m); }

        /*
         * Os 6 pacotes de Ração "Alimento Úmido Cães Adultos Raças Médias 140g"
            Eram novos
         */
        Random rand = new Random();
        Lote lotes[] = new Lote[6];
        for(int i = 0; i < 6; i++) {
            lotes[i] = new Lote(
                    LocalDate.of(rand.nextInt(10) + 2000, rand.nextInt(12) + 1, rand.nextInt(28)),
                    LocalDate.of(rand.nextInt(10) + 2010, rand.nextInt(12) + 1, rand.nextInt(28)));
            HibernateConfig.salvar(lotes[i]);
        }

        var local = new Local(1111111, new BigDecimal("2030.10"), "Setor A");
        HibernateConfig.salvar(local);

        /*
         * Todos os 7 pacotes estão no mesmo lugar, são do mesmo lote
         *  portanto são uma mesma instancia
         */
        var itemEstocado = new ItemEstocado(mercadorias[0], lotes[0], local, 10);
        HibernateConfig.salvar(itemEstocado);

        /* Maria visitou a loja de petshop, e resolveu comprar
         * duas rações pra cachorro Royal Canin de 1 Kg e
         * 3 Varas de Pesca Shimano.
         */
        var maria = new Cliente();
        HibernateConfig.salvar(maria);

        /* Foram expedidas 5 unidades
         */

        var venda = new Venda(maria, 5, new BigDecimal("59.60"), LocalDate.now(), LocalTime.now());
        HibernateConfig.salvar(venda);

        /*  */
        var itemExpedido = new ItemVendido(itemEstocado, venda, 2, new BigDecimal("20.60"));
        HibernateConfig.salvar(itemExpedido);




        // bd.ExemploTabela user =
        //         new bd.ExemploTabela("1°", "não-nulo",
        //                 300,10, new BigDecimal("59.60"), null);

        // HibernateConfig.salvar(user);

        assertTrue(true);

        Optional<Mercadoria> ração_bd = Mercadoria.findById(mercadorias[0].id);

        // A ração tem que estar presente no banco de dados pois ela foi salva anteriormente
        assertTrue(ração_bd.isPresent());
        if(ração_bd.isPresent()){
            // E a ração presente no banco de dados tem que ser a mesma que foi salva anteriormente
            assertTrue(ração_bd.get().id == mercadorias[0].id);
            assertTrue(mercadorias[0].nome.equals(ração_bd.get().nome));
            assertTrue(mercadorias[0].tamanho.equals(ração_bd.get().tamanho));
            assertTrue(mercadorias[0].marca.equals(ração_bd.get().marca));
            assertTrue(mercadorias[0].descrição.equals(ração_bd.get().descrição));
        }

    }
}
