package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.FuenteVentasRealLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class FuenteVentasRealLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public FuenteVentasRealLocal create(Long zona, Long pais, Long periodo, Long region, Long territorio) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_FVRL_SEQ");
                FuenteVentasRealLocal local = new FuenteVentasRealLocal(oid, zona, pais, periodo, region, territorio);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(FuenteVentasRealLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(FuenteVentasRealLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public FuenteVentasRealLocal findByPrimaryKey(Long  oid) {
		FuenteVentasRealLocal local = em.find(FuenteVentasRealLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
	
	public Collection findAll() {
		Query query=em.createNamedQuery("FuenteVentasRealLocal.FindAll");
		return query.getResultList();
	}

	public FuenteVentasRealLocal findByUK(Long pais,Long periodo,Long region,Long zona,Long territorio) {
		Query query=em.createNamedQuery("FuenteVentasRealLocal.FindByUK");
		query.setParameter(1, pais);
		query.setParameter(2, periodo);
		query.setParameter(3, region);
		query.setParameter(4, zona);
		query.setParameter(5, territorio);
		return (FuenteVentasRealLocal)(query.getSingleResult());
	}

}
