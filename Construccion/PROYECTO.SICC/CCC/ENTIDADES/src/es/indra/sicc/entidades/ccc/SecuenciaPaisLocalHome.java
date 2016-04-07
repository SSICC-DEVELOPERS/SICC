package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.SecuenciaPaisLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class SecuenciaPaisLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();
            
	public SecuenciaPaisLocal create(Long pais, Long secuencia) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_SEPA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		SecuenciaPaisLocal local = new SecuenciaPaisLocal(oid, pais, secuencia);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(SecuenciaPaisLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(SecuenciaPaisLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public SecuenciaPaisLocal findByPrimaryKey(Long  oid) {
		SecuenciaPaisLocal local = (SecuenciaPaisLocal)em.find(SecuenciaPaisLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
