package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.MapaZonaDetalleLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MapaZonaDetalleLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    public MapaZonaDetalleLocal create(Long numIdzo, Long numBahiDesd, Long numBahiHast,
            Long sbarOidSublArma, Long mzcaOidMapaZonaCabe) throws MareException {

        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_MZCD_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        MapaZonaDetalleLocal local = new MapaZonaDetalleLocal(oid, numIdzo, numBahiDesd, numBahiHast, sbarOidSublArma, mzcaOidMapaZonaCabe);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(MapaZonaDetalleLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(MapaZonaDetalleLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public MapaZonaDetalleLocal findByPrimaryKey(Long  oid) {
        MapaZonaDetalleLocal local = em.find(MapaZonaDetalleLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("MapaZonaDetalleLocal.FindAll");
        return query.getResultList();
    }

}
