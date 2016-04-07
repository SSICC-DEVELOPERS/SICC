package es.indra.sicc.entidades.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.fac.TecnologiaImpresionLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class TecnologiaImpresionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-fac");
	private EntityManager em = emf.createEntityManager();

	public TecnologiaImpresionLocal create() throws MareException{
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("FAC_TEIM_SEQ");
		TecnologiaImpresionLocal local = new TecnologiaImpresionLocal(oid);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TecnologiaImpresionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TecnologiaImpresionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TecnologiaImpresionLocal findByPrimaryKey(Long  oid) {
		TecnologiaImpresionLocal local = (TecnologiaImpresionLocal)em.find(TecnologiaImpresionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
