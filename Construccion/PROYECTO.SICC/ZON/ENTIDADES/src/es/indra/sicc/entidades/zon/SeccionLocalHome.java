package es.indra.sicc.entidades.zon;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.zon.SeccionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class SeccionLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-zon");
    private EntityManager em = emf.createEntityManager();

    public SeccionLocal create(String cod_secc, Long zzon_oid_zona, Long oidPeriodoInicio)
            throws MareException {
        
        Long oid = SecuenciadorOID.obtenerSiguienteValor("ZON_ZSCC_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        SeccionLocal local = new SeccionLocal(oid, cod_secc, zzon_oid_zona, oidPeriodoInicio);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(SeccionLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(SeccionLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public SeccionLocal findByPrimaryKey(Long  oid) {
        SeccionLocal local = em.find(SeccionLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findByCodigo(Long pais, Long marca, Long canal, Long oidZona, String codSeccion) {
        Query query=em.createNamedQuery("SeccionLocal.FindByCodigo");
        query.setParameter(1, pais);
        query.setParameter(2, marca);
        query.setParameter(3, canal);
        query.setParameter(4, oidZona);
        query.setParameter(5, codSeccion);
        return query.getResultList();
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("SeccionLocal.FindAll");
        return query.getResultList();
    }
}
