package es.indra.sicc.entidades.zon;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.zon.ZonLogLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class ZonLogLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-zon");
    private EntityManager em = emf.createEntityManager();

    public ZonLogLocal create(Long oid_zon_log, String val_tipo_proc, Long val_esta, Timestamp fec_log)
            throws MareException {
        
        final EntityTransaction et = em.getTransaction();
        et.begin();
        ZonLogLocal local = new ZonLogLocal(oid_zon_log, val_tipo_proc, val_esta, fec_log);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public ZonLogLocal create(String val_tipo_proc, Long val_esta, Timestamp fec_log)
            throws MareException {
            
        Long oid = SecuenciadorOID.obtenerSiguienteValor("ZON_ZLOG_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        ZonLogLocal local = new ZonLogLocal(oid, val_tipo_proc, val_esta, fec_log);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(ZonLogLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(ZonLogLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public ZonLogLocal findByPrimaryKey(Long  oidZonLog) {
        ZonLogLocal local = em.find(ZonLogLocal.class, oidZonLog);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findAll() {
        Query query = em.createNamedQuery("ZonLogLocal.FindAll");
        return query.getResultList();
    }

}
