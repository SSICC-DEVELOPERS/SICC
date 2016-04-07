package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.ParametroMarcaLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class ParametroMarcaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public ParametroMarcaLocal create(Long marc_oid_marc, Long ind_valo_defe, Long ptdt_para_tipo_desc) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_VPMA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametroMarcaLocal local = new ParametroMarcaLocal(oid, marc_oid_marc, ind_valo_defe, ptdt_para_tipo_desc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametroMarcaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametroMarcaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametroMarcaLocal findByPrimaryKey(Long  oid) {
		ParametroMarcaLocal local = (ParametroMarcaLocal)em.find(ParametroMarcaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
