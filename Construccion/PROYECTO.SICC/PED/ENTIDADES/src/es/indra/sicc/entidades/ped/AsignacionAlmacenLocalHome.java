package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.AsignacionAlmacenLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class AsignacionAlmacenLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public AsignacionAlmacenLocal create(Long sbac_oid_sbac, Long marc_oid_marc, Long almc_oid_alma, Long pais_oid_pais)
            throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_ALMA_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        AsignacionAlmacenLocal local = new AsignacionAlmacenLocal(oid, sbac_oid_sbac, marc_oid_marc, almc_oid_alma, pais_oid_pais);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(AsignacionAlmacenLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(AsignacionAlmacenLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public AsignacionAlmacenLocal findByPrimaryKey(Long  oid) {
        AsignacionAlmacenLocal local = em.find(AsignacionAlmacenLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public AsignacionAlmacenLocal findByUK(Long pais,Long marca,Long subacceso) {
        Query query=em.createNamedQuery("AsignacionAlmacenLocal.FindByUK");
        query.setParameter(1, pais);
        query.setParameter(2, marca);
        query.setParameter(3, subacceso);
        return (AsignacionAlmacenLocal)(query.getSingleResult());
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("AsignacionAlmacenLocal.FindAll");
        return query.getResultList();
    }

}
