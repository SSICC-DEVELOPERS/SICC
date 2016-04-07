package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.FleteLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class FleteLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public FleteLocal create(Long cana_oid_cana, Long tids_oid_tipo_desp, Long marc_oid_marc, Long tipoCliente)
            throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_FLET_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        FleteLocal local = new FleteLocal(oid, cana_oid_cana, tids_oid_tipo_desp, marc_oid_marc, tipoCliente);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(FleteLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(FleteLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public FleteLocal findByPrimaryKey(Long  oid) {
        FleteLocal local = em.find(FleteLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findAll() {
        Query query = em.createNamedQuery("FleteLocal.FindAll");
        return query.getResultList();
    }
}
