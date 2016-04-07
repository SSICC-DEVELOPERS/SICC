package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.LotesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;

public class LotesLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public LotesLocal create(Long numLote, Date fecRegi, Long perdOidPeri, Long tspaOidTipoSoliPais) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_LOTE_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        LotesLocal local = new LotesLocal(oid, numLote, fecRegi, perdOidPeri, tspaOidTipoSoliPais);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(LotesLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(LotesLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public LotesLocal findByPrimaryKey(Long  oid) {
        LotesLocal local = em.find(LotesLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public Collection findAll() {
        Query query=em.createNamedQuery("LotesLocal.FindAll");
        return query.getResultList();
    }

}
