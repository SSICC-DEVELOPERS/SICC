package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.SecuenciaTipificacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class SecuenciaTipificacionLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public SecuenciaTipificacionLocal create(Long num_orde, Long pais_oid_pais, Long ticl_oid_tipo_clie) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_SETI_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        SecuenciaTipificacionLocal local = new SecuenciaTipificacionLocal(oid, num_orde, pais_oid_pais, ticl_oid_tipo_clie);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(SecuenciaTipificacionLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(SecuenciaTipificacionLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public SecuenciaTipificacionLocal findByPrimaryKey(Long  oid) {
        SecuenciaTipificacionLocal local = em.find(SecuenciaTipificacionLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findByPais(Long oidPais) {
        Query query=em.createNamedQuery("SecuenciaTipificacionLocal.FindByPais");
        query.setParameter(1, oidPais);
        return query.getResultList();
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("SecuenciaTipificacionLocal.FindAll");
        return query.getResultList();
    }

}
