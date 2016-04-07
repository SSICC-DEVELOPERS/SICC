package es.indra.sicc.entidades.edu;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.edu.CabeceraPlantillaCursosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CabeceraPlantillaCursosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-edu");
	private EntityManager em = emf.createEntityManager();

	public CabeceraPlantillaCursosLocal create() throws MareException {
                Long oid  = SecuenciadorOID.obtenerSiguienteValor("EDU_CPLC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CabeceraPlantillaCursosLocal local = new CabeceraPlantillaCursosLocal(oid);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CabeceraPlantillaCursosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CabeceraPlantillaCursosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CabeceraPlantillaCursosLocal findByPrimaryKey(Long  oid) {
		CabeceraPlantillaCursosLocal local = (CabeceraPlantillaCursosLocal)em.find(CabeceraPlantillaCursosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
