package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.EscalonLocal;
import es.indra.sicc.util.SecuenciadorOID;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class EscalonLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public EscalonLocal create(BigDecimal val_desd, Double val_porc_desc, Long baca_oid_cabe) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_ESLO_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		EscalonLocal local = new EscalonLocal(oid, val_desd, val_porc_desc, baca_oid_cabe);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(EscalonLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EscalonLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EscalonLocal findByPrimaryKey(Long  oid) {
		EscalonLocal local = (EscalonLocal)em.find(EscalonLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
