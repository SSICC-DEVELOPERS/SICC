package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.TiposCajaEmbalajeLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TiposCajaEmbalajeLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    public TiposCajaEmbalajeLocal create(String valTipoCaja, Double numCapa, Double numCapaMini, String indCubi, Double numPorcSegu, Double numNiveApli, Long numEtiq, Double valAlto, Double valLarg, Double valAnch, Long paisOidPais, Long unmdOidUnidMediCapa, Long unmdOidUnidMediExte) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_TCEM_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        TiposCajaEmbalajeLocal local;
        local = new TiposCajaEmbalajeLocal(oid, valTipoCaja, numCapa, numCapaMini, 
            indCubi, numPorcSegu, numNiveApli, numEtiq, valAlto, valLarg, valAnch, 
            paisOidPais, unmdOidUnidMediCapa, unmdOidUnidMediExte);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(TiposCajaEmbalajeLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(TiposCajaEmbalajeLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public TiposCajaEmbalajeLocal findByPrimaryKey(Long  oid) {
        TiposCajaEmbalajeLocal local = em.find(TiposCajaEmbalajeLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    
    public Collection findAll() {
        Query query=em.createNamedQuery("TiposCajaEmbalajeLocal.FindAll");
        return query.getResultList();
    }

}
