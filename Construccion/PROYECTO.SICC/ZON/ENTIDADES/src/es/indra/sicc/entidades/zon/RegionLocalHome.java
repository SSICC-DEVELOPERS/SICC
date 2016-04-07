package es.indra.sicc.entidades.zon;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.zon.RegionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class RegionLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-zon");
    private EntityManager em = emf.createEntityManager();

    public RegionLocal create(String cod_regi, Long oidPais, Long oidMarca, Long oidCanal,
            Long zsgv_oid_subg_vent, Long oidPeriodoInicio, Long indActivo, Long indBorrado) throws MareException {
        
        Long oid = SecuenciadorOID.obtenerSiguienteValor("ZON_ZORG_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        RegionLocal local = new RegionLocal(oid, cod_regi, oidPais, oidMarca, oidCanal,
            zsgv_oid_subg_vent, oidPeriodoInicio, indActivo, indBorrado);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(RegionLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(RegionLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public RegionLocal findByPrimaryKey(Long  oid) {
        RegionLocal local = em.find(RegionLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public RegionLocal findByPaisMarcaCanalYCodigo(Long oidPais, Long oidMarca, Long oidCanal, String codigoRegion) {
        Query query=em.createNamedQuery("RegionLocal.FindByPaisMarcaCanalYCodigo");
        query.setParameter(1, oidPais);
        query.setParameter(2, oidMarca);
        query.setParameter(3, oidCanal);
        query.setParameter(4, codigoRegion);
        return (RegionLocal)(query.getSingleResult());
    }

    public Collection findByCodigo(Long oidSGV, String codRegion) {
        Query query=em.createNamedQuery("RegionLocal.FindByCodigo");
        query.setParameter(1, oidSGV);
        query.setParameter(2, codRegion);
        return query.getResultList();
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("RegionLocal.FindAll");
        return query.getResultList();
    }

}
