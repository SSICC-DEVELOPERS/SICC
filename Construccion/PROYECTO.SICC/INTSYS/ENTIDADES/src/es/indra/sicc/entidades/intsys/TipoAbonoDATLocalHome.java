package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.TipoAbonoDATLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoAbonoDATLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public TipoAbonoDATLocal create(String indicador, Long tipoAbonoCargo) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_TIAD_SEQ");
                TipoAbonoDATLocal local = new TipoAbonoDATLocal(oid, indicador, tipoAbonoCargo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoAbonoDATLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoAbonoDATLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoAbonoDATLocal findByPrimaryKey(Long  oid) {
		TipoAbonoDATLocal local = em.find(TipoAbonoDATLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("TipoAbonoDATLocal.FindAll");
		return query.getResultList();
	}

}
