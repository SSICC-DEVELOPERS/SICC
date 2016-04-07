package es.indra.sicc.entidades.cra;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cra.CalendarioLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CalendarioLocalHome	{

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cra");
	private EntityManager em = emf.createEntityManager();

	public CalendarioLocal create(Integer num_anio, Long marc_oid_marc, 
                                Long cana_oid_cana, Long pais_oid_pais) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("CRA_CALE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CalendarioLocal local = new CalendarioLocal(oid, num_anio, marc_oid_marc, cana_oid_cana, pais_oid_pais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CalendarioLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CalendarioLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CalendarioLocal findByPrimaryKey(Long  oid) {
		CalendarioLocal local = em.find(CalendarioLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public CalendarioLocal findByUK(Long pais, Long marca, Long canal, Integer anio) {
		Query query=em.createNamedQuery("CalendarioLocal.FindByUK");
		query.setParameter(1, pais);
		query.setParameter(2, marca);
		query.setParameter(3, canal);
		query.setParameter(4, anio);
		return (CalendarioLocal)(query.getSingleResult());
	}

}
