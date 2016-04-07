package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.UsuarioAlarmaLineaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class UsuarioAlarmaLineaLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();
    
    public UsuarioAlarmaLineaLocal create(String valMail, Long liarOidLineArma) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_UALI_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        UsuarioAlarmaLineaLocal local = new UsuarioAlarmaLineaLocal(oid, valMail, liarOidLineArma);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(UsuarioAlarmaLineaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(UsuarioAlarmaLineaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public UsuarioAlarmaLineaLocal findByPrimaryKey(Long  oid) {
        UsuarioAlarmaLineaLocal local = em.find(UsuarioAlarmaLineaLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    
    public Collection findAll() {
        Query query=em.createNamedQuery("UsuarioAlarmaLineaLocal.FindAll");
        return query.getResultList();
    }
    
    public Collection findByLineaArmado(Long liarOidLineArma) {
        Query query=em.createNamedQuery("UsuarioAlarmaLineaLocal.FindByLineaArmado");
        query.setParameter(1, liarOidLineArma);
        return query.getResultList();
    }

}
