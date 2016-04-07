package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.ClientePreferenciaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ClientePreferenciaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public ClientePreferenciaLocal create(Long clie_oid_clie, Long tipf_oid_tipo_pref) throws MareException {
            Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_CLPR_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            ClientePreferenciaLocal local = new ClientePreferenciaLocal(oid, clie_oid_clie, tipf_oid_tipo_pref);
            em.persist(local);
            et.commit();
            return local;
	}
	
	public void remove(ClientePreferenciaLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(local);
            et.commit();
	}
	
	public void merge(ClientePreferenciaLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(local);
            et.commit();
	}
	
	public ClientePreferenciaLocal findByPrimaryKey(Long  oid) {
            ClientePreferenciaLocal local = em.find(ClientePreferenciaLocal.class, oid);
            if (local==null) throw new NoResultException();
            return local;
	}
        
        public Collection findAll() {
            Query query = em.createNamedQuery("ClientePreferenciaLocal.FindAll");
            return query.getResultList();
        }
}
