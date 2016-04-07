package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.ClienteBloqueoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class ClienteBloqueoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public ClienteBloqueoLocal create(Long clie_oid_clie, Long tibq_oid_tipo_bloq, Timestamp fec_bloq, String val_moti_bloq,
                String val_usua_bloq, String obs_bloq) throws MareException {
            
            Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_CLBL_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            ClienteBloqueoLocal local = new ClienteBloqueoLocal(oid, clie_oid_clie, tibq_oid_tipo_bloq, fec_bloq, val_moti_bloq, val_usua_bloq, obs_bloq);
            em.persist(local);
            et.commit();
            return local;
	}
	
	public void remove(ClienteBloqueoLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(local);
            et.commit();
	}
	
	public void merge(ClienteBloqueoLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(local);
            et.commit();
	}
	
	public ClienteBloqueoLocal findByPrimaryKey(Long  oid) {
            ClienteBloqueoLocal local = em.find(ClienteBloqueoLocal.class, oid);
            if (local==null) throw new NoResultException();
            return local;
	}
	
	public Collection findByCliente(Long oidCliente) {
            Query query=em.createNamedQuery("ClienteBloqueoLocal.FindByCliente");
            query.setParameter(1, oidCliente);
            return query.getResultList();
	}

	public ClienteBloqueoLocal findByClienteTipoBloqueo(Long clie_oid_clie,Long tibq_oid_tipo_bloq) {
            Query query=em.createNamedQuery("ClienteBloqueoLocal.FindByClienteTipoBloqueo");
            query.setParameter(1, clie_oid_clie);
            query.setParameter(2, tibq_oid_tipo_bloq);
            return (ClienteBloqueoLocal)(query.getSingleResult());
	}
        
        public Collection findAll() {
            Query query=em.createNamedQuery("ClienteBloqueoLocal.FindAll");
            return query.getResultList();
        }

}
