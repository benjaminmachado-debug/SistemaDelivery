import model.ItemPedido;
import model.Pedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PedidoTest {

    @Test
    public void deveCalcularTotalComVariosItens() {
        Pedido pedido = new Pedido();
        pedido.adicionarItem(new ItemPedido(1, "X-Burguer", 2, 18.90));
        pedido.adicionarItem(new ItemPedido(2, "Refrigerante Lata", 2, 6.00));

        double totalEsperado = 49.80; // (2*18.90) + (2*6.00)

        assertEquals(totalEsperado, pedido.calcularTotal(), 0.001);
    }

    @Test
    public void totalDeveSerZeroParaPedidoSemItens() {
        Pedido pedido = new Pedido();

        assertEquals(0.0, pedido.calcularTotal(), 0.001);
    }

    @Test
    public void pedidoNovoDeveIniciarComStatusAberto() {
        Pedido pedido = new Pedido();

        assertEquals("ABERTO", pedido.getStatus());
    }
}
