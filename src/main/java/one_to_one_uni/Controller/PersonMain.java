package one_to_one_uni.Controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_one_uni.dao.PersonDao;
import one_to_one_uni.dto.AdhaarCard;
import one_to_one_uni.dto.Person;

public class PersonMain {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		boolean exit=true;
		do {
			System.out.println("Enter your Choice \n 1. To Save Person \n 2. To Update Person \n 3. To Delete Person \n 4. To get Person based on Id \n 5. To get All Person's \n 6. To Exit."
					+ "");
			int choice=scanner.nextInt();
			switch(choice) {
			case 1 : {
				System.out.println("Enter person id");
				int id=scanner.nextInt();
				System.out.println("Enter person name");
				String name=scanner.next();
				System.out.println("Enter peron address");
				String address=scanner.next();
				System.out.println("Enter person phone");
				long phone =scanner.nextLong();
				Person person = new Person();
				person.setId(id);
				person.setName(name);
				person.setPhone(phone);
				person.setAddress(address);
				System.out.println("Enter Adhaar Id");
				int a_id=scanner.nextInt();
				System.out.println("Enter Adhaar name");
				String a_name=scanner.next();
				System.out.println("Enter Adhaar address");
				String a_address=scanner.next();
				AdhaarCard adhaarCard =new AdhaarCard();
				adhaarCard.setId(a_id);
				adhaarCard.setAddress(a_address);
				adhaarCard.setName(a_name);
				person.setAdhaarCard(adhaarCard);
				
				PersonDao dao=new PersonDao();
				dao.savePerson(person);
				}break;
			case 2 : {
				System.out.println("Enter person id");
			    int id=scanner.nextInt();
			    System.out.println("Enter person name to be updated");
			    String name=scanner.next();
			    Person person = new Person();
			    person.setName(name);
			    PersonDao dao=new PersonDao();
			    dao.updatePerson(id ,name);
			    System.out.println("Updated ");
				
			}break;//end of case 2
		case 3 : {
			System.out.println("Enter the id to be deleted");
			int id=scanner.nextInt();
			 PersonDao dao=new PersonDao();
			    EntityManager entityManager=dao.getEntityManager();
			    Person person1=entityManager.find(Person.class, id);
			    if(person1!=null) {
			    	PersonDao dao2=new PersonDao();
			    	dao2.deletePerson(id);
			    	System.out.println("Deleted");
			    }else {
			    	System.out.println("id not found");
			    }
			
			
		}break;//end of case 3
		
		case 4 : {
			System.out.println("Enter the id to be fetch");
			int id=scanner.nextInt();
			 PersonDao dao=new PersonDao();
			    EntityManager entityManager=dao.getEntityManager();
			    Person person1=entityManager.find(Person.class, id);
			    if(person1!=null) {
			    	PersonDao dao2=new PersonDao();
			    	System.out.println(dao2.getPersonBasedOnId(id));
			    	
			    	
			    }else {
			    	System.out.println("id not found");
			    }
			    }break;//end of case 4
			   
		case 5 : {
			PersonDao dao = new PersonDao();
		    System.out.println(dao.getAllPerson());	
			
		}break;//end of case 5
		
		case 6 :{
			exit=false;
			System.out.println("Thank you");
		}break;
			
			}//end of switch 1  
			

			
		}while(exit);
		
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		//object creation of adhaarCard and storing data in it
//		AdhaarCard adhaarCard =new AdhaarCard();
//		adhaarCard.setId(101);
//		adhaarCard.setName("Ram");
//		adhaarCard.setAddress("India");
//		//object creation of Person and storing data in it
//		Person person = new Person();
//		person.setId(1);
//		person.setName("Ram");
//		person.setPhone(9874663210l);
//		person.setAddress("Bangalore");
//		person.setAdhaarCard(adhaarCard);
//		
//		entityTransaction.begin();
//		
//		entityManager.persist(adhaarCard);
//		entityManager.persist(person);
//		 
//		entityTransaction.commit();
}

}
