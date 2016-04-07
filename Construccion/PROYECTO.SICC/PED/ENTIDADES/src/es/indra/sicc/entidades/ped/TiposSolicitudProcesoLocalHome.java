package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.TiposSolicitudProcesoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TiposSolicitudProcesoLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public TiposSolicitudProcesoLocal create(Long tspa_oid_tipo_soli_pais, Boolean ind_prod, Long oper_oid_oper)
            throws MareException {
        
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_TPPR_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        TiposSolicitudProcesoLocal local = new TiposSolicitudProcesoLocal(oid, tspa_oid_tipo_soli_pais, ind_prod, oper_oid_oper);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(TiposSolicitudProcesoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(TiposSolicitudProcesoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public TiposSolicitudProcesoLocal findByPrimaryKey(Long  oid) {
        TiposSolicitudProcesoLocal local = em.find(TiposSolicitudProcesoLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public TiposSolicitudProcesoLocal findByUKProceso(Long operacion,Long tipoSolicitudPais) {
        Query query=em.createNamedQuery("TiposSolicitudProcesoLocal.FindByUKProceso");
        query.setParameter(1, operacion);
        query.setParameter(2, tipoSolicitudPais);
        return (TiposSolicitudProcesoLocal)(query.getSingleResult());
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("TiposSolicitudProcesoLocal.FindAll");
        return query.getResultList();
    }

}
