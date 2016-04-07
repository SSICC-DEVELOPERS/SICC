package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.GestionStockLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class GestionStockLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public GestionStockLocal create(Long perd_oid_peri, Integer cod_gest_stoc, Long ofde_oid_deta_ofer) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_GEST_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        GestionStockLocal local = new GestionStockLocal(oid, perd_oid_peri, cod_gest_stoc, ofde_oid_deta_ofer);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(GestionStockLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(GestionStockLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public GestionStockLocal findByPrimaryKey(Long  oid) {
        GestionStockLocal local = em.find(GestionStockLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findAll() {
        Query query = em.createNamedQuery("GestionStockLocal.FindAll");
        return query.getResultList();
    }
}
