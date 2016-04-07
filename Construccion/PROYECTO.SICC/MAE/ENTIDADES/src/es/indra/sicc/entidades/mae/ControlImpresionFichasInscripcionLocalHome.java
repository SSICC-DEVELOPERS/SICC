package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.ControlImpresionFichasInscripcionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ControlImpresionFichasInscripcionLocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public ControlImpresionFichasInscripcionLocal create(Long clie_oid_clie, Integer num_impr) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_CIFI_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        ControlImpresionFichasInscripcionLocal local = new ControlImpresionFichasInscripcionLocal(oid, clie_oid_clie, num_impr);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(ControlImpresionFichasInscripcionLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(ControlImpresionFichasInscripcionLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public ControlImpresionFichasInscripcionLocal findByPrimaryKey(Long  oid) {
        ControlImpresionFichasInscripcionLocal local = em.find(ControlImpresionFichasInscripcionLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findAll() {
        Query query = em.createNamedQuery("ControlImpresionFichasInscripcionLocal.FindAll");
        return query.getResultList();        
    }
}
