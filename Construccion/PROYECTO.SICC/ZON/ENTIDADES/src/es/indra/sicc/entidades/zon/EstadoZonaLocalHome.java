package es.indra.sicc.entidades.zon;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.zon.EstadoZonaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EstadoZonaLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-zon");
    private EntityManager em = emf.createEntityManager();

    public EstadoZonaLocal create(String cod_esta_zona, Long pais_oid_pais, Long marc_oid_marc)
            throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("ZON_ESZO_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        EstadoZonaLocal local = new EstadoZonaLocal(oid, cod_esta_zona, pais_oid_pais, marc_oid_marc);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(EstadoZonaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(EstadoZonaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public EstadoZonaLocal findByPrimaryKey(Long  oid) {
        EstadoZonaLocal local = em.find(EstadoZonaLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public EstadoZonaLocal findByUK(Long pais, Long marca, String codigo) {
        Query query=em.createNamedQuery("EstadoZonaLocal.FindByUK");
        query.setParameter(1, pais);
        query.setParameter(2, marca);
        query.setParameter(3, codigo);
        return (EstadoZonaLocal)(query.getSingleResult());
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("EstadoZonaLocal.FindAll");
        return query.getResultList();
    }

}
