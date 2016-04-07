package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.ParametroCanalLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class ParametroCanalLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public ParametroCanalLocal create(Long cana_oid_cana, Long ptdt_para_tipo_desc, Long ind_valo_defe) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_VPCA_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametroCanalLocal local = new ParametroCanalLocal(oid, cana_oid_cana, ptdt_para_tipo_desc, ind_valo_defe);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametroCanalLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametroCanalLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametroCanalLocal findByPrimaryKey(Long  oid) {
		ParametroCanalLocal local = (ParametroCanalLocal)em.find(ParametroCanalLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
