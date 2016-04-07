package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.FormaPagoCabeceraLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class FormaPagoCabeceraLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public FormaPagoCabeceraLocal create(String codigoFormaPago, Long pais) throws MareException{
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_FOPA_SEQ");
                FormaPagoCabeceraLocal local = new FormaPagoCabeceraLocal(oid, codigoFormaPago, pais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(FormaPagoCabeceraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(FormaPagoCabeceraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public FormaPagoCabeceraLocal findByPrimaryKey(Long  oid) {
		FormaPagoCabeceraLocal local = (FormaPagoCabeceraLocal)em.find(FormaPagoCabeceraLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
