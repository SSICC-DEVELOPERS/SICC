package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.PlantillaMonitorDetalleLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PlantillaMonitorDetalleLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public PlantillaMonitorDetalleLocal create(Long num_secu, Long tspa_oid_tipo_soli_pais,
            Long zzon_oid_zona, Long plsm_oid_plan_moni, Long grpr_oid_grup_proc) throws MareException {
            
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_PLS2_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        PlantillaMonitorDetalleLocal local = new PlantillaMonitorDetalleLocal(oid, num_secu, tspa_oid_tipo_soli_pais, zzon_oid_zona, plsm_oid_plan_moni, grpr_oid_grup_proc);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(PlantillaMonitorDetalleLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(PlantillaMonitorDetalleLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public PlantillaMonitorDetalleLocal findByPrimaryKey(Long  oid) {
        PlantillaMonitorDetalleLocal local = em.find(PlantillaMonitorDetalleLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findByPlantillaMonitor(Long oidPlantillaMonitor) {
        Query query = em.createNamedQuery("PlantillaMonitorDetalleLocal.FindByPlantillaMonitor");
        query.setParameter(1, oidPlantillaMonitor);
        return query.getResultList();
    }

    public Collection findAll() {
        Query query = em.createNamedQuery("PlantillaMonitorDetalleLocal.FindAll");
        return query.getResultList();
    }

}
