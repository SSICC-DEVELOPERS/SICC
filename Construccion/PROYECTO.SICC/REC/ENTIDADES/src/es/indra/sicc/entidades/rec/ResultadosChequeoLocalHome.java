package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.ResultadosChequeoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ResultadosChequeoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public ResultadosChequeoLocal create(Long pais, String codigo, Boolean indicativoResultado) throws MareException{
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_RECQ_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                ResultadosChequeoLocal local = new ResultadosChequeoLocal(oid, pais, codigo, indicativoResultado);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ResultadosChequeoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ResultadosChequeoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ResultadosChequeoLocal findByPrimaryKey(Long  oid) {
		ResultadosChequeoLocal local = (ResultadosChequeoLocal)em.find(ResultadosChequeoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("ResultadosChequeoLocal.FindAll");
		
		return (query.getResultList());
	}

}
