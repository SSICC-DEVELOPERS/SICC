package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.ClaseSolicitudLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ClaseSolicitudLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public ClaseSolicitudLocal create(String cod_clas_soli, Boolean ind_orde_comp) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_CLSO_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        ClaseSolicitudLocal local = new ClaseSolicitudLocal(oid, cod_clas_soli, ind_orde_comp);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(ClaseSolicitudLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(ClaseSolicitudLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public ClaseSolicitudLocal findByPrimaryKey(Long  oid) {
        ClaseSolicitudLocal local = em.find(ClaseSolicitudLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public ClaseSolicitudLocal findByUK(String codigoClaseSolicitud) {
        Query query=em.createNamedQuery("ClaseSolicitudLocal.FindByUK");
        query.setParameter(1, codigoClaseSolicitud);
        return (ClaseSolicitudLocal)(query.getSingleResult());
    }

    public Collection findByIndOrdenCompra(Boolean indOrdenCompra) {
        Query query=em.createNamedQuery("ClaseSolicitudLocal.FindByIndOrdenCompra");
        query.setParameter(1, indOrdenCompra);
        return query.getResultList();
    }

}
