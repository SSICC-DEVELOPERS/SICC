package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.MonitorEjecucionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MonitorEjecucionLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public MonitorEjecucionLocal create(Long valTipoSoliPais, Long valGrupProc, Long valZona, String codProc)
            throws MareException {
        
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_MOEJ_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        MonitorEjecucionLocal local = new MonitorEjecucionLocal(oid, valTipoSoliPais, valGrupProc, valZona, codProc);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(MonitorEjecucionLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(MonitorEjecucionLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public MonitorEjecucionLocal findByPrimaryKey(Long  oid) {
        MonitorEjecucionLocal local = em.find(MonitorEjecucionLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public Collection findAll() {
        Query query=em.createNamedQuery("MonitorEjecucionLocal.FindAll");
        return query.getResultList();
    }

    public MonitorEjecucionLocal findByUK(Long oidTipoSolicitud,Long oidZona,Long gp) {
        Query query=em.createNamedQuery("MonitorEjecucionLocal.FindByUK");
        query.setParameter(1, oidTipoSolicitud);
        query.setParameter(2, oidZona);
        query.setParameter(3, gp);
        return (MonitorEjecucionLocal)(query.getSingleResult());
    }

}
