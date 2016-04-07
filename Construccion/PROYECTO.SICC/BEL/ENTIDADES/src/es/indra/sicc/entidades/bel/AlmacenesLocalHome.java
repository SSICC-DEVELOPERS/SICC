package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.AlmacenesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class AlmacenesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public AlmacenesLocal create(Long pais, String codigoAlmacen, Boolean informarSAP) throws MareException{
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_ALMC_SEQ");
		AlmacenesLocal local = new AlmacenesLocal(oid, pais, codigoAlmacen, informarSAP);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(AlmacenesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AlmacenesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AlmacenesLocal findByPrimaryKey(Long  oid) {
		AlmacenesLocal local = (AlmacenesLocal)em.find(AlmacenesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public AlmacenesLocal findByUK(Long pais,String codigoAlmacen) {
		Query query=em.createNamedQuery("AlmacenesLocal.FindByUK");
		query.setParameter(1, pais);
		query.setParameter(2, codigoAlmacen);
		return (AlmacenesLocal)(query.getSingleResult());
	}

}
