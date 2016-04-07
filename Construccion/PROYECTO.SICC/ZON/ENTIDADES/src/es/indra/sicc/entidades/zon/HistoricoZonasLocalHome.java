package es.indra.sicc.entidades.zon;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.zon.HistoricoZonasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class HistoricoZonasLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-zon");
    private EntityManager em = emf.createEntityManager();

    public HistoricoZonasLocal create(String valTipoModi, String valUnidAdm1,
            String valUnidAdm2, Timestamp fecCrea, Long perdOidPeriActi) throws MareException {
                
        Long oid = SecuenciadorOID.obtenerSiguienteValor("ZON_HZON_SEQ");                                                    
        final EntityTransaction et = em.getTransaction();
        et.begin();
        HistoricoZonasLocal local = new HistoricoZonasLocal(oid, valTipoModi, valUnidAdm1, valUnidAdm2, fecCrea, perdOidPeriActi);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(HistoricoZonasLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(HistoricoZonasLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public HistoricoZonasLocal findByPrimaryKey(Long  oid) {
        HistoricoZonasLocal local = em.find(HistoricoZonasLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public Collection findAll() {
        Query query=em.createNamedQuery("HistoricoZonasLocal.FindAll");
        return query.getResultList();
    }

}
