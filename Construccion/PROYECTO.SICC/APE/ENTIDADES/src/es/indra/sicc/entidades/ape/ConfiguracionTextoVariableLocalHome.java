package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.ConfiguracionTextoVariableLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ConfiguracionTextoVariableLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    /**
     * CHANGELOG
     * ---------
     * dmorello, 08/01/2009 - Incidencia migracion APE-015
     *     Se reciben y setean los datos subtipo, tipo clasif. y clasif.
     */
    public ConfiguracionTextoVariableLocal create(String valTextVari, Long paisOidPais,
            Long ticlOidTipoClie, Long sbtiOidSubtClie, Long tcclOidTipoClas, Long clasOidClas)
            throws MareException {
            
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_CTVA_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        ConfiguracionTextoVariableLocal local;
        local = new ConfiguracionTextoVariableLocal(oid, valTextVari, paisOidPais, ticlOidTipoClie, 
                sbtiOidSubtClie, tcclOidTipoClas, clasOidClas);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(ConfiguracionTextoVariableLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(ConfiguracionTextoVariableLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public ConfiguracionTextoVariableLocal findByPrimaryKey(Long  oid) {
        ConfiguracionTextoVariableLocal local = em.find(ConfiguracionTextoVariableLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("ConfiguracionTextoVariableLocal.FindAll");
        return query.getResultList();
    }

}
