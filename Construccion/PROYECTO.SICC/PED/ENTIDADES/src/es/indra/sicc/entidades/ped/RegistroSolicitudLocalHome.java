package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.RegistroSolicitudLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class RegistroSolicitudLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public RegistroSolicitudLocal create(Long clie_oid_clie, Long lote_oid_lote, Long zzon_oid_zona) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_RESO_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        RegistroSolicitudLocal local = new RegistroSolicitudLocal(oid, clie_oid_clie, lote_oid_lote, zzon_oid_zona);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(RegistroSolicitudLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(RegistroSolicitudLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public RegistroSolicitudLocal findByPrimaryKey(Long  oid) {
        RegistroSolicitudLocal local = em.find(RegistroSolicitudLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
	
    public Collection findAll() {
        Query query=em.createNamedQuery("RegistroSolicitudLocal.FindAll");
        return query.getResultList();
    }

}
