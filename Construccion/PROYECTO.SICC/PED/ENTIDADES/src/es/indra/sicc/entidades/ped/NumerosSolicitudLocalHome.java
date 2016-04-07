package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.NumerosSolicitudLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class NumerosSolicitudLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public NumerosSolicitudLocal create(String anyo, Integer ultimoNumSolicitud, String operacion, 
            String codPais, String codCanal,String codAcceso, String codSubacceso) throws MareException {
        
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_NUSO_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        NumerosSolicitudLocal local = new NumerosSolicitudLocal(oid, anyo, ultimoNumSolicitud, operacion, codPais, codCanal, codAcceso, codSubacceso);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(NumerosSolicitudLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(NumerosSolicitudLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public NumerosSolicitudLocal findByPrimaryKey(Long  oid) {
        NumerosSolicitudLocal local = em.find(NumerosSolicitudLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public NumerosSolicitudLocal findByUK(String codPais,String codCanal,String codAcceso,
            String codSubacceso,String operacion,String anyo) {
        
        Query query=em.createNamedQuery("NumerosSolicitudLocal.FindByUK");
        query.setParameter(1, codPais);
        query.setParameter(2, codCanal);
        query.setParameter(3, codAcceso);
        query.setParameter(4, codSubacceso);
        query.setParameter(5, operacion);
        query.setParameter(6, anyo);
        return (NumerosSolicitudLocal)(query.getSingleResult());
    }
    
    public Collection findAll() {
        Query query = em.createNamedQuery("NumerosSolicitudLocal.FindAll");
        return query.getResultList();
    }
}
