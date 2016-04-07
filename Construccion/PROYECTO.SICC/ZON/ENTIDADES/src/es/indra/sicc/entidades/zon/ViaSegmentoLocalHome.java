package es.indra.sicc.entidades.zon;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.zon.ViaSegmentoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class ViaSegmentoLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-zon");
    private EntityManager em = emf.createEntityManager();

    public ViaSegmentoLocal create(Long oidTerritorio, Long oidVia, Integer numViaSegmento, Timestamp fechaReestructuracion)
            throws MareException {
        
        Long oid = SecuenciadorOID.obtenerSiguienteValor("ZON_ZVSG_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        ViaSegmentoLocal local = new ViaSegmentoLocal(oid, oidTerritorio, oidVia, numViaSegmento, fechaReestructuracion);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(ViaSegmentoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(ViaSegmentoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public ViaSegmentoLocal findByPrimaryKey(Long  oid) {
        ViaSegmentoLocal local = em.find(ViaSegmentoLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public Collection findByViaSegmento(Long via, Integer segmento) {
        Query query=em.createNamedQuery("ViaSegmentoLocal.FindByViaSegmento");
        query.setParameter(1, via);
        query.setParameter(2, segmento);
        return query.getResultList();
    }

    public Collection findByVia(Long via) {
        Query query=em.createNamedQuery("ViaSegmentoLocal.FindByVia");
        query.setParameter(1, via);
        return query.getResultList();
    }

    public Collection findByTerritorioViaSegmento(Long oidTerritorio, Long oidVia, Integer segmento) {
        Query query=em.createNamedQuery("ViaSegmentoLocal.FindByTerritorioViaSegmento");
        query.setParameter(1, oidTerritorio);
        query.setParameter(2, oidVia);
        query.setParameter(3, segmento);
        return query.getResultList();
    }
    
     public Collection findByTerritorioVia(Long oidTerritorio, Long oidVia) {
         Query query=em.createNamedQuery("ViaSegmentoLocal.FindByTerritorioVia");
         query.setParameter(1, oidTerritorio);
         query.setParameter(2, oidVia);
         return query.getResultList();
     }
     
    public Collection findByTerritorioVia(Long oidTerritorio, Long oidVia, Integer numInicio, Integer numFinal) {
        Query query=em.createNamedQuery("ViaSegmentoLocal.FindByTerritorioVia");
        query.setParameter(1, oidTerritorio);
        query.setParameter(2, oidVia);
        query.setParameter(3, numInicio);
        query.setParameter(4, numFinal);
        return query.getResultList();
    }
    
    public Collection findByViaActivos(Long oidVia) {
        Query query=em.createNamedQuery("ViaSegmentoLocal.FindByViaActivos");
        query.setParameter(1, oidVia);
        return query.getResultList();
    }
    
    public Collection findAll() {
        Query query=em.createNamedQuery("ViaSegmentoLocal.FindAll");
        return query.getResultList();
    }
    

}
