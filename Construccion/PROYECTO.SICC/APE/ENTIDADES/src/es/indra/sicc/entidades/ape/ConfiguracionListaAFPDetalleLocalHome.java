package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.ConfiguracionListaAFPDetalleLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ConfiguracionListaAFPDetalleLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    public ConfiguracionListaAFPDetalleLocal create(Long numLine, Long liacOidConfLafpCabe,
            Long zorgOidRegi, Long oidZona, Long oidSeccion) throws MareException {
        
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_LIAD_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        ConfiguracionListaAFPDetalleLocal local;
        local = new ConfiguracionListaAFPDetalleLocal(oid, numLine, liacOidConfLafpCabe, zorgOidRegi, oidZona, oidSeccion);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(ConfiguracionListaAFPDetalleLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(ConfiguracionListaAFPDetalleLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public ConfiguracionListaAFPDetalleLocal findByPrimaryKey(Long  oid) {
        ConfiguracionListaAFPDetalleLocal local = em.find(ConfiguracionListaAFPDetalleLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public Collection findAll() {
        Query query=em.createNamedQuery("ConfiguracionListaAFPDetalleLocal.FindAll");
        return query.getResultList();
    }

}
