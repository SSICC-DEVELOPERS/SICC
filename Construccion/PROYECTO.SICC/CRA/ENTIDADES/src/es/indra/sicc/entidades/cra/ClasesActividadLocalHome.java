package es.indra.sicc.entidades.cra;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cra.ClasesActividadLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ClasesActividadLocalHome	{

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cra");
	private EntityManager em = emf.createEntityManager();

	public ClasesActividadLocal create(String cod_clas_acti, String des_clas_acti) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("CRA_CLAC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ClasesActividadLocal local = new ClasesActividadLocal(oid, cod_clas_acti, des_clas_acti);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ClasesActividadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ClasesActividadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ClasesActividadLocal findByPrimaryKey(Long  oid) {
		ClasesActividadLocal local = em.find(ClasesActividadLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
