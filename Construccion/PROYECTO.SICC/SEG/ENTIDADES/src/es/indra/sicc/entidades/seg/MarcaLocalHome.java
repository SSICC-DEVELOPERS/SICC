package es.indra.sicc.entidades.seg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.seg.MarcaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MarcaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-seg");
	private EntityManager em = emf.createEntityManager();

	public MarcaLocal create(String cod_marc, String des_marc) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("SEG_MARC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MarcaLocal local = new MarcaLocal(oid, cod_marc, des_marc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MarcaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MarcaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MarcaLocal findByPrimaryKey(Long  oid) {
		MarcaLocal local = em.find(MarcaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	public MarcaLocal findByUK(String cod_marc) {
		Query query=em.createNamedQuery("MarcaLocal.FindByUK");
		query.setParameter(1, cod_marc);
		return (MarcaLocal)(query.getSingleResult());
	}
	
	public Collection findAll() {
		Query query = em.createNamedQuery("MarcaLocal.FindAll");
		return query.getResultList();
	}

}
