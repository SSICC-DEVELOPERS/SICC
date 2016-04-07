package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.MediosDePagoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MediosDePagoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public MediosDePagoLocal create(Long pais, String codigoMedioPago, Long tipoMedioPago) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_MPAB_SEQ");
                MediosDePagoLocal local = new MediosDePagoLocal(oid, pais, codigoMedioPago, tipoMedioPago);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MediosDePagoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MediosDePagoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MediosDePagoLocal findByPrimaryKey(Long  oid) {
		MediosDePagoLocal local = (MediosDePagoLocal)em.find(MediosDePagoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public MediosDePagoLocal findByUK(Long pais,String codigoMedioPago) {
		Query query=em.createNamedQuery("MediosDePagoLocal.FindByUK");
		query.setParameter(1, pais);
		query.setParameter(2, codigoMedioPago);
		return (MediosDePagoLocal)(query.getSingleResult());
	}

}
