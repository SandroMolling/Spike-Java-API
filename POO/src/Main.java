public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente(
                "Sandro Molling",
                "111.111.111-11",
                "sandro@gmail.com",
                "Santa Maria do Herval"
        );

        Produto produto1 = new Produto(
                "Monitor",
                350.50,
                2
        );

        Produto produto2 = new Produto(
                "Notebook",
                3499.99,
                1
        );

        Pedido pedido = new Pedido(cliente);

        pedido.adicionarProduto(produto1);
        pedido.adicionarProduto(produto2);

        System.out.println("=== PEDIDO ===");
        System.out.println("Cliente: " + pedido.getCliente().getNome());
        System.out.println("Total: R$ " + pedido.calcularTotal());
    }
}