package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.UsuariosBloqueoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class UsuariosBloqueoLocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public UsuariosBloqueoLocal create(Long idUser, Long oidTipoBloqueo, Long oidValoUsuaBloq, Long oidPais) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_MAUB_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        UsuariosBloqueoLocal local = new UsuariosBloqueoLocal(oid, idUser, oidTipoBloqueo, oidValoUsuaBloq, oidPais);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(UsuariosBloqueoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(UsuariosBloqueoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public UsuariosBloqueoLocal findByPrimaryKey(Long  oid) {
        UsuariosBloqueoLocal local = em.find(UsuariosBloqueoLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("UsuariosBloqueoLocal.FindAll");
        return query.getResultList();
    }

}
