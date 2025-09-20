package Services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import DAO.MovimentacaoDAO;
import DAO.MovimentacaoProdutoDAO;
import Entities.Movimentacao;
import Entities.MovimentacoesProdutos;
import Entities.Produtos;
import Utils.JPAUtils;

public class ServiceMovimentacaoProduto {

	MovimentacaoProdutoDAO movimetacaoProdutoDAO = new MovimentacaoProdutoDAO();
	MovimentacaoDAO mov = new MovimentacaoDAO();

	public void inserirDadosMovimentacaoProduto(EntityManager em, List<Produtos> lista, Movimentacao mov) {

		try {
			Double valorTotalPrecos = 0.0;
			if (!lista.isEmpty()) {
				for (Produtos prod : lista) {
					valorTotalPrecos = prod.getPreco_peca() + valorTotalPrecos;
					MovimentacoesProdutos movimentacao = new MovimentacoesProdutos(mov, prod);
					movimetacaoProdutoDAO.insert(em, movimentacao);

				}
				mov.setPrice(valorTotalPrecos);
				this.mov.update(em, mov);

			} else {
				throw new IllegalArgumentException(
						"the list of products is empty, not possible make a movimentation with a empty list");
			}
		} catch (Exception e) {

			throw new RuntimeException("Error to execute insert into Object MovimentacaoProduto. " + e.getMessage());
		}
	}

}
