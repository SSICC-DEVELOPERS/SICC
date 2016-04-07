package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.ReporteFaltantesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;

public class ReporteFaltantesLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public ReporteFaltantesLocal create(Long pais_oid_pais, Long val_lote_repo_falt, Date fec_ejec) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_REFA_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        ReporteFaltantesLocal local = new ReporteFaltantesLocal(oid, pais_oid_pais, val_lote_repo_falt, fec_ejec);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(ReporteFaltantesLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(ReporteFaltantesLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public ReporteFaltantesLocal findByPrimaryKey(Long  oid) {
        ReporteFaltantesLocal local = em.find(ReporteFaltantesLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
	
    public Collection findAll() {
        Query query=em.createNamedQuery("ReporteFaltantesLocal.FindAll");
        return query.getResultList();
    }

}
