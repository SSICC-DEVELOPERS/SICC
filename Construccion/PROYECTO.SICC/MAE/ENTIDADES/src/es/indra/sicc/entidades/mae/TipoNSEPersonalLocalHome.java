package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.TipoNSEPersonalLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoNSEPersonalLocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public TipoNSEPersonalLocal create(String cod_nsep, Long pais_oid_pais) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_NSEP_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        TipoNSEPersonalLocal local = new TipoNSEPersonalLocal(oid, cod_nsep, pais_oid_pais);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(TipoNSEPersonalLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(TipoNSEPersonalLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public TipoNSEPersonalLocal findByPrimaryKey(Long oid) {
        TipoNSEPersonalLocal local = em.find(TipoNSEPersonalLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findAll() {
        Query query = em.createNamedQuery("TipoNSEPersonalLocal.FindAll");
        return query.getResultList();
    }
}
