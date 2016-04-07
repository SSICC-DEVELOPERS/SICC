package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.ParametroNacionalLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class ParametroNacionalLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public ParametroNacionalLocal create(Long ind_valo_defe, String val_para, Long ptdt_para_tipo_desc) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_VPNA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametroNacionalLocal local = new ParametroNacionalLocal(oid, ind_valo_defe, val_para, ptdt_para_tipo_desc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametroNacionalLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametroNacionalLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametroNacionalLocal findByPrimaryKey(Long  oid) {
		ParametroNacionalLocal local = (ParametroNacionalLocal)em.find(ParametroNacionalLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
