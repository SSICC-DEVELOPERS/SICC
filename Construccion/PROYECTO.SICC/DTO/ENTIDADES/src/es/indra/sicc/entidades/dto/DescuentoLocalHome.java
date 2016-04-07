package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.DescuentoLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class DescuentoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public DescuentoLocal create(Long perd_oid_peri, Long cana_oid_cana, Long marc_oid_marc, Long ind_culm, Long ind_afec_fact, 
                                        Long ind_ctrl_devo, Long ind_comu_part, Long ind_acti, Long ind_ctrl_anul, Long ind_desc_acumu,
                                        Long ind_afec_cc, Long ind_moro, Long ind_apro, Long ind_naci, Long pais_oid_pais, 
                                        Long num_desc_corr, Long num_desc) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_DCTO_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		DescuentoLocal local = new DescuentoLocal(oid, perd_oid_peri, cana_oid_cana, marc_oid_marc, ind_culm, ind_afec_fact, 
                                                            ind_ctrl_devo, ind_comu_part, ind_acti, ind_ctrl_anul, ind_desc_acumu, 
                                                            ind_afec_cc, ind_moro, ind_apro, ind_naci, pais_oid_pais, num_desc_corr, num_desc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(DescuentoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(DescuentoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public DescuentoLocal findByPrimaryKey(Long  oid) {
		DescuentoLocal local = (DescuentoLocal)em.find(DescuentoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
