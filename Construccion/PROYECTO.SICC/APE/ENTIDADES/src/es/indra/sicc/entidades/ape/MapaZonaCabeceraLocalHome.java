package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.MapaZonaCabeceraLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MapaZonaCabeceraLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    public MapaZonaCabeceraLocal create(Boolean valDefe, Long mcdcOidMapaCentDistCabe) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_MZCA_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        MapaZonaCabeceraLocal local = new MapaZonaCabeceraLocal(oid, valDefe, mcdcOidMapaCentDistCabe);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(MapaZonaCabeceraLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(MapaZonaCabeceraLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public MapaZonaCabeceraLocal findByPrimaryKey(Long  oid) {
        MapaZonaCabeceraLocal local = em.find(MapaZonaCabeceraLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("MapaZonaCabeceraLocal.FindAll");
        return query.getResultList();
    }

}
