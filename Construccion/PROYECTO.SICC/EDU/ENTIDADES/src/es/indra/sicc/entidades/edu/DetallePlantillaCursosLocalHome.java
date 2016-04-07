package es.indra.sicc.entidades.edu;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.edu.DetallePlantillaCursosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class DetallePlantillaCursosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-edu");
	private EntityManager em = emf.createEntityManager();

	public DetallePlantillaCursosLocal create(Long plantilla, Boolean visible, Boolean modificable, Boolean obligatorio, Long parametro, String valor) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("EDU_DPCU_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		DetallePlantillaCursosLocal local = new DetallePlantillaCursosLocal(oid, plantilla, visible, modificable, obligatorio, parametro, valor);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(DetallePlantillaCursosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(DetallePlantillaCursosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public DetallePlantillaCursosLocal findByPrimaryKey(Long  oid) {
		DetallePlantillaCursosLocal local = (DetallePlantillaCursosLocal)em.find(DetallePlantillaCursosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByPlantilla(Long plantilla) {
		Query query=em.createNamedQuery("DetallePlantillaCursosLocal.FindByPlantilla");
		
		query.setParameter(1, plantilla);

		return query.getResultList();
	}

}
