package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.FactoresConversionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class FactoresConversionLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    public FactoresConversionLocal create(BigDecimal factorConversion, Long magnitud,
            Long origen, Long destino) throws MareException {
            
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_FACO_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        FactoresConversionLocal local = new FactoresConversionLocal(oid, factorConversion, magnitud, origen, destino);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(FactoresConversionLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(FactoresConversionLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public FactoresConversionLocal findByPrimaryKey(Long  oid) {
        FactoresConversionLocal local = em.find(FactoresConversionLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("FactoresConversionLocal.FindAll");
        return query.getResultList();
    }

}
