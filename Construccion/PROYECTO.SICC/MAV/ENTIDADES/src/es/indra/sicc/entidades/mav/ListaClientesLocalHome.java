package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.ListaClientesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ListaClientesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();

	public ListaClientesLocal create(Long oidCliente, Long oidPais) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_LICL_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ListaClientesLocal local = new ListaClientesLocal(oid, oidPais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ListaClientesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ListaClientesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ListaClientesLocal findByPrimaryKey(Long  oid) {
		ListaClientesLocal local = (ListaClientesLocal)em.find(ListaClientesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
