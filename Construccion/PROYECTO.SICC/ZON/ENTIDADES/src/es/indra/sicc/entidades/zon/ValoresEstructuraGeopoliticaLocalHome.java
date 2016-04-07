package es.indra.sicc.entidades.zon;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.zon.ValoresEstructuraGeopoliticaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class ValoresEstructuraGeopoliticaLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-zon");
    private EntityManager em = emf.createEntityManager();

    public ValoresEstructuraGeopoliticaLocal create(String ubigeo, String nse1, String nse2,
            String desc, Long subestructura, String cp, Long oidPais, Long oidEG) throws MareException {
        
        Long oid = SecuenciadorOID.obtenerSiguienteValor("ZON_VEPO_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        ValoresEstructuraGeopoliticaLocal local = new ValoresEstructuraGeopoliticaLocal(oid, ubigeo, nse1, nse2, desc, subestructura, cp, oidPais, oidEG);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public ValoresEstructuraGeopoliticaLocal create(Long oid, Long cod_unio_geog, Long egeo_oid_estr_geop,
            Long pais_oid_pais, Timestamp fec_actu, Long sgeo_oid_sube_geop) throws MareException {
        
        final EntityTransaction et = em.getTransaction();
        et.begin();
        ValoresEstructuraGeopoliticaLocal local = new ValoresEstructuraGeopoliticaLocal(oid, cod_unio_geog, egeo_oid_estr_geop, pais_oid_pais, fec_actu, sgeo_oid_sube_geop);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(ValoresEstructuraGeopoliticaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(ValoresEstructuraGeopoliticaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public ValoresEstructuraGeopoliticaLocal findByPrimaryKey(Long  oid) {
        ValoresEstructuraGeopoliticaLocal local = em.find(ValoresEstructuraGeopoliticaLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findByUbigeo(String ubigeoOrden1, String ubigeoOrden2,
            String ubigeoOrden3, String ubigeoOrden4, String ubigeoOrden5, String ubigeoOrden6,
            String ubigeoOrden7, String ubigeoOrden8, String ubigeoOrden9, Long oidPais) {
            
        Query query=em.createNamedQuery("ValoresEstructuraGeopoliticaLocal.FindByUbigeo");
        query.setParameter(1, ubigeoOrden1);
        query.setParameter(2, ubigeoOrden2);
        query.setParameter(3, ubigeoOrden3);
        query.setParameter(4, ubigeoOrden4);
        query.setParameter(5, ubigeoOrden5);
        query.setParameter(6, ubigeoOrden6);
        query.setParameter(7, ubigeoOrden7);
        query.setParameter(8, ubigeoOrden8);
        query.setParameter(9, ubigeoOrden9);
        query.setParameter(10, oidPais);
        return query.getResultList();
    }

    public ValoresEstructuraGeopoliticaLocal findByPaisUnidadGeografica(Long oidPais, Long oidUG) {
        Query query=em.createNamedQuery("ValoresEstructuraGeopoliticaLocal.FindByPaisUnidadGeografica");
        query.setParameter(1, oidPais);
        query.setParameter(2, oidUG);
        return (ValoresEstructuraGeopoliticaLocal)query.getSingleResult();
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("ValoresEstructuraGeopoliticaLocal.FindAll");
        return query.getResultList();
    }

}
