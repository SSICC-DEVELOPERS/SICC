package es.indra.sicc.entidades.zon;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.zon.ViaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ViaLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-zon");
    private EntityManager em = emf.createEntityManager();

    public ViaLocal create(Boolean activo, Long oidPais, String nombre, Integer secuencia)
            throws MareException {
        
        Long oid = SecuenciadorOID.obtenerSiguienteValor("ZON_ZVIA_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        ViaLocal local = new ViaLocal(oid, activo, oidPais, nombre, secuencia);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(ViaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(ViaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public ViaLocal findByPrimaryKey(Long  oid) {
        ViaLocal local = em.find(ViaLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findByPaisNombreTipoViaActivas(String nombre, Long oidTipoVia, Long oidPais, Boolean activa) {
        Query query=em.createNamedQuery("ViaLocal.FindByPaisNombreTipoViaActivas");
        query.setParameter(1, nombre);
        query.setParameter(2, oidTipoVia);
        query.setParameter(3, oidPais);
        query.setParameter(4, activa);
        return query.getResultList();
    }

    public Collection findByPaisNombreTipoVia(String nombre, Long oidTipoVia, Long oidPais) {
        Query query=em.createNamedQuery("ViaLocal.FindByPaisNombreTipoVia");
        query.setParameter(1, nombre);
        query.setParameter(2, oidTipoVia);
        query.setParameter(3, oidPais);
        return query.getResultList();
    }

    public ViaLocal findByPaisSecuencial(Long pais, Integer secuencial) {
        Query query=em.createNamedQuery("ViaLocal.FindByPaisSecuencial");
        query.setParameter(1, pais);
        query.setParameter(2, secuencial);
        return (ViaLocal)(query.getSingleResult());
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("ViaLocal.FindAll");
        return query.getResultList();
    }

}
