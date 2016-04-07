package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.SecuenciaProcesosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class SecuenciaProcesosLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public SecuenciaProcesosLocal create(Integer cod_secu, Long grpr_oid_grup_proc,
            Long proc_oid_proc, Long tspa_oid_tipo_soli_pais, Boolean ind_ejec_onli) throws MareException {
        
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_SEPR_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        SecuenciaProcesosLocal local = new SecuenciaProcesosLocal(oid, cod_secu, grpr_oid_grup_proc, proc_oid_proc, tspa_oid_tipo_soli_pais, ind_ejec_onli);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(SecuenciaProcesosLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(SecuenciaProcesosLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public SecuenciaProcesosLocal findByPrimaryKey(Long  oid) {
        SecuenciaProcesosLocal local = em.find(SecuenciaProcesosLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public Collection findByGrupo(Long grupo) {
        Query query=em.createNamedQuery("SecuenciaProcesosLocal.FindByGrupo");
        query.setParameter(1, grupo);
        return query.getResultList();
    }

    public Collection findByProceso(Long proceso) {
        Query query=em.createNamedQuery("SecuenciaProcesosLocal.FindByProceso");
        query.setParameter(1, proceso);
        return query.getResultList();
    }

    public Collection findByGrupoTipoSolicitud(Long grupo,Long tipoSolPais) {
        Query query=em.createNamedQuery("SecuenciaProcesosLocal.FindByGrupoTipoSolicitud");
        query.setParameter(1, grupo);
        query.setParameter(2, tipoSolPais);
        return query.getResultList();
    }

    public SecuenciaProcesosLocal findByUK(Long grupo,Long proceso,Long solicitudPais,Integer secuencia) {
        Query query=em.createNamedQuery("SecuenciaProcesosLocal.FindByUK");
        query.setParameter(1, grupo);
        query.setParameter(2, proceso);
        query.setParameter(3, solicitudPais);
        query.setParameter(4, secuencia);
        return (SecuenciaProcesosLocal)(query.getSingleResult());
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("SecuenciaProcesosLocal.FindAll");
        return query.getResultList();
    }

}
