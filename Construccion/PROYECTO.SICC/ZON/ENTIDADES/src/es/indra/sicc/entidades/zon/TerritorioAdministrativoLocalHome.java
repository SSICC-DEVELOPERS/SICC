package es.indra.sicc.entidades.zon;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.zon.TerritorioAdministrativoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class TerritorioAdministrativoLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-zon");
    private EntityManager em = emf.createEntityManager();

    public TerritorioAdministrativoLocal create(Long oidPais, Long oidMarca, Long oidCanal,
            Long seccOidSecc, Long terrOidTerr, Long periodoIni) throws MareException {
        
        Long oid = SecuenciadorOID.obtenerSiguienteValor("ZON_ZTAD_SEQ"); 
        final EntityTransaction et = em.getTransaction();
        et.begin();
        TerritorioAdministrativoLocal local = new TerritorioAdministrativoLocal(oid, oidPais, oidMarca, oidCanal, seccOidSecc, terrOidTerr, periodoIni);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public TerritorioAdministrativoLocal create(Long oidPais, Long oidMarca, Long oidCanal, 
            Long seccOidSecc, Long terrOidTerr, Long periodoIni, Long borrado) throws MareException {
        
        Long oid = SecuenciadorOID.obtenerSiguienteValor("ZON_ZTAD_SEQ"); 
        final EntityTransaction et = em.getTransaction();
        et.begin();
        TerritorioAdministrativoLocal local = new TerritorioAdministrativoLocal(oid, oidPais, oidMarca, oidCanal, seccOidSecc, terrOidTerr, periodoIni, borrado);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public TerritorioAdministrativoLocal create(Long oidPais, Long oidMarca, Long oidCanal, 
            Long seccOidSecc, Long terrOidTerr, Long periodoIni, Timestamp fecRtz) throws MareException {
        
        Long oid = SecuenciadorOID.obtenerSiguienteValor("ZON_ZTAD_SEQ"); 
        final EntityTransaction et = em.getTransaction();
        et.begin();
        TerritorioAdministrativoLocal local = new TerritorioAdministrativoLocal(oid, oidPais, oidMarca, oidCanal, seccOidSecc, terrOidTerr, periodoIni, fecRtz);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(TerritorioAdministrativoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(TerritorioAdministrativoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public TerritorioAdministrativoLocal findByPrimaryKey(Long  oid) {
        TerritorioAdministrativoLocal local = em.find(TerritorioAdministrativoLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public Collection findByPaisMarcaCanal(Long oidPais, Long oidMarca, Long oidCanal, Long oidTerritorio) {
        Query query=em.createNamedQuery("TerritorioAdministrativoLocal.FindByPaisMarcaCanal");
        query.setParameter(1, oidPais);
        query.setParameter(2, oidMarca);
        query.setParameter(3, oidCanal);
        query.setParameter(4, oidTerritorio);
        return query.getResultList();
    }

    public Collection findBySeccionTerritorio(Long oidSeccion, Long oidTerritorio) {
        Query query=em.createNamedQuery("TerritorioAdministrativoLocal.FindBySeccionTerritorio");
        query.setParameter(1, oidSeccion);
        query.setParameter(2, oidTerritorio);
        return query.getResultList();
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("TerritorioAdministrativoLocal.FindAll");
        return query.getResultList();
    }

}
