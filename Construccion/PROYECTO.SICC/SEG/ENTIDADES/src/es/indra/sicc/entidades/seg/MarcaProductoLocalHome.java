package es.indra.sicc.entidades.seg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.seg.MarcaProductoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MarcaProductoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-seg");
	private EntityManager em = emf.createEntityManager();

	public MarcaProductoLocal create(String codMarcProd, String desMarcProd) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("SEG_MAPR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MarcaProductoLocal local = new MarcaProductoLocal(oid, codMarcProd, desMarcProd);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MarcaProductoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MarcaProductoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MarcaProductoLocal findByPrimaryKey(Long  oid) {
		MarcaProductoLocal local = (MarcaProductoLocal)em.find(MarcaProductoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("MarcaProductoLocal.FindAll");
		return query.getResultList();
	}

	public MarcaProductoLocal findByUk(String codigo) {
		Query query=em.createNamedQuery("MarcaProductoLocal.FindByUk");
		query.setParameter(1, codigo);
		return (MarcaProductoLocal)(query.getSingleResult());
	}

}
