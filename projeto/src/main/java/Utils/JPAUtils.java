package Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");

	public static EntityManager getEmf() {
		return emf.createEntityManager();
	}

	public static void closeEmf() {
		emf.close();
	}

}
