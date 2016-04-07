package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.MotivoRechazoDesbloqueoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MotivoRechazoDesbloqueoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public MotivoRechazoDesbloqueoLocal create(Long pais, String codigo) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_MRDB_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                MotivoRechazoDesbloqueoLocal local = new MotivoRechazoDesbloqueoLocal(oid, pais, codigo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MotivoRechazoDesbloqueoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MotivoRechazoDesbloqueoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MotivoRechazoDesbloqueoLocal findByPrimaryKey(Long  oid) {
		MotivoRechazoDesbloqueoLocal local = (MotivoRechazoDesbloqueoLocal)em.find(MotivoRechazoDesbloqueoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("MotivoRechazoDesbloqueoLocal.FindAll");
		
		return (query.getResultList());
	}

}
