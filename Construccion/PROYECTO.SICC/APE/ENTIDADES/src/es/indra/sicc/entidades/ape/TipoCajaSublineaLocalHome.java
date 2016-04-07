package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.TipoCajaSublineaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoCajaSublineaLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    public TipoCajaSublineaLocal create(Long numCaja, Long oidSublineaArmado, Long oidTipoCajaProducto)
            throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_TCSB_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        TipoCajaSublineaLocal local = new TipoCajaSublineaLocal(oid, numCaja, oidSublineaArmado, oidTipoCajaProducto);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(TipoCajaSublineaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(TipoCajaSublineaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public TipoCajaSublineaLocal findByPrimaryKey(Long  oid) {
        TipoCajaSublineaLocal local = em.find(TipoCajaSublineaLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("TipoCajaSublineaLocal.FindAll");
        return query.getResultList();
    }

}
