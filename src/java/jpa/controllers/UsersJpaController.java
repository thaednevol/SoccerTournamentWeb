package jpa.controllers;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;
import jpa.entities.Users;

/**
 *
 * @author mbohm
 */
public class UsersJpaController {
    @Resource
    private UserTransaction utx = null;
    @PersistenceUnit(unitName = "SoccerTournamentPU")
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("SoccerTournamentPU");
        }
        
        System.out.println(emf.toString());
        return emf.createEntityManager();
    }
    
    public int getUserCount() {
        EntityManager em = getEntityManager();
        //em.getTransaction().begin();
        //Users u = new Users("Luisa", "luisa", 234234, "CC", null, null, null, null, null, null, null);
        //em.persist(u);
        //em.getTransaction().commit();
        try {
//            Query x = em.createQuery("select count(o) from Users as o");
//            //em.c
//            
//            System.out.println("EM______________________________________________ "+x.toString());
            
//            Long l=(Long) em.createQuery("SELECT COUNT(e) FROM Users e").getSingleResult();
            //Long l= (Long)(((int)).intValue());
            Query x = em.createNamedQuery("Users.findAll", Users.class);//.getSingleResult();
            
            //System.out.println("____________________"+x.toString()+" "+x.getFirstResult());
            //x.
            Long l=(Long) em.createQuery("select count(o.id) from Users o").getSingleResult();
            
            System.out.println("____________________"+l);
            
            return l.intValue();
        } finally {
            em.close();
        }
//        return 0;
    }
    
    public static void main(String args[]){
        UsersJpaController us = new UsersJpaController();
        us.getUserCount();
        System.out.println("sdfasds");
    }

    public void create(Users users) throws  Exception {
        
        /*EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Us customerId = purchaseOrder.getCustomerId();
            if (customerId != null) {
                customerId = em.getReference(customerId.getClass(), customerId.getCustomerId());
                purchaseOrder.setCustomerId(customerId);
            }
            Product productId = purchaseOrder.getProductId();
            if (productId != null) {
                productId = em.getReference(productId.getClass(), productId.getProductId());
                purchaseOrder.setProductId(productId);
            }
            em.persist(purchaseOrder);
            if (customerId != null) {
                customerId.getPurchaseOrderCollection().add(purchaseOrder);
                customerId = em.merge(customerId);
            }
            if (productId != null) {
                productId.getPurchaseOrderCollection().add(purchaseOrder);
                productId = em.merge(productId);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findPurchaseOrder(purchaseOrder.getOrderNum()) != null) {
                throw new PreexistingEntityException("PurchaseOrder " + purchaseOrder + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }*/
    }

    public void edit(Users purchaseOrder) throws  Exception {
        /*EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            PurchaseOrder persistentPurchaseOrder = em.find(PurchaseOrder.class, purchaseOrder.getOrderNum());
            Customer customerIdOld = persistentPurchaseOrder.getCustomerId();
            Customer customerIdNew = purchaseOrder.getCustomerId();
            Product productIdOld = persistentPurchaseOrder.getProductId();
            Product productIdNew = purchaseOrder.getProductId();
            if (customerIdNew != null) {
                customerIdNew = em.getReference(customerIdNew.getClass(), customerIdNew.getCustomerId());
                purchaseOrder.setCustomerId(customerIdNew);
            }
            if (productIdNew != null) {
                productIdNew = em.getReference(productIdNew.getClass(), productIdNew.getProductId());
                purchaseOrder.setProductId(productIdNew);
            }
            purchaseOrder = em.merge(purchaseOrder);
            if (customerIdOld != null && !customerIdOld.equals(customerIdNew)) {
                customerIdOld.getPurchaseOrderCollection().remove(purchaseOrder);
                customerIdOld = em.merge(customerIdOld);
            }
            if (customerIdNew != null && !customerIdNew.equals(customerIdOld)) {
                customerIdNew.getPurchaseOrderCollection().add(purchaseOrder);
                customerIdNew = em.merge(customerIdNew);
            }
            if (productIdOld != null && !productIdOld.equals(productIdNew)) {
                productIdOld.getPurchaseOrderCollection().remove(purchaseOrder);
                productIdOld = em.merge(productIdOld);
            }
            if (productIdNew != null && !productIdNew.equals(productIdOld)) {
                productIdNew.getPurchaseOrderCollection().add(purchaseOrder);
                productIdNew = em.merge(productIdNew);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = purchaseOrder.getOrderNum();
                if (findPurchaseOrder(id) == null) {
                    throw new NonexistentEntityException("The purchaseOrder with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }*/
    }

    public void destroy(Integer id) throws Exception {
        /*EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            PurchaseOrder purchaseOrder;
            try {
                purchaseOrder = em.getReference(PurchaseOrder.class, id);
                purchaseOrder.getOrderNum();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The purchaseOrder with id " + id + " no longer exists.", enfe);
            }
            Customer customerId = purchaseOrder.getCustomerId();
            if (customerId != null) {
                customerId.getPurchaseOrderCollection().remove(purchaseOrder);
                customerId = em.merge(customerId);
            }
            Product productId = purchaseOrder.getProductId();
            if (productId != null) {
                productId.getPurchaseOrderCollection().remove(purchaseOrder);
                productId = em.merge(productId);
            }
            em.remove(purchaseOrder);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }*/
    }

    /*public List<PurchaseOrder> findPurchaseOrderEntities() {
        return findPurchaseOrderEntities(true, -1, -1);
    }

    public List<PurchaseOrder> findPurchaseOrderEntities(int maxResults, int firstResult) {
        return findPurchaseOrderEntities(false, maxResults, firstResult);
    }

    private List<PurchaseOrder> findPurchaseOrderEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from PurchaseOrder as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public PurchaseOrder findPurchaseOrder(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PurchaseOrder.class, id);
        } finally {
            em.close();
        }
    }

    public int getPurchaseOrderCount() {
        EntityManager em = getEntityManager();
        try {
            return ((Long) em.createQuery("select count(o) from PurchaseOrder as o").getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }*/

}
