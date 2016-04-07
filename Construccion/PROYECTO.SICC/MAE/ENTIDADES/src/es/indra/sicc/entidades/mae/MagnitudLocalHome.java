package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.MagnitudLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MagnitudLocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public MagnitudLocal create(String codMagn) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_MAGN_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        MagnitudLocal local = new MagnitudLocal(oid, codMagn);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(MagnitudLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(MagnitudLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public MagnitudLocal findByPrimaryKey(Long  oid) {
        MagnitudLocal local = em.find(MagnitudLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findAll() {
        Query query=em.createNamedQuery("MagnitudLocal.FindAll");
        return query.getResultList();
    }

    public MagnitudLocal findByUk(String codMagn) {
        Query query=em.createNamedQuery("MagnitudLocal.FindByUk");
        query.setParameter(1, codMagn);
        return (MagnitudLocal)(query.getSingleResult());
    }

}
