package es.indra.sicc.entidades.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.fac.TipoImpresoraLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class TipoImpresoraLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-fac");
	private EntityManager em = emf.createEntityManager();

	public TipoImpresoraLocal create() throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("FAC_TIIM_SEQ");
		TipoImpresoraLocal local = new TipoImpresoraLocal(oid);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoImpresoraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoImpresoraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoImpresoraLocal findByPrimaryKey(Long  oid) {
		TipoImpresoraLocal local = (TipoImpresoraLocal)em.find(TipoImpresoraLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
