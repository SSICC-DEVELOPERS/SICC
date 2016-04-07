package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.TipoVinculoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoVinculoLocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public TipoVinculoLocal create(Long pais_oid_pais, String cod_tipo_vinc, Long ind_reco) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_TIVC_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        TipoVinculoLocal local = new TipoVinculoLocal(oid, pais_oid_pais, cod_tipo_vinc, ind_reco);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(TipoVinculoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(TipoVinculoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public TipoVinculoLocal findByPrimaryKey(Long  oid) {
        TipoVinculoLocal local = em.find(TipoVinculoLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public TipoVinculoLocal findByUK(Long oidPais,String codigoTipoVinculo) {
        Query query=em.createNamedQuery("TipoVinculoLocal.FindByUK");
        query.setParameter(1, oidPais);
        query.setParameter(2, codigoTipoVinculo);
        return (TipoVinculoLocal)(query.getSingleResult());
    }
    
    public Collection findAll() {
        Query query = em.createNamedQuery("TipoVinculoLocal.FindAll");
        return query.getResultList();
    }
}
