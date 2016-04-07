package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.MapaCentroDistribucionCabeceraLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MapaCentroDistribucionCabeceraLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    public MapaCentroDistribucionCabeceraLocal create(Long codigoMapa, Long oidConfiguracionCD)
            throws MareException {
            
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_MCDC_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        MapaCentroDistribucionCabeceraLocal local;
        local = new MapaCentroDistribucionCabeceraLocal(oid, codigoMapa, oidConfiguracionCD);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(MapaCentroDistribucionCabeceraLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(MapaCentroDistribucionCabeceraLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public MapaCentroDistribucionCabeceraLocal findByPrimaryKey(Long  oid) {
        MapaCentroDistribucionCabeceraLocal local = em.find(MapaCentroDistribucionCabeceraLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public Collection findAll() {
        Query query=em.createNamedQuery("MapaCentroDistribucionCabeceraLocal.FindAll");
        return query.getResultList();
    }

}
