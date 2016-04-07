package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.ParametroTipoClienteLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class ParametroTipoClienteLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public ParametroTipoClienteLocal create(Long ptdt_oid_para_tipo_desc, Long ticl_oid_tipo_clie, Long ind_valo_defe) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_VPTC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametroTipoClienteLocal local = new ParametroTipoClienteLocal(oid, ptdt_oid_para_tipo_desc, ticl_oid_tipo_clie, ind_valo_defe);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametroTipoClienteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametroTipoClienteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametroTipoClienteLocal findByPrimaryKey(Long  oid) {
		ParametroTipoClienteLocal local = (ParametroTipoClienteLocal)em.find(ParametroTipoClienteLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
