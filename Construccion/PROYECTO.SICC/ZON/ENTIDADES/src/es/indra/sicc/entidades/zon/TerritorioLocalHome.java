package es.indra.sicc.entidades.zon;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.zon.TerritorioLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class TerritorioLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-zon");
    private EntityManager em = emf.createEntityManager();

    public TerritorioLocal create(Long cod_terr, Long pais_oid_pais, String nse1, 
            String nse2, Long ind_borr, Long vepo_oid_valo_estr_geop) throws MareException {
            
        Long oid = SecuenciadorOID.obtenerSiguienteValor("ZON_TERR_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        TerritorioLocal local = new TerritorioLocal(oid, cod_terr, pais_oid_pais, nse1, nse2, ind_borr, vepo_oid_valo_estr_geop);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public TerritorioLocal create(Long cod_terr, Long pais_oid_pais, Long ind_borr, 
            Long vepo_oid_valo_estr_geop, Timestamp fec_rtz) throws MareException {
            
        Long oid = SecuenciadorOID.obtenerSiguienteValor("ZON_TERR_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        TerritorioLocal local = new TerritorioLocal(oid, cod_terr, pais_oid_pais, ind_borr, vepo_oid_valo_estr_geop, fec_rtz);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(TerritorioLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(TerritorioLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public TerritorioLocal findByPrimaryKey(Long  oid) {
        TerritorioLocal local = em.find(TerritorioLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findByCodigoPaisBorrado(Long codTerritorio, Long oidPais) {
        Query query=em.createNamedQuery("TerritorioLocal.FindByCodigoPaisBorrado");
        query.setParameter(1, codTerritorio);
        query.setParameter(2, oidPais);
        return query.getResultList();
    }

    public Collection findByCodigoPais(Long codTerritorio, Long oidPais) {
        Query query=em.createNamedQuery("TerritorioLocal.FindByCodigoPais");
        query.setParameter(1, codTerritorio);
        query.setParameter(2, oidPais);
        return query.getResultList();
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("TerritorioLocal.FindAll");
        return query.getResultList();
    }

}
