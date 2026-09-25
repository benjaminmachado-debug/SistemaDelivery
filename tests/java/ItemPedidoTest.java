import model.ItemPedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ItemPedidoTest {

    @Test
    public void deveCalcularSubtotalCorretamente() {
        ItemPedido item = new ItemPedido(1, "X-Burguer", 3, 18.90);

        double subtotalEsperado = 56.70;

        assertEquals(subtotalEsperado, item.calcularSubtotal(), 0.001);
    }

    @Test
    public void subtotalDeveSerZeroQuandoQuantidadeForZero() {
        ItemPedido item = new ItemPedido(1, "Refrigerante", 0, 6.00);

        assertEquals(0.0, item.calcularSubtotal(), 0.001);
    }
}
