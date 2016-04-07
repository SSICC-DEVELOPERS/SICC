package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.ParametroBooleanLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class ParametroBooleanLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public ParametroBooleanLocal create(Long ind_valo_defe, Long val_para, Long ptdt_para_tipo_desc) throws MareException{
                Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_VPBO_SEQ");		
                final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametroBooleanLocal local = new ParametroBooleanLocal(oid, ind_valo_defe, val_para, ptdt_para_tipo_desc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametroBooleanLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametroBooleanLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametroBooleanLocal findByPrimaryKey(Long  oid) {
		ParametroBooleanLocal local = (ParametroBooleanLocal)em.find(ParametroBooleanLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
