package es.indra.sicc.entidades.zon;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.zon.SubGerenciaVentaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class SubGerenciaVentaLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-zon");
    private EntityManager em = emf.createEntityManager();

    public SubGerenciaVentaLocal create(String cod_subg_vent, Long cana_oid_cana,
            Long marc_oid_marc, Long pais_oid_pais, Long oidPeriodoInicio) throws MareException {
            
        Long oid = SecuenciadorOID.obtenerSiguienteValor("ZON_ZSGV_SEQ");                                                    
        final EntityTransaction et = em.getTransaction();
        et.begin();
        SubGerenciaVentaLocal local = new SubGerenciaVentaLocal(oid, cod_subg_vent, cana_oid_cana, marc_oid_marc, pais_oid_pais, oidPeriodoInicio);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(SubGerenciaVentaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(SubGerenciaVentaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public SubGerenciaVentaLocal findByPrimaryKey(Long  oidSubgVenta) {
        SubGerenciaVentaLocal local = em.find(SubGerenciaVentaLocal.class, oidSubgVenta);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findByCodigo(Long oidMarca, Long oidPais, Long oidCanal, String codSGV) {
        Query query = em.createNamedQuery("SubGerenciaVentaLocal.FindByCodigo");
        query.setParameter(1, oidMarca);
        query.setParameter(2, oidPais);
        query.setParameter(3, oidCanal);
        query.setParameter(4, codSGV);
        return query.getResultList();
    }

    public Collection findAll() {
        Query query = em.createNamedQuery("SubGerenciaVentaLocal.FindAll");
        return query.getResultList();
    }
}
