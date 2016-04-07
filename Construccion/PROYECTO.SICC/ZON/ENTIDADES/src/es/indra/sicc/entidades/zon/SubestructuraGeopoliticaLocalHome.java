package es.indra.sicc.entidades.zon;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.zon.SubestructuraGeopoliticaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class SubestructuraGeopoliticaLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-zon");
    private EntityManager em = emf.createEntityManager();

    public SubestructuraGeopoliticaLocal create(Integer cod_sube, Long egeo_oid_estr_geop) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("ZON_SGEO_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        SubestructuraGeopoliticaLocal local = new SubestructuraGeopoliticaLocal(oid, cod_sube, egeo_oid_estr_geop);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(SubestructuraGeopoliticaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(SubestructuraGeopoliticaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public SubestructuraGeopoliticaLocal findByPrimaryKey(Long  oid) {
        SubestructuraGeopoliticaLocal local = em.find(SubestructuraGeopoliticaLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findByEGCod(Integer codigo, Long oidEstructuraGeopoli) {
        Query query=em.createNamedQuery("SubestructuraGeopoliticaLocal.FindByEGCod");
        query.setParameter(1, codigo);
        query.setParameter(2, oidEstructuraGeopoli);
        return query.getResultList();
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("SubestructuraGeopoliticaLocal.FindAll");
        return query.getResultList();
    }
}
