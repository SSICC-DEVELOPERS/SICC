package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.EtiquetasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EtiquetasLocalHome {


    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    public EtiquetasLocal create(Long numEtiqueta, Long numCaja, Long numTotalCajas,
            Long oidPais, Long oidListaPicado, Long oidCentroDist) throws MareException {
            
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_ETIQ_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        EtiquetasLocal local;
        local = new EtiquetasLocal(oid, numEtiqueta, numCaja, numTotalCajas, oidPais, oidListaPicado, oidCentroDist);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(EtiquetasLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(EtiquetasLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public EtiquetasLocal findByPrimaryKey(Long  oid) {
        EtiquetasLocal local = em.find(EtiquetasLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("EtiquetasLocal.FindAll");
        return query.getResultList();
    }

    public EtiquetasLocal findByListaPicCabecCaja(Long oidListPicCabec, Long numeroCaja) {
        Query query=em.createNamedQuery("EtiquetasLocal.FindByListaPicCabecCaja");
        query.setParameter(1, oidListPicCabec);
        query.setParameter(2, numeroCaja);
        return (EtiquetasLocal)(query.getSingleResult());
    }

}
