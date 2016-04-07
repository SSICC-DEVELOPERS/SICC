package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.ClienteClasificacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;

public class ClienteClasificacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public ClienteClasificacionLocal create(Long ctsu_oid_clie_tipo_subt, Long clas_oid_clas, Long perd_oid_peri, Long tccl_oid_tipo_clasi,
                Long ind_ppal, Date fec_ulti_actu) throws MareException {
            
            Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_CLCL_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            ClienteClasificacionLocal local = new ClienteClasificacionLocal(oid, ctsu_oid_clie_tipo_subt, clas_oid_clas, perd_oid_peri, tccl_oid_tipo_clasi, ind_ppal, fec_ulti_actu);
            em.persist(local);
            et.commit();
            return local;
	}
	
	public void remove(ClienteClasificacionLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(local);
            et.commit();
	}
	
	public void merge(ClienteClasificacionLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(local);
            et.commit();
	}
	
	public ClienteClasificacionLocal findByPrimaryKey(Long  oid) {
            ClienteClasificacionLocal local = em.find(ClienteClasificacionLocal.class, oid);
            if (local==null) throw new NoResultException();
            return local;
	}
	
	public ClienteClasificacionLocal findByUK(Long oidTipoClasificacion,Long oidClienteTipoSubtipo) {
            Query query=em.createNamedQuery("ClienteClasificacionLocal.FindByUK");
            query.setParameter(1, oidTipoClasificacion);
            query.setParameter(2, oidClienteTipoSubtipo);
            return (ClienteClasificacionLocal)(query.getSingleResult());
	}

        public Collection findAll() {
            Query query=em.createNamedQuery("ClienteClasificacionLocal.FindAll");
            return query.getResultList();
        }
}
