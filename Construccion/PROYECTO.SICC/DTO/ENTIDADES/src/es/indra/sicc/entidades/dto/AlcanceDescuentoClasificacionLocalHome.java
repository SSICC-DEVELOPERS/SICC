package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.AlcanceDescuentoClasificacionLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class AlcanceDescuentoClasificacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public AlcanceDescuentoClasificacionLocal create(Long dcto_oid_desc, Long clas_oid_clas) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_ADTC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		AlcanceDescuentoClasificacionLocal local = new AlcanceDescuentoClasificacionLocal(oid, dcto_oid_desc, clas_oid_clas);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(AlcanceDescuentoClasificacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AlcanceDescuentoClasificacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AlcanceDescuentoClasificacionLocal findByPrimaryKey(Long  oid) {
		AlcanceDescuentoClasificacionLocal local = (AlcanceDescuentoClasificacionLocal)em.find(AlcanceDescuentoClasificacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
