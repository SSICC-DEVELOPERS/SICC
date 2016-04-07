package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.SolicitudAcumuladoImpuestosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class SolicitudAcumuladoImpuestosLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public SolicitudAcumuladoImpuestosLocal create(Long oidTasaImpu, Long oidSolCabe, 
            BigDecimal baseImponiblePosLocal, BigDecimal totalPreciosPosLocal, BigDecimal totalDescuentoCabLocal, 
            BigDecimal baseImponibleDescuentoCabLocal, BigDecimal baseImponiblePrecioContableLocal,
            BigDecimal baseImponibleFleteLocal, BigDecimal totalBaseImponibleLocal, BigDecimal totalImpuestosLocal,
            BigDecimal baseImponiblePosDocumento, BigDecimal totalImporteLocal, BigDecimal totalPreciosPosDocumento,
            BigDecimal totalDescuentoCabDocumento, BigDecimal baseImponibleDescuentoCabDocumento,
            BigDecimal baseImponiblePrecioContableDocumento, BigDecimal baseImponibleFleteDocumento, 
            BigDecimal totalBaseImponibleDocumento, BigDecimal totalImpuestosDocumento, BigDecimal totalImporteDocumento)
            throws MareException {
        
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_PSAI_SEQ"); 
        final EntityTransaction et = em.getTransaction();
        et.begin();
        SolicitudAcumuladoImpuestosLocal local = new SolicitudAcumuladoImpuestosLocal(oid, oidTasaImpu, oidSolCabe,
            baseImponiblePosLocal, totalPreciosPosLocal, totalDescuentoCabLocal, baseImponibleDescuentoCabLocal, 
            baseImponiblePrecioContableLocal, baseImponibleFleteLocal, totalBaseImponibleLocal, totalImpuestosLocal, 
            baseImponiblePosDocumento, totalImporteLocal, totalPreciosPosDocumento, totalDescuentoCabDocumento, 
            baseImponibleDescuentoCabDocumento, baseImponiblePrecioContableDocumento, baseImponibleFleteDocumento,
            totalBaseImponibleDocumento, totalImpuestosDocumento, totalImporteDocumento);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(SolicitudAcumuladoImpuestosLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(SolicitudAcumuladoImpuestosLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public SolicitudAcumuladoImpuestosLocal findByPrimaryKey(Long  oidAcum) {
        SolicitudAcumuladoImpuestosLocal local = em.find(SolicitudAcumuladoImpuestosLocal.class, oidAcum);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public SolicitudAcumuladoImpuestosLocal findByUK(Long oidSolCabe,Long oidTasaImpu) {
        Query query=em.createNamedQuery("SolicitudAcumuladoImpuestosLocal.FindByUK");
        query.setParameter(1, oidSolCabe);
        query.setParameter(2, oidTasaImpu);
        return (SolicitudAcumuladoImpuestosLocal)(query.getSingleResult());
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("SolicitudAcumuladoImpuestosLocal.FindAll");
        return query.getResultList();
    }

}
