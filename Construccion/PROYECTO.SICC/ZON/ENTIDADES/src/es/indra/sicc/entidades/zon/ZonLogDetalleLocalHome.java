package es.indra.sicc.entidades.zon;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.zon.ZonLogDetalleLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class ZonLogDetalleLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-zon");
    private EntityManager em = emf.createEntityManager();

    public ZonLogDetalleLocal create(Long zlog_oid_zon_log, Timestamp fec_log,String typeProc, String mensaje, Object data)
            throws MareException {
        
        Long pk = SecuenciadorOID.obtenerSiguienteValor("ZON_ZLOD_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        ZonLogDetalleLocal local = new ZonLogDetalleLocal(pk, zlog_oid_zon_log, fec_log, typeProc, mensaje, data);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(ZonLogDetalleLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(ZonLogDetalleLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public ZonLogDetalleLocal findByPrimaryKey(Long  oidLogDeta) {
        ZonLogDetalleLocal local = em.find(ZonLogDetalleLocal.class, oidLogDeta);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findByLogId(Long logOid) {
        Query query = em.createNamedQuery("ZonLogDetalleLocal.FindByLogId");
        query.setParameter(1, logOid);
        return query.getResultList();
    }
        
    public Collection findAll() {
        Query query = em.createNamedQuery("ZonLogDetalleLocal.FindAll");
        return query.getResultList();
    }
	
}
