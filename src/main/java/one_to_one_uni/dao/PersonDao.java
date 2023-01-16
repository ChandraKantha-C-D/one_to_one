package one_to_one_uni.dao;

import java.sql.DriverManager;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one_uni.dto.AdhaarCard;
import one_to_one_uni.dto.Person;

public class PersonDao {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entitymanagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entitymanagerFactory.createEntityManager();
		}
	
	public void savePerson(Person person) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		entityTransaction.begin();
		AdhaarCard adhaarCard=person.getAdhaarCard();
		entityManager.persist(adhaarCard);
		entityManager.persist(person);
		entityTransaction.commit();
		}
	public void updatePerson(int id ,String name) {
		EntityManager entityManager=getEntityManager();
	    EntityTransaction entityTransaction= entityManager.getTransaction();
		Person person=entityManager.find(Person.class,id);
		person.setName(name);
		entityTransaction.begin();
	 	entityManager.merge(person);
		entityTransaction.commit();
		}
	public void deletePerson(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		Person person=entityManager.find(Person.class, id);
		if(person!=null) {
		entityTransaction.begin();
		AdhaarCard adhaarCard=person.getAdhaarCard();
		entityManager.remove(adhaarCard);
		entityManager.remove(person);
		entityTransaction.commit();
		}else {
			System.out.println("Person not found");
		}
		}
	public Person getPersonBasedOnId(int id) {
		EntityManager entityManager=getEntityManager();
		Person person = entityManager.find(Person.class, id);
		return person;
		}
	
	public List<Person> getAllPerson(){
		
		EntityManager entityManager = getEntityManager();
		Query query =entityManager.createQuery("select p from Person p");
		
		List<Person> list = query.getResultList();
		
		return list;
	}

}
