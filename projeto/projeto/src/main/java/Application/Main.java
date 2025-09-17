package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entities.Movimentacao;
import Entities.NotaFiscal;
import Entities.Pessoa;
import Entities.PessoaFisica;
import Entities.Produtos;
import Services.ServiceMovimentacaoProduto;
import Services.ServicesMovimentacao;
import Services.ServicesNotaFiscal;
import Utils.JPAUtils;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ServicesNotaFiscal notaService = new ServicesNotaFiscal();
		ServicesMovimentacao mov = new ServicesMovimentacao();
		ServiceMovimentacaoProduto movProd = new ServiceMovimentacaoProduto();
		EntityManager em = JPAUtils.getEmf();
		
		/*
		List<Produtos> listaDeProdutos = new ArrayList<>();

		int idProduto = 1;
		Movimentacao mov1 = null;
		System.out.println("forneca o ID da pessoa em respectivo");
		int idPessoaFisica = sc.nextInt();
		Pessoa pessoa = em.find(Pessoa.class, idPessoaFisica);
		if (pessoa != null) {
			mov1 = new Movimentacao(pessoa, 0);
		} else {
			System.out.println("Pessoa nao encontrada, seguindo sem pessoa vinculada");
			mov1 = new Movimentacao(null, 0);
		}
		while (idProduto != 0) {
			System.out.println("digite o id do produto ");
			idProduto = sc.nextInt();
			Produtos prod = em.find(Produtos.class, idProduto);
			if (prod != null) {
				listaDeProdutos.add(prod);
			} else {
				System.out.println("Produto nao encontrado");
			}

		}
		mov.realizarMovimentacao(em, listaDeProdutos, mov1);
		*/
		int id = sc.nextInt();
		mov.cancelarMovimentacao(em, id);
	}
}
