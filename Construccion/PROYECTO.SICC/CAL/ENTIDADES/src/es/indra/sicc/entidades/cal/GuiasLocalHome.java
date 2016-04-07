package es.indra.sicc.entidades.cal;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cal.GuiasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;
import java.sql.Timestamp;

public class GuiasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cal");
	private EntityManager em = emf.createEntityManager();

	public GuiasLocal create(String cod_guia, String val_titu, Timestamp fec_inic_vali, Timestamp fec_fin_vali, String val_desc_guia, Long pais_oid_pais, Long dpte_oid_depa) throws  MareException {
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("CAL_GUIA_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
		GuiasLocal local = new GuiasLocal(oid, cod_guia, val_titu, fec_inic_vali, fec_fin_vali, val_desc_guia, pais_oid_pais, dpte_oid_depa);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(GuiasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(GuiasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public GuiasLocal findByPrimaryKey(Long  oid) {
		GuiasLocal local = (GuiasLocal)em.find(GuiasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        public Collection findAll() {
             Query query=em.createNamedQuery("GuiasLocal.FindAll");
             return query.getResultList();
        }

	
}
