package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.PlantillaMonitorLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PlantillaMonitorLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public PlantillaMonitorLocal create(String cod_plan_moni, String des_plan_moni, Long pais_oid_pais)
            throws MareException {
        
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_PLSM_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        PlantillaMonitorLocal local = new PlantillaMonitorLocal(oid, cod_plan_moni, des_plan_moni, pais_oid_pais);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(PlantillaMonitorLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(PlantillaMonitorLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public PlantillaMonitorLocal findByPrimaryKey(Long oid) {
        PlantillaMonitorLocal local = em.find(PlantillaMonitorLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findAll() {
        Query query = em.createNamedQuery("PlantillaMonitorLocal.FindAll");
        return query.getResultList();
    }
}
