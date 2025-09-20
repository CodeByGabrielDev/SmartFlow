package Services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import DAO.NotaFiscalItemDAO;
import Entities.NotaFiscal;
import Entities.NotaFiscalItem;
import Entities.Produtos;
import Utils.JPAUtils;

public class ServiceNotaFiscalItem {

	NotaFiscalItemDAO notaItemDAO = new NotaFiscalItemDAO();

	public void inserirItens(EntityManager em, NotaFiscal nota, List<Produtos> lista) {

		try {

			if (!lista.isEmpty()) {
				Double valorTotalNota = 0.0;
				for (Produtos prod : lista) {
					NotaFiscalItem notaItem = new NotaFiscalItem(nota, prod, prod.getReferencia());
					valorTotalNota = prod.getPreco_peca() + valorTotalNota;
					em.persist(notaItem);
				}
				nota.setPrice(valorTotalNota);
				em.merge(nota);

			}
		} catch (Exception e) {

			throw new RuntimeException("Error to create a OBJECT 'NotaFiscalItem' " + e.getMessage());
		}

	}

}
