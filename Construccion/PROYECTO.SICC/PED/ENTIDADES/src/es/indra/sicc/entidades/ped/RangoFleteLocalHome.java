package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.RangoFleteLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class RangoFleteLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public RangoFleteLocal create(Long oidFlete, BigDecimal rangoInf, BigDecimal rangoSup, BigDecimal montoFij)
            throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_DEFL_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        RangoFleteLocal local = new RangoFleteLocal(oid, oidFlete, rangoInf, rangoSup, montoFij);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(RangoFleteLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(RangoFleteLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public RangoFleteLocal findByPrimaryKey(Long  oid) {
        RangoFleteLocal local = em.find(RangoFleteLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findAll() {
        Query query = em.createNamedQuery("RangoFleteLocal.FindAll");
        return query.getResultList();
    }
    
    public Collection findByOidFlete(Long oidFlete) {
        Query query=em.createNamedQuery("RangoFleteLocal.FindByOidFlete");
        query.setParameter(1, oidFlete);
        return query.getResultList();
    }    
}
