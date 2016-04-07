package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.KitProductosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.util.Iterator;

import javax.persistence.PersistenceException;

public class KitProductosLocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public KitProductosLocal create(Long prod_oid_prod_kit, Long prod_oid_prod) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_KPRO_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        KitProductosLocal local = new KitProductosLocal(oid, prod_oid_prod_kit, prod_oid_prod);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(KitProductosLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(KitProductosLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public KitProductosLocal findByPrimaryKey(Long  oid) {
        KitProductosLocal local = em.find(KitProductosLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findAll() {
        Query query = em.createNamedQuery("KitProductosLocal.FindAll");
        return query.getResultList();
    }

    public Collection findByKitOid(Long oidKit) {
        Query query = em.createNamedQuery("KitProductosLocal.FindByKitOid");
        query.setParameter(1, oidKit);
        return query.getResultList();
    }

    public void vaciarProductosKit(Long oidKit) {
        Collection productosKit = this.findByKitOid(oidKit);
        Iterator it = productosKit.iterator();
        while (it.hasNext()) {
            this.remove((KitProductosLocal)it.next());
        }
    }
}
