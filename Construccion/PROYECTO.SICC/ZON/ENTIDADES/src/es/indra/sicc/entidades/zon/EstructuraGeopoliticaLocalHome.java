package es.indra.sicc.entidades.zon;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.zon.EstructuraGeopoliticaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class EstructuraGeopoliticaLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-zon");
    private EntityManager em = emf.createEntityManager();

    public EstructuraGeopoliticaLocal create(Integer cod_nive, Long pais_oid_pais,
            Long dipo_oid_divi_poli, Timestamp fecha) throws MareException {
            
        Long oid = SecuenciadorOID.obtenerSiguienteValor("ZON_EGEO_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        EstructuraGeopoliticaLocal local = new EstructuraGeopoliticaLocal(oid, cod_nive, pais_oid_pais, dipo_oid_divi_poli, fecha);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(EstructuraGeopoliticaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(EstructuraGeopoliticaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public EstructuraGeopoliticaLocal findByPrimaryKey(Long  oid) {
        EstructuraGeopoliticaLocal local = em.find(EstructuraGeopoliticaLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findByPaisNivelEGBorrado(Long oidPais, Integer nivelEG, Boolean borrado) {
        Query query = em.createNamedQuery("EstructuraGeopoliticaLocal.FindByPaisNivelEGBorrado");
        query.setParameter(1, oidPais);
        query.setParameter(2, nivelEG);
        query.setParameter(3, borrado);
        return query.getResultList();
    }

    public Collection findByPaisNivelEGBorrado(Long oidPais) {
        Query query = em.createNamedQuery("EstructuraGeopoliticaLocal.FindByPais");
        query.setParameter(1, oidPais);
        return query.getResultList();
    }

    public Collection findAll() {
        Query query = em.createNamedQuery("EstructuraGeopoliticaLocal.FindAll");
        return query.getResultList();
    }
}
