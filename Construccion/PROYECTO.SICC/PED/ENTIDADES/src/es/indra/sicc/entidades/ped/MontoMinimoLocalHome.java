package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.MontoMinimoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class MontoMinimoLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public MontoMinimoLocal create(BigDecimal val_niv1, BigDecimal val_niv2, BigDecimal val_niv3,
            Long ticl_oid_tipo_clie, Long tspa_oid_tipo_soli_pais) throws MareException {
        
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_MOMI_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        MontoMinimoLocal local = new MontoMinimoLocal(oid, val_niv1, val_niv2, val_niv3, ticl_oid_tipo_clie, tspa_oid_tipo_soli_pais);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(MontoMinimoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(MontoMinimoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public MontoMinimoLocal findByPrimaryKey(Long  oid) {
        MontoMinimoLocal local = em.find(MontoMinimoLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findAll() {
        Query query = em.createNamedQuery("MontoMinimoLocal.FindAll");
        return query.getResultList();
    }
}
