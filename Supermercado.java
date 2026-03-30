import java.util.ArrayList;
import java.util.Scanner;

class Produto {
    String nome;
    double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}

public class Supermercado {

    static ArrayList<Produto> lista = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n===== LISTA DE SUPERMERCADO =====");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Remover produto");
            System.out.println("3 - Alterar preço");
            System.out.println("4 - Listar produtos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    adicionar();
                    break;
                case 2:
                    remover();
                    break;
                case 3:
                    alterarPreco();
                    break;
                case 4:
                    listar();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    static void adicionar() {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();

        lista.add(new Produto(nome, preco));
        System.out.println("Produto adicionado!");
    }

    static void remover() {
        listar();
        System.out.print("Digite o número do produto para remover: ");
        int i = scanner.nextInt();

        if (i >= 0 && i < lista.size()) {
            lista.remove(i);
            System.out.println("Produto removido!");
        } else {
            System.out.println("Índice inválido!");
        }
    }

    static void alterarPreco() {
        listar();
        System.out.print("Digite o número do produto: ");
        int i = scanner.nextInt();

        if (i >= 0 && i < lista.size()) {
            System.out.print("Novo preço: ");
            double novoPreco = scanner.nextDouble();
            lista.get(i).preco = novoPreco;
            System.out.println("Preço atualizado!");
        } else {
            System.out.println("Índice inválido!");
        }
    }

    static void listar() {
        System.out.println("\n--- Produtos ---");
        for (int i = 0; i < lista.size(); i++) {
            Produto p = lista.get(i);
            System.out.println(i + " - " + p.nome + " | R$ " + p.preco);
        }
    }
}