package es.indra.sicc.entidades.zon;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.zon.HistoricoGerentesLideresLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class HistoricoGerentesLideresLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-zon");
    private EntityManager em = emf.createEntityManager();

    public HistoricoGerentesLideresLocal create(Long pais, Long marcOidMarc, Long canaOidCana,
            String ua, String gere, Timestamp fecDesd) throws MareException {
            
        Long oid = SecuenciadorOID.obtenerSiguienteValor("ZON_HGER_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        HistoricoGerentesLideresLocal local = new HistoricoGerentesLideresLocal(oid, pais, marcOidMarc, canaOidCana, ua, gere, fecDesd);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(HistoricoGerentesLideresLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(HistoricoGerentesLideresLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public HistoricoGerentesLideresLocal findByPrimaryKey(Long  oid) {
        HistoricoGerentesLideresLocal local = em.find(HistoricoGerentesLideresLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public Collection findAll() {
        Query query=em.createNamedQuery("HistoricoGerentesLideresLocal.FindAll");
        return query.getResultList();
    }

    public HistoricoGerentesLideresLocal findByNoFechaHasta(String ua, Long oidPais, Long oidMarca, Long oidCanal) {
        Query query=em.createNamedQuery("HistoricoGerentesLideresLocal.FindByNoFechaHasta");
        query.setParameter(1, ua);
        query.setParameter(2, oidPais);
        query.setParameter(3, oidMarca);
        query.setParameter(4, oidCanal);
        return (HistoricoGerentesLideresLocal)(query.getSingleResult());
    }
}
