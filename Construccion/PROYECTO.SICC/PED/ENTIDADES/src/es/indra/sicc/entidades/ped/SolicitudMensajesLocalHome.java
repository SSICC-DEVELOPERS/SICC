package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.SolicitudMensajesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class SolicitudMensajesLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public SolicitudMensajesLocal create(Long soca_oid_soli_cabe, Long mens_oid_mens, Long val_buzo_mens) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_SOME_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        SolicitudMensajesLocal local = new SolicitudMensajesLocal(oid, soca_oid_soli_cabe, mens_oid_mens, val_buzo_mens);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(SolicitudMensajesLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(SolicitudMensajesLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public SolicitudMensajesLocal findByPrimaryKey(Long  oid) {
        SolicitudMensajesLocal local = em.find(SolicitudMensajesLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public Collection findBySolicitudMensaje(Long oidSolicitud,Long mensaje) {
        Query query=em.createNamedQuery("SolicitudMensajesLocal.FindBySolicitudMensaje");
        query.setParameter(1, oidSolicitud);
        query.setParameter(2, mensaje);
        return query.getResultList();
    }


    public Collection findAll() {
        Query query=em.createNamedQuery("SolicitudMensajesLocal.FindAll");
        return query.getResultList();
    }

}
