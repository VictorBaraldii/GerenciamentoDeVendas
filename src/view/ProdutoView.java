package view;

import Model.Produto;
import Service.ProdutoService;

import java.util.Scanner;

public class ProdutoView {
    private ProdutoService produtoService = new ProdutoService();
    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        while (true) {
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Buscar Produto por id");
            System.out.println("4. Sair");
            System.out.print("Escolha uma das opções acima: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    buscarProdutoPorId();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    private void adicionarProduto() {
        System.out.print("Digite o ID do Produto: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o nome do Produto: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();

        Produto produto = new Produto(id, nome, preco);
        produtoService.adicionarProduto(produto);
        System.out.println("Produto adicionado com sucesso!");

    }
    private void listarProdutos() {
        System.out.println("Lista de Produtos:");
        for (Produto produto : produtoService.listarProdutos()) {
            System.out.println(produto);
        }
    }
    private void buscarProdutoPorId() {
        System.out.print("Digite o ID do Produto: ");
        int id = scanner.nextInt();

        Produto produto = produtoService.buscarProdutosPorId(id);
        if (produto != null) {
            System.out.println(produto);
        } else {
            System.out.println("Produto não encontrado!");
        }
    }
}
