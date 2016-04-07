package es.indra.sicc.entidades.seg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PaisLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-seg");
	private EntityManager em = emf.createEntityManager();

	public PaisLocal create(String cod_pais, Long mone_oid_mone, String val_iden, String val_prog_ejec,
			Long val_porc_alar, Long num_dias_mora, Long ind_sald_unic, String ind_inte_gis, Long ind_comp_auto,
			Long ind_trat_acum_desc, Long val_tiem_rezo, String val_conf_secu_ccc, Long num_limi_dife_pago,
			Long val_maxi_dife_anls_comb, Long num_dias_fact, Long num_posi_nume_clie, Long mone_oid_mone_alt,
			Long ind_emis_venc, String val_form_fech, String val_sepa_mile, String val_sepa_deci, Long num_peri_egre,
			Long num_peri_reti, String val_url, String ind_flet_zona_ubig, String val_indi_secu_moni,
			String ind_secu, String ind_bala_area_cheq) throws MareException {
		
		Long oid = SecuenciadorOID.obtenerSiguienteValor("SEG_PAIS_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		PaisLocal local = new PaisLocal(oid, cod_pais, mone_oid_mone, val_iden, val_prog_ejec, val_porc_alar,
				num_dias_mora, ind_sald_unic, ind_inte_gis, ind_comp_auto, ind_trat_acum_desc, val_tiem_rezo,
				val_conf_secu_ccc, num_limi_dife_pago, val_maxi_dife_anls_comb, num_dias_fact, num_posi_nume_clie,
				mone_oid_mone_alt, ind_emis_venc, val_form_fech, val_sepa_mile, val_sepa_deci, num_peri_egre,
				num_peri_reti, val_url, ind_flet_zona_ubig, val_indi_secu_moni, ind_secu, ind_bala_area_cheq);
				
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PaisLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PaisLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PaisLocal findByPrimaryKey(Long  oid) {
		PaisLocal local = em.find(PaisLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public PaisLocal findByUk(String codigo) {
		Query query=em.createNamedQuery("PaisLocal.FindByUk");
		query.setParameter(1, codigo);
		return (PaisLocal)(query.getSingleResult());
	}
	
	public Collection findAll() {
		Query query=em.createNamedQuery("PaisLocal.FindAll");
		return query.getResultList();
	}

}
