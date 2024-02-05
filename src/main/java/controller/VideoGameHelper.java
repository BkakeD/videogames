/**
 * @author Blake Dykstra - bdykstra
 * CIS175 - Spring 2024
 * Feb 4, 2024
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.VideoGame;

/**
 * 
 */
public class VideoGameHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("videogames");
	
	public void insertItem(VideoGame vg) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(vg);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<VideoGame> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<VideoGame> allItems = em.createQuery("SELECT i FROM VideoGame i ").getResultList();
		return allItems;
	}
	
	public void deleteItem(VideoGame toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<VideoGame>typedQuery = em.createQuery("select vg from VideoGame vg where vg.name = :selectedName and vg.developer = :selectedDeveloper and vg.publisher = :selectedPublisher", VideoGame.class);
		
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedDeveloper", toDelete.getDeveloper());
		typedQuery.setParameter("selectedPublisher", toDelete.getPublisher());
		
		typedQuery.setMaxResults(1);
		VideoGame result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public VideoGame searchForGameById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		VideoGame found = em.find(VideoGame.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateItem(VideoGame toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<VideoGame> searchForGameByName(String gameName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<VideoGame> typedQuery = em.createQuery("select vg from VideoGame vg where vg.name = :selectedName", VideoGame.class);
		typedQuery.setParameter("selectedName", gameName);
		
		List<VideoGame> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public List<VideoGame> searchForGameByDeveloper(String gameDeveloper) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<VideoGame> typedQuery = em.createQuery("select vg from VideoGame vg where vg.developer = :selectedDeveloper", VideoGame.class);
		typedQuery.setParameter("selectedDeveloper", gameDeveloper);
		
		List<VideoGame> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public List<VideoGame> searchForGameByPublisher(String gamePublisher) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<VideoGame> typedQuery = em.createQuery("select vg from VideoGame vg where vg.publisher = :selectedPublisher", VideoGame.class);
		typedQuery.setParameter("selectedPublisher", gamePublisher);
		
		List<VideoGame> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	
}
