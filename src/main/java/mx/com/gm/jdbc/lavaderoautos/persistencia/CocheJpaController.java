
package mx.com.gm.jdbc.lavaderoautos.persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import mx.com.gm.jdbc.lavaderoautos.logica.Coche;
import mx.com.gm.jdbc.lavaderoautos.persistencia.exceptions.NonexistentEntityException;


public class CocheJpaController implements Serializable {

    public CocheJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public CocheJpaController() {
        emf = Persistence.createEntityManagerFactory("lavadero");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Coche coche) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(coche);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Coche coche) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            coche = em.merge(coche);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = coche.getNum_cliente();
                if (findCoche(id) == null) {
                    throw new NonexistentEntityException("The coche with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Coche coche;
            try {
                coche = em.getReference(Coche.class, id);
                coche.getNum_cliente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The coche with id " + id + " no longer exists.", enfe);
            }
            em.remove(coche);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Coche> findCocheEntities() {
        return findCocheEntities(true, -1, -1);
    }

    public List<Coche> findCocheEntities(int maxResults, int firstResult) {
        return findCocheEntities(false, maxResults, firstResult);
    }

    private List<Coche> findCocheEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Coche.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Coche findCoche(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Coche.class, id);
        } finally {
            em.close();
        }
    }

    public int getCocheCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Coche> rt = cq.from(Coche.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
