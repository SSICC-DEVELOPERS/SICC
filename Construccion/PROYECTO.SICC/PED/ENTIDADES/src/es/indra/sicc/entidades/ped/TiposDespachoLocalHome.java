package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.TiposDespachoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TiposDespachoLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public TiposDespachoLocal create(Long pais_oid_pais, String cod_tipo_desp, Boolean ind_cron)
            throws MareException {
        
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_TIDS_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        TiposDespachoLocal local = new TiposDespachoLocal(oid, pais_oid_pais, cod_tipo_desp, ind_cron);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(TiposDespachoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(TiposDespachoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public TiposDespachoLocal findByPrimaryKey(Long  oid) {
        TiposDespachoLocal local = em.find(TiposDespachoLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
	
    public Collection findAll() {
        Query query=em.createNamedQuery("TiposDespachoLocal.FindAll");
        return query.getResultList();
    }

}
