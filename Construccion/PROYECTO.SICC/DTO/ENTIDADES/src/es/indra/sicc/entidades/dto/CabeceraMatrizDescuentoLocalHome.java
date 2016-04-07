package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.CabeceraMatrizDescuentoLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class CabeceraMatrizDescuentoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public CabeceraMatrizDescuentoLocal create(Long ind_matr_acti, Long pais_oid_pais) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_MDES_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CabeceraMatrizDescuentoLocal local = new CabeceraMatrizDescuentoLocal(oid, ind_matr_acti, pais_oid_pais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CabeceraMatrizDescuentoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CabeceraMatrizDescuentoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CabeceraMatrizDescuentoLocal findByPrimaryKey(Long  oid) {
		CabeceraMatrizDescuentoLocal local = (CabeceraMatrizDescuentoLocal)em.find(CabeceraMatrizDescuentoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
