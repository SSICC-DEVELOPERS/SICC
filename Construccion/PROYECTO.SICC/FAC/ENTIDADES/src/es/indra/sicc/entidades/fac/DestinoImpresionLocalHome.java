package es.indra.sicc.entidades.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.fac.DestinoImpresionLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class DestinoImpresionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-fac");
	private EntityManager em = emf.createEntityManager();

	public DestinoImpresionLocal create() throws MareException{
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("FAC_DEIM_SEQ");
		DestinoImpresionLocal local = new DestinoImpresionLocal(oid);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(DestinoImpresionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(DestinoImpresionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public DestinoImpresionLocal findByPrimaryKey(Long  oid) {
		DestinoImpresionLocal local = (DestinoImpresionLocal)em.find(DestinoImpresionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
