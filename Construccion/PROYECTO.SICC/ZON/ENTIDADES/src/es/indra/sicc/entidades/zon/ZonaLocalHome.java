package es.indra.sicc.entidades.zon;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.zon.ZonaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class ZonaLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-zon");
    private EntityManager em = emf.createEntityManager();

    public ZonaLocal create(String codZona, Long oidPais, Long oidMarca,
            Long oidCanal, Long zorg_oid_regi, Timestamp fz, Long oidPeriodoInicio) throws MareException {
            
        Long oid = SecuenciadorOID.obtenerSiguienteValor("ZON_ZZON_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        ZonaLocal local = new ZonaLocal(oid, codZona, oidPais, oidMarca, oidCanal, zorg_oid_regi, fz, oidPeriodoInicio);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(ZonaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(ZonaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public ZonaLocal findByPrimaryKey(Long  oid) {
        ZonaLocal local = em.find(ZonaLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public Collection findByCodigo(Long oidRegion, String codZona) {
        Query query=em.createNamedQuery("ZonaLocal.FindByCodigo");
        query.setParameter(1, oidRegion);
        query.setParameter(2, codZona);
        return query.getResultList();
    }

    public Collection findByCodigo(Long oidPais, Long oidMarca, Long oidCanal, String codZona) {
        Query query=em.createNamedQuery("ZonaLocal.FindByCodigo2");
        query.setParameter(1, oidPais);
        query.setParameter(2, oidMarca);
        query.setParameter(3, oidCanal);
        query.setParameter(4, codZona);
        return query.getResultList();
    }

    public ZonaLocal findByUK(Long pais, Long marca, Long canal, String codZona) {
        Query query=em.createNamedQuery("ZonaLocal.FindByUK");
        query.setParameter(1, pais);
        query.setParameter(2, marca);
        query.setParameter(3, canal);
        query.setParameter(4, codZona);
        return (ZonaLocal)(query.getSingleResult());
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("ZonaLocal.FindAll");
        return query.getResultList();
    }

}
