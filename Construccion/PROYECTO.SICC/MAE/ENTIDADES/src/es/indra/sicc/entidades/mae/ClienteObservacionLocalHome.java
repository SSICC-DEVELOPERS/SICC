package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.ClienteObservacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ClienteObservacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public ClienteObservacionLocal create(Long marc_oid_marc, Long clie_oid_clie, Long num_obse, String val_text) throws MareException {
            Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_CLOB_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            ClienteObservacionLocal local = new ClienteObservacionLocal(oid, marc_oid_marc, clie_oid_clie, num_obse, val_text);
            em.persist(local);
            et.commit();
            return local;
	}
	
	public void remove(ClienteObservacionLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(local);
            et.commit();
	}
	
	public void merge(ClienteObservacionLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(local);
            et.commit();
	}
	
	public ClienteObservacionLocal findByPrimaryKey(Long  oid) {
            ClienteObservacionLocal local = em.find(ClienteObservacionLocal.class, oid);
            if (local==null) throw new NoResultException();
            return local;
	}

	public Collection findAll() {
            Query query = em.createNamedQuery("ClienteObservacionLocal.FindAll");
            return query.getResultList();
        }
}
