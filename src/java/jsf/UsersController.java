/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.controllers.UsersJpaController;
import jpa.entities.Users;
import jsf.util.PagingInfo;

/**
 *
 * @author ehurtado
 */
public class UsersController {
    private EntityManagerFactory emf;
    private final UsersJpaController jpaController;
    private final PagingInfo pagingInfo;
 
    private EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("SoccerTournamentPU");
        }
        return emf.createEntityManager();
    }
    
    public UsersController() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        jpaController = (UsersJpaController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "usersJpa");
        pagingInfo = new PagingInfo();
    }
 
    public Users[] getUsers() {
        EntityManager em = getEntityManager();
        try {
            javax.persistence.Query q = em.createQuery("select c from users as c");
            return (Users[]) q.getResultList().toArray(new Users[0]);
        } finally {
            em.close();
        }
    }
    
    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            int x = jpaController.getUserCount();
            pagingInfo.setItemCount(x);
        }
        
        return pagingInfo;
    }
    
    public String listSetup() {
        reset(true);
        return "users_list";
    }
    
     private void reset(boolean resetFirstItem) {
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
     }
    
}
