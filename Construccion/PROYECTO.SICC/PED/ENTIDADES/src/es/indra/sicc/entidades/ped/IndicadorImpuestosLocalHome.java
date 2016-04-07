package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.IndicadorImpuestosLocal;

public class IndicadorImpuestosLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public IndicadorImpuestosLocal create(Long oidTasaImpu, String valIndiImpu, Long paisOidPais, Double valTasaImpu) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        IndicadorImpuestosLocal local = new IndicadorImpuestosLocal(oidTasaImpu, valIndiImpu, paisOidPais, valTasaImpu);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(IndicadorImpuestosLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(IndicadorImpuestosLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public IndicadorImpuestosLocal findByPrimaryKey(Long oidTasaImpu) {
        IndicadorImpuestosLocal local = em.find(IndicadorImpuestosLocal.class, oidTasaImpu);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public Collection findAll() {
        Query query=em.createNamedQuery("IndicadorImpuestosLocal.FindAll");
        return query.getResultList();
    }

    public IndicadorImpuestosLocal findByUK(Long pais,String imp) {
        Query query=em.createNamedQuery("IndicadorImpuestosLocal.FindByUK");
        query.setParameter(1, pais);
        query.setParameter(2, imp);
        return (IndicadorImpuestosLocal)(query.getSingleResult());
    }

}
