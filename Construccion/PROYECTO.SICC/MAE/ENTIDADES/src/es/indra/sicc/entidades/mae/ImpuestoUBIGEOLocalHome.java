package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.ImpuestoUBIGEOLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ImpuestoUBIGEOLocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public ImpuestoUBIGEOLocal create(Long prod_oid_prod, Long oid_subac, Long oidTasaImpuesto) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_IMUB_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        ImpuestoUBIGEOLocal local = new ImpuestoUBIGEOLocal(oid, prod_oid_prod, oid_subac, oidTasaImpuesto);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(ImpuestoUBIGEOLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(ImpuestoUBIGEOLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public ImpuestoUBIGEOLocal findByPrimaryKey(Long  oid) {
        ImpuestoUBIGEOLocal local = em.find(ImpuestoUBIGEOLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findAll() {
        Query query = em.createNamedQuery("ImpuestoUBIGEOLocal.FindAll");
        return query.getResultList();
    }
}
