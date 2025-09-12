package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entities.NotaFiscal;
import Entities.Produtos;
import Services.ServicesNotaFiscal;
import Utils.JPAUtils;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ServicesNotaFiscal notaService = new ServicesNotaFiscal();

		EntityManager em = JPAUtils.getEmf();
		String jpql = "SELECT e from NotaFiscal e WHERE e.sequencial = :sequencial";

		TypedQuery<NotaFiscal> notas = em.createQuery(jpql, NotaFiscal.class);
		int recebe = sc.nextInt();
		notas.setParameter("sequencial", recebe);

		List<NotaFiscal> listaDeNotas = notas.getResultList();

		for (NotaFiscal e : listaDeNotas) {
			System.out.println(e.getSequencial() + " CFOP " + e.getCFOP());
		}

		System.out.println(listaDeNotas);

	}
}
