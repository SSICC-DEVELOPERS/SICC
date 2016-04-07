package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.EstadisticasDigitacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class EstadisticasDigitacionLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public EstadisticasDigitacionLocal create(Long perd_oid_peri, Long tspa_oid_tipo_soli_pais, 
            Long proc_oid_proc, Timestamp fec_inic_sesi, String val_usua, Timestamp fec_fin_sesi) throws MareException {
            
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_ESDI_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        EstadisticasDigitacionLocal local = new EstadisticasDigitacionLocal(oid, perd_oid_peri, tspa_oid_tipo_soli_pais, proc_oid_proc, fec_inic_sesi, val_usua, fec_fin_sesi);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(EstadisticasDigitacionLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(EstadisticasDigitacionLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public EstadisticasDigitacionLocal findByPrimaryKey(Long  oid) {
        EstadisticasDigitacionLocal local = em.find(EstadisticasDigitacionLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findAll() {
        Query query = em.createNamedQuery("EstadisticasDigitacionLocal.FindAll");
        return query.getResultList();
    }
}
