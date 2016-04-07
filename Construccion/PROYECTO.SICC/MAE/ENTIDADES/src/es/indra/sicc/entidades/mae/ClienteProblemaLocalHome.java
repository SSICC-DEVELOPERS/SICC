package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.ClienteProblemaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ClienteProblemaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public ClienteProblemaLocal create(Long clie_oid_clie, Long tipb_oid_tipo_prob, Boolean ind_solu) throws MareException {
	    Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_CLPB_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            ClienteProblemaLocal local = new ClienteProblemaLocal(oid, clie_oid_clie, tipb_oid_tipo_prob, ind_solu);
            em.persist(local);
            et.commit();
            return local;
	}
	
	public void remove(ClienteProblemaLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(local);
            et.commit();
	}
	
	public void merge(ClienteProblemaLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(local);
            et.commit();
	}
	
	public ClienteProblemaLocal findByPrimaryKey(Long  oid) {
            ClienteProblemaLocal local = (ClienteProblemaLocal)em.find(ClienteProblemaLocal.class, oid);
            if (local==null) throw new NoResultException();
            return local;
	}

        public Collection findAll() {
            Query query = em.createNamedQuery("ClienteProblemaLocal.FindAll");
            return query.getResultList();
        }
}
