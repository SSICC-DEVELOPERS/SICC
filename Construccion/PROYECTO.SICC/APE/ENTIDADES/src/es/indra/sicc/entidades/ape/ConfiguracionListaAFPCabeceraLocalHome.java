package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.ConfiguracionListaAFPCabeceraLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ConfiguracionListaAFPCabeceraLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    public ConfiguracionListaAFPCabeceraLocal create(Long numAgru, Long ccdiOidConfCentDist,
            Long canaOidCana, Long marcOidMarc) throws MareException {
        
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_LIAC_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        ConfiguracionListaAFPCabeceraLocal local;
        local = new ConfiguracionListaAFPCabeceraLocal(oid, numAgru, ccdiOidConfCentDist, canaOidCana, marcOidMarc);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(ConfiguracionListaAFPCabeceraLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(ConfiguracionListaAFPCabeceraLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public ConfiguracionListaAFPCabeceraLocal findByPrimaryKey(Long  oid) {
        ConfiguracionListaAFPCabeceraLocal local = em.find(ConfiguracionListaAFPCabeceraLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public Collection findAll() {
        Query query=em.createNamedQuery("ConfiguracionListaAFPCabeceraLocal.FindAll");
        return query.getResultList();
    }

}
