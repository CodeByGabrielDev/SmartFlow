package Services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import DAO.NotaFiscalDAO;
import Entities.Movimentacao;
import Entities.NotaFiscal;
import Entities.NotaFiscalItem;
import Entities.Produtos;
import Utils.JPAUtils;

public class ServicesNotaFiscal {

	NotaFiscalDAO notadao = new NotaFiscalDAO();
	
	public void emitirNotaFiscal(Movimentacao mov) {
		EntityManager em = JPAUtils.getEmf();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			
		}catch(Exception e) {
			
		}finally {
			
		}
		
	}
	
}
