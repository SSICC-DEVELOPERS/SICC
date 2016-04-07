package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.TipoSolicitudLineaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoSolicitudLineaLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    public TipoSolicitudLineaLocal create(Long tspaOidTipoSoliPais, Long liarOidLineArma) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_TSLI_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        TipoSolicitudLineaLocal local = new TipoSolicitudLineaLocal(oid, tspaOidTipoSoliPais, liarOidLineArma);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(TipoSolicitudLineaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(TipoSolicitudLineaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public TipoSolicitudLineaLocal findByPrimaryKey(Long  oid) {
        TipoSolicitudLineaLocal local = em.find(TipoSolicitudLineaLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public Collection findAll() {
        Query query=em.createNamedQuery("TipoSolicitudLineaLocal.FindAll");
        return query.getResultList();
    }

}
