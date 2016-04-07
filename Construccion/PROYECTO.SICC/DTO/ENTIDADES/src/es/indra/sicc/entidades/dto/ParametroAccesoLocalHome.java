package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.ParametroAccesoLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class ParametroAccesoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public ParametroAccesoLocal create(Long acce_oid_acce, Long ind_valo_defe, Long ptdt_para_tipo_desc) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_VPAC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametroAccesoLocal local = new ParametroAccesoLocal(oid, acce_oid_acce, ind_valo_defe, ptdt_para_tipo_desc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametroAccesoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametroAccesoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametroAccesoLocal findByPrimaryKey(Long  oid) {
		ParametroAccesoLocal local = (ParametroAccesoLocal)em.find(ParametroAccesoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
