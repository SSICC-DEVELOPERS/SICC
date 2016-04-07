package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.TipoBloqueoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoBloqueoLocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public TipoBloqueoLocal create(String cod_tipo_bloq, Integer ind_bloq_fina, Integer num_nive_grav_bloq,
            Long stmr_oid_moti_rech, Long maab_oid_valo_acci_bloq, Long maab_oid_valo_acci_desb) throws MareException {
        
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_TIBQ_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        TipoBloqueoLocal local = new TipoBloqueoLocal(oid, cod_tipo_bloq, ind_bloq_fina, num_nive_grav_bloq, stmr_oid_moti_rech,
                maab_oid_valo_acci_bloq, maab_oid_valo_acci_desb);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(TipoBloqueoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(TipoBloqueoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public TipoBloqueoLocal findByPrimaryKey(Long  oid) {
        TipoBloqueoLocal local = em.find(TipoBloqueoLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("TipoBloqueoLocal.FindAll");
        return query.getResultList();
    }

    public TipoBloqueoLocal findByCodigo(String codigo) {
        Query query=em.createNamedQuery("TipoBloqueoLocal.FindByCodigo");
        query.setParameter(1, codigo);
        return (TipoBloqueoLocal)(query.getSingleResult());
    }
}
