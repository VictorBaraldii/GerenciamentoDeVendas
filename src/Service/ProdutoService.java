package Service;

import dao.ProdutoDAO;
import Model.Produto;

import java.util.List;

public class ProdutoService {
    private ProdutoDAO produtoDAO = new ProdutoDAO();

    public void adicionarProduto(Produto produto) {
        produtoDAO.adicionarProduto(produto);
    }
    public List<Produto> listarProdutos() {
        return produtoDAO.listarProdutos();
    }
    public Produto buscarProdutosPorId(int id) {
        return produtoDAO.buscarProdutosPorId(id);
    }
}
