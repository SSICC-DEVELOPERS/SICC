package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.ListaClientesClientesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ListaClientesClientesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();

	public ListaClientesClientesLocal create(Long oidListaCliente, Long oidCliente) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_LCLC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ListaClientesClientesLocal local = new ListaClientesClientesLocal(oid, oidListaCliente, oidCliente);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ListaClientesClientesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ListaClientesClientesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ListaClientesClientesLocal findByPrimaryKey(Long  oid) {
		ListaClientesClientesLocal local = (ListaClientesClientesLocal)em.find(ListaClientesClientesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
