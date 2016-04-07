package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.AsignacionProductoAnaquelCabeceraLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class AsignacionProductoAnaquelCabeceraLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    public AsignacionProductoAnaquelCabeceraLocal create(String version, String indActivoFacturacion,
            Long oidPeriodo, Long oidMapaCDCabec, Long oidMapaZonaCabec) throws MareException {
            
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_APAC_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        AsignacionProductoAnaquelCabeceraLocal local;
        local = new AsignacionProductoAnaquelCabeceraLocal(oid, version, indActivoFacturacion,
            oidPeriodo, oidMapaCDCabec, oidMapaZonaCabec);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(AsignacionProductoAnaquelCabeceraLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(AsignacionProductoAnaquelCabeceraLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public AsignacionProductoAnaquelCabeceraLocal findByPrimaryKey(Long oid) {
        AsignacionProductoAnaquelCabeceraLocal local = em.find(AsignacionProductoAnaquelCabeceraLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public Collection findAll() {
        Query query=em.createNamedQuery("AsignacionProductoAnaquelCabeceraLocal.FindAll");
        return query.getResultList();
    }

    public AsignacionProductoAnaquelCabeceraLocal findByUk(Long oidMapaCDCabec, String version, Long oidPeriodo) {
        Query query=em.createNamedQuery("AsignacionProductoAnaquelCabeceraLocal.FindByUk");
        query.setParameter(1, oidMapaCDCabec);
        query.setParameter(2, version);
        query.setParameter(3, oidPeriodo);
        return (AsignacionProductoAnaquelCabeceraLocal)(query.getSingleResult());
    }

    public Collection findByActivoFacturacion() {
        Query query=em.createNamedQuery("AsignacionProductoAnaquelCabeceraLocal.FindByActivoFacturacion");
        return query.getResultList();
    }

    public Collection findByMapaCDPeriodoActivoFacturacion(Long oidMapaCD, Long oidPeriodo) {
        Query query=em.createNamedQuery("AsignacionProductoAnaquelCabeceraLocal.FindByMapaCDPeriodoActivoFacturacion");
        query.setParameter(1, oidMapaCD);
        query.setParameter(2, oidPeriodo);
        return query.getResultList();
    }

}
