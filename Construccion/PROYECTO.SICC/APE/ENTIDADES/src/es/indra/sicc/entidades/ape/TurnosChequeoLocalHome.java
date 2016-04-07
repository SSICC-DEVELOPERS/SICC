package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.TurnosChequeoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class TurnosChequeoLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();
    
    public TurnosChequeoLocal create(Integer numTurno, Timestamp horaInicioTurno,
                Timestamp horaFinTurno, Long oidConfiguracionCD) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_TUCH_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        TurnosChequeoLocal local = new TurnosChequeoLocal(oid, numTurno, horaInicioTurno,
                horaFinTurno, oidConfiguracionCD);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(TurnosChequeoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(TurnosChequeoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public TurnosChequeoLocal findByPrimaryKey(Long  oid) {
        TurnosChequeoLocal local = em.find(TurnosChequeoLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    
    public Collection findAll() {
        Query query=em.createNamedQuery("TurnosChequeoLocal.FindAll");
        return query.getResultList();
    }
    
    public TurnosChequeoLocal findByUK(Long oidConfiguracionCD, Integer numTurno) {
        Query query=em.createNamedQuery("TurnosChequeoLocal.FindByUK");
        query.setParameter(1, oidConfiguracionCD);
        query.setParameter(2, numTurno);
        return (TurnosChequeoLocal)(query.getSingleResult());
    }

}
