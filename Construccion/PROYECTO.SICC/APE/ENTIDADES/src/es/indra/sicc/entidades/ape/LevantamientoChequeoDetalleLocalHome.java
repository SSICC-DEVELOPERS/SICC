package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.LevantamientoChequeoDetalleLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;

public class LevantamientoChequeoDetalleLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    public LevantamientoChequeoDetalleLocal create(Date fechaHoraSistema,
            Long oidLevantaChequCabecera, Long oidListaPicadoCabecera) throws MareException {
            
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_LECD_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        LevantamientoChequeoDetalleLocal local;
        local = new LevantamientoChequeoDetalleLocal(oid, fechaHoraSistema,
            oidLevantaChequCabecera, oidListaPicadoCabecera);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(LevantamientoChequeoDetalleLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(LevantamientoChequeoDetalleLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public LevantamientoChequeoDetalleLocal findByPrimaryKey(Long  oid) {
        LevantamientoChequeoDetalleLocal local = em.find(LevantamientoChequeoDetalleLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public Collection findAll() {
        Query query=em.createNamedQuery("LevantamientoChequeoDetalleLocal.FindAll");
        return query.getResultList();
    }

}
