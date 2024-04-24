package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
//		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
//		Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
//		Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		Pessoa p = em.find(Pessoa.class, 2); // para remover o objeto deve estar monitorado ou seja, um objeto que acabou de inserir ou um objeto que foi buscado do banco de dados e ainda não teve o EntityManager fechado
		em.getTransaction().begin();
		em.remove(p); // não consegue remover uma instância destacada (
		em.getTransaction().commit();
//		Pessoa p = em.find(Pessoa.class, 2); // pega os dados requeridos no bd
		
		System.out.println(p);
		
//		em.getTransaction().begin(); // adiciona os dados dos objetos no bd
//		em.persist(p1);
//		em.persist(p2);
//		em.persist(p3);
//		em.getTransaction().commit();
		
		System.out.println("Pronto!");
		em.close();
		emf.close();
	}
}
