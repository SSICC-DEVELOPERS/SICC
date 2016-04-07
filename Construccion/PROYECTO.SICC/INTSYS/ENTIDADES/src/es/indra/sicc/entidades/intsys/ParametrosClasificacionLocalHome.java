package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.ParametrosClasificacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ParametrosClasificacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public ParametrosClasificacionLocal create(String valParaEjec, String valTipoClas, Long cmejOidCodi, Long paisOidPais) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_CPCA_SEQ");
		ParametrosClasificacionLocal local = new ParametrosClasificacionLocal(oid, valParaEjec, valTipoClas, cmejOidCodi, paisOidPais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametrosClasificacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametrosClasificacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametrosClasificacionLocal findByPrimaryKey(Long  oid) {
		ParametrosClasificacionLocal local = em.find(ParametrosClasificacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("ParametrosClasificacionLocal.FindAll");
		return query.getResultList();
	}

}
