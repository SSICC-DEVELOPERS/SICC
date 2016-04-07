package es.indra.sicc.entidades.cra;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cra.TipoFacturacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoFacturacionLocalHome	{

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cra");
	private EntityManager em = emf.createEntityManager();

	public TipoFacturacionLocal create(String des_tipo_fact) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("CRA_TIFA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TipoFacturacionLocal local = new TipoFacturacionLocal(oid, des_tipo_fact);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoFacturacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoFacturacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoFacturacionLocal findByPrimaryKey(Long  oid) {
		TipoFacturacionLocal local = em.find(TipoFacturacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
