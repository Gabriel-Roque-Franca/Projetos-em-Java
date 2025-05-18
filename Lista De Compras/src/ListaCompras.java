
import java.util.ArrayList;
import java.util.Scanner;

public class ListaCompras {

    private static ArrayList<Produto> lista = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n=== LISTA DE COMPRAS ===");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Remover produto");
            System.out.println("3. Listar produtos");
            System.out.println("4. Calcular total");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    removerProduto();
                    break;
                case 3:
                    break;
                case 4:
                    calcularTotal();
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void adicionarProduto() {
        System.out.print("\nNome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();

        System.out.print("Preço unitário: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        Produto produto = new Produto(nome, quantidade, preco);
        lista.add(produto);

        System.out.println("Produto adicionado com sucesso!");
    }

    private static void removerProduto() {
        if (lista.isEmpty()) {
            System.out.println("\nA lista está vazia!");
            return;
        }

        System.out.println("\nProdutos na lista: ");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i));
        }

        System.out.print("\nDigite o número do produto a ser removido: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indice > +0 && indice < lista.size()) {
            Produto removido = lista.remove(indice);
            System.out.println("Produto removido: " + removido.getNome());
        } else {
            System.out.println("Índice inválido!");
        }
    }

    private static void listarProdutos() {
        if (lista.isEmpty()) {
            System.out.println("\nA lista está vazia!");
            return;
        }

        System.out.println("\n=== PRODUTOS NA LISTA === ");
        for (Produto produto : lista) {
            System.out.println(produto);
        }
    }

    private static void calcularTotal() {
        if (lista.isEmpty()) {
            System.out.println("\nA lista está vazia!");
            return;
        }
        double total = 0;
        for (Produto produto : lista) {
            total += produto.getQuantidade() * produto.getPreco();
        }
        System.out.printf("\nTotal da lista: R$ %.2f\n", total);
    }
}
