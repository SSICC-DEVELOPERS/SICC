package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.ParametroSubtipoClienteLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class ParametroSubtipoClienteLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public ParametroSubtipoClienteLocal create(Long sbti_oid_subt_clie, Long ind_valo_defe, Long ptdt_para_tipo_desc) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_VPSC_SEQ");		
                final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametroSubtipoClienteLocal local = new ParametroSubtipoClienteLocal(oid, sbti_oid_subt_clie, ind_valo_defe, ptdt_para_tipo_desc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametroSubtipoClienteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametroSubtipoClienteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametroSubtipoClienteLocal findByPrimaryKey(Long  oid) {
		ParametroSubtipoClienteLocal local = (ParametroSubtipoClienteLocal)em.find(ParametroSubtipoClienteLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
