package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.LevantamientoChequeoCabeceraLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;

public class LevantamientoChequeoCabeceraLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    public LevantamientoChequeoCabeceraLocal create(Date fechaHora, Long numeroConsolidado, 
            Long indEvaluacionReclamo, Long indCapturaManual, Long indPrimerPedido, Long oidRegion,
            Long oidSeccion, Long oidZona, Long oidPais, String usuario) throws MareException {
            
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_LECC_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        LevantamientoChequeoCabeceraLocal local;
        local = new LevantamientoChequeoCabeceraLocal(oid, fechaHora, numeroConsolidado, indEvaluacionReclamo,
            indCapturaManual, indPrimerPedido, oidRegion, oidSeccion, oidZona, oidPais, usuario);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(LevantamientoChequeoCabeceraLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(LevantamientoChequeoCabeceraLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public LevantamientoChequeoCabeceraLocal findByPrimaryKey(Long  oid) {
        LevantamientoChequeoCabeceraLocal local = em.find(LevantamientoChequeoCabeceraLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("LevantamientoChequeoCabeceraLocal.FindAll");
        return query.getResultList();
    }

}
