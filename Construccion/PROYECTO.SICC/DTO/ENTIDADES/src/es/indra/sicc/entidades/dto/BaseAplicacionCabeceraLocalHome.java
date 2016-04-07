package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.BaseAplicacionCabeceraLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class BaseAplicacionCabeceraLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public BaseAplicacionCabeceraLocal create(Long dcto_oid_desc) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_BACA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		BaseAplicacionCabeceraLocal local = new BaseAplicacionCabeceraLocal(oid, dcto_oid_desc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(BaseAplicacionCabeceraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(BaseAplicacionCabeceraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public BaseAplicacionCabeceraLocal findByPrimaryKey(Long  oid) {
		BaseAplicacionCabeceraLocal local = (BaseAplicacionCabeceraLocal)em.find(BaseAplicacionCabeceraLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
