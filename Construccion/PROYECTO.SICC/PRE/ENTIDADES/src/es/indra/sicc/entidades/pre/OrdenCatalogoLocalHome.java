package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.OrdenCatalogoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class OrdenCatalogoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();

	public OrdenCatalogoLocal create(Integer num_orde, Long ocat_oid_cata, Long marc_oid_marc, Long cana_oid_cana) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_OCAT_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		OrdenCatalogoLocal local = new OrdenCatalogoLocal(oid, num_orde, ocat_oid_cata, marc_oid_marc, cana_oid_cana);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(OrdenCatalogoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(OrdenCatalogoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public OrdenCatalogoLocal findByPrimaryKey(Long  oid) {
		OrdenCatalogoLocal local = (OrdenCatalogoLocal)em.find(OrdenCatalogoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
