package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.ValoresPorDefectoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ValoresPorDefectoLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public ValoresPorDefectoLocal create(Long tspa_oid_tipo_soli_pais, Long atre_oid_atri_espe, Long ind_obli, Long ind_modi)
            throws MareException {
        
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_VDTS_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        ValoresPorDefectoLocal local = new ValoresPorDefectoLocal(oid, tspa_oid_tipo_soli_pais, atre_oid_atri_espe, ind_obli, ind_modi);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(ValoresPorDefectoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(ValoresPorDefectoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public ValoresPorDefectoLocal findByPrimaryKey(Long  oid) {
        ValoresPorDefectoLocal local = em.find(ValoresPorDefectoLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public ValoresPorDefectoLocal findByUK(Long oidAtributoEspecial,Long oidTipoSolicitud) {
        Query query=em.createNamedQuery("ValoresPorDefectoLocal.FindByUK");
        query.setParameter(1, oidAtributoEspecial);
        query.setParameter(2, oidTipoSolicitud);
        return (ValoresPorDefectoLocal)(query.getSingleResult());
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("ValoresPorDefectoLocal.FindAll");
        return query.getResultList();
    }

}
