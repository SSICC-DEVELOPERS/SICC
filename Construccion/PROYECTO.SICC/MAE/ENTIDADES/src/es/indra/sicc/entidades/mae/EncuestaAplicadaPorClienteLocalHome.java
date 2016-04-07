package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.EncuestaAplicadaPorClienteLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EncuestaAplicadaPorClienteLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public EncuestaAplicadaPorClienteLocal create(Long oidCliente, Long oidRespuesta) throws MareException {
	    Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_EACL_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            EncuestaAplicadaPorClienteLocal local = new EncuestaAplicadaPorClienteLocal(oid, oidCliente, oidRespuesta);
            em.persist(local);
            et.commit();
            return local;
	}
	
	public void remove(EncuestaAplicadaPorClienteLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(local);
            et.commit();
	}
	
	public void merge(EncuestaAplicadaPorClienteLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(local);
            et.commit();
	}
	
	public EncuestaAplicadaPorClienteLocal findByPrimaryKey(Long  oid) {
            EncuestaAplicadaPorClienteLocal local = em.find(EncuestaAplicadaPorClienteLocal.class, oid);
            if (local==null) throw new NoResultException();
            return local;
	}
        
        public Collection findAll() {
            Query query = em.createNamedQuery("EncuestaAplicadaPorClienteLocal.FindAll");
            return query.getResultList();
        }
}
