package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.TipoDocumentoSeguimientoLocal;

public class TipoDocumentoSeguimientoLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public TipoDocumentoSeguimientoLocal create(Long  oid) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        TipoDocumentoSeguimientoLocal local = new TipoDocumentoSeguimientoLocal(oid);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(TipoDocumentoSeguimientoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(TipoDocumentoSeguimientoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public TipoDocumentoSeguimientoLocal findByPrimaryKey(Long  oid) {
        TipoDocumentoSeguimientoLocal local = em.find(TipoDocumentoSeguimientoLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
	
    public Collection findAll() {
        Query query=em.createNamedQuery("TipoDocumentoSeguimientoLocal.FindAll");
        return query.getResultList();
    }

}
