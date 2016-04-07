package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.ResumenPagoIntercompaniasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class ResumenPagoIntercompaniasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();

	public ResumenPagoIntercompaniasLocal create(Timestamp fec_resu_pago_inte, Timestamp fec_inic,
                                            Timestamp fec_fin, Long marc_oid_marc, Long acti_oid_acti, 
                                            Long cana_oid_cana, Long soca_oid_soli_cabe, Long sbac_oid_sbac) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_REPI_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ResumenPagoIntercompaniasLocal local = new ResumenPagoIntercompaniasLocal(oid, fec_resu_pago_inte, fec_inic,
                                         fec_fin, marc_oid_marc, acti_oid_acti, 
                                         cana_oid_cana, soca_oid_soli_cabe, sbac_oid_sbac);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ResumenPagoIntercompaniasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ResumenPagoIntercompaniasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ResumenPagoIntercompaniasLocal findByPrimaryKey(Long  oid) {
		ResumenPagoIntercompaniasLocal local = (ResumenPagoIntercompaniasLocal)em.find(ResumenPagoIntercompaniasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
