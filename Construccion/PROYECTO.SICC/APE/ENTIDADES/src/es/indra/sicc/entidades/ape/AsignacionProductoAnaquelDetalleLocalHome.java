package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.AsignacionProductoAnaquelDetalleLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class AsignacionProductoAnaquelDetalleLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    public AsignacionProductoAnaquelDetalleLocal create(Long oidAsigProdAnaqCabe, Long oidProducto, Long procedencia) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_APAN_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        AsignacionProductoAnaquelDetalleLocal local = new AsignacionProductoAnaquelDetalleLocal(oid, oidAsigProdAnaqCabe, oidProducto, procedencia);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(AsignacionProductoAnaquelDetalleLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(AsignacionProductoAnaquelDetalleLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public AsignacionProductoAnaquelDetalleLocal findByPrimaryKey(Long  oid) {
        AsignacionProductoAnaquelDetalleLocal local = em.find(AsignacionProductoAnaquelDetalleLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("AsignacionProductoAnaquelDetalleLocal.FindAll");
        return query.getResultList();
    }

    public AsignacionProductoAnaquelDetalleLocal findByUK(Long oidAsignProdAnaqCabe, Long oidMapaCentDistDeta, Long oidProducto) {
        Query query=em.createNamedQuery("AsignacionProductoAnaquelDetalleLocal.FindByUK");
        query.setParameter(1, oidAsignProdAnaqCabe);
        query.setParameter(2, oidMapaCentDistDeta);
        query.setParameter(3, oidProducto);
        return (AsignacionProductoAnaquelDetalleLocal)(query.getSingleResult());
    }

    public Collection findByCabeceraBalanceo(Long asignacionProductoAnaquelCabecera, Long procedencia) {
        Query query=em.createNamedQuery("AsignacionProductoAnaquelDetalleLocal.FindByCabeceraBalanceo");
        query.setParameter(1, asignacionProductoAnaquelCabecera);
        query.setParameter(2, procedencia);
        return query.getResultList();
    }

}
