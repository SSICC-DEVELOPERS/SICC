package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.ParametroSubaccesoLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class ParametroSubaccesoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public ParametroSubaccesoLocal create(Long sbac_oid_sbac, Long ind_valo_defe, Long ptdt_para_tipo_desc) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_VPSA_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametroSubaccesoLocal local = new ParametroSubaccesoLocal(oid, sbac_oid_sbac, ind_valo_defe, ptdt_para_tipo_desc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametroSubaccesoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametroSubaccesoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametroSubaccesoLocal findByPrimaryKey(Long  oid) {
		ParametroSubaccesoLocal local = (ParametroSubaccesoLocal)em.find(ParametroSubaccesoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
