package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.MapaCentroDistribucionDetalleLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MapaCentroDistribucionDetalleLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    public MapaCentroDistribucionDetalleLocal create(String codAnaquel, Long capacidadAnaquel,
            Long oidMapaCDCabec, Long oidSublinea, Boolean expandido) throws MareException {
        
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_MCDD_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        MapaCentroDistribucionDetalleLocal local;
        local = new MapaCentroDistribucionDetalleLocal(oid, codAnaquel, capacidadAnaquel, oidMapaCDCabec, oidSublinea, expandido);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(MapaCentroDistribucionDetalleLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(MapaCentroDistribucionDetalleLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public MapaCentroDistribucionDetalleLocal findByPrimaryKey(Long  oid) {
        MapaCentroDistribucionDetalleLocal local = em.find(MapaCentroDistribucionDetalleLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public Collection findAll() {
        Query query=em.createNamedQuery("MapaCentroDistribucionDetalleLocal.FindAll");
        return query.getResultList();
    }

    public MapaCentroDistribucionDetalleLocal findByUK(String numeroAnaquel, Long mapaCentroDistribucion) {
        Query query=em.createNamedQuery("MapaCentroDistribucionDetalleLocal.FindByUK");
        query.setParameter(1, numeroAnaquel);
        query.setParameter(2, mapaCentroDistribucion);
        return (MapaCentroDistribucionDetalleLocal)(query.getSingleResult());
    }

}
