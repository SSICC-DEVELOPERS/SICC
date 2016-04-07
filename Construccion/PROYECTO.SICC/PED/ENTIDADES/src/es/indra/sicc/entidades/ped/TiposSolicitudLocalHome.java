package es.indra.sicc.entidades.ped;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.TiposSolicitudLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TiposSolicitudLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public TiposSolicitudLocal create(String codigo, Long oidTipoCliente, Long oidMarca,
            Long oidAcceso, Long oidClaseSolicitud, Boolean indConsolidado, Boolean indSolNegativa,
            Boolean indDevoluciones, Boolean indAnulacion) throws MareException {
            
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_TSOL_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        TiposSolicitudLocal local = new TiposSolicitudLocal(oid, codigo, oidTipoCliente, oidMarca,
                oidAcceso, oidClaseSolicitud, indConsolidado, indSolNegativa, indDevoluciones, indAnulacion);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(TiposSolicitudLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(TiposSolicitudLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public TiposSolicitudLocal findByPrimaryKey(Long  oid) {
        TiposSolicitudLocal local = em.find(TiposSolicitudLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public Collection findByGrupoSolicitud(Long oid) {
        Query query=em.createNamedQuery("TiposSolicitudLocal.FindByGrupoSolicitud");
        query.setParameter(1, oid);
        return query.getResultList();
    }

    public TiposSolicitudLocal findByUK(String cod) {
        Query query=em.createNamedQuery("TiposSolicitudLocal.FindByUK");
        query.setParameter(1, cod);
        return (TiposSolicitudLocal)(query.getSingleResult());
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("TiposSolicitudLocal.FindAll");
        return query.getResultList();
    }

}
