package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.VentasTotalesCampaniaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class VentasTotalesCampaniaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public VentasTotalesCampaniaLocal create(Long periodo, Long sociedad, Long almacen, Long moneda) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_VTCM_SEQ");
		VentasTotalesCampaniaLocal local = new VentasTotalesCampaniaLocal(oid, periodo, sociedad, almacen, moneda);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(VentasTotalesCampaniaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(VentasTotalesCampaniaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public VentasTotalesCampaniaLocal findByPrimaryKey(Long  oid) {
		VentasTotalesCampaniaLocal local = em.find(VentasTotalesCampaniaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("VentasTotalesCampaniaLocal.FindAll");
		return query.getResultList();
	}

}
