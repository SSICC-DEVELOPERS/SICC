package es.indra.sicc.cmn.negocio.auditoria.test;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MarcaTestLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cmn");
	private EntityManager em = emf.createEntityManager();

	public void create(String cod_marc) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		Long oid = SecuenciadorOID.obtenerSiguienteValor("SEG_MARC_SEQ");
		MarcaTestLocal local = new MarcaTestLocal(oid, cod_marc);
		em.persist(local);
		et.commit();
	}
	
	public void remove(MarcaTestLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MarcaTestLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MarcaTestLocal findByPrimaryKey(Long  oid) {
		MarcaTestLocal local = (MarcaTestLocal)em.find(MarcaTestLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
	
	public Collection findAll() {
		Query query=em.createNamedQuery("MarcaTestLocal.FindAll");
		return query.getResultList();
	}

	
}
