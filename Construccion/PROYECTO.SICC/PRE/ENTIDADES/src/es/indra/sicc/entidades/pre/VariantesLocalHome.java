package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.VariantesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class VariantesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();

	public VariantesLocal create(String newCodigoVariante, String newDescripcionVariante, Long newPais, Long newProgramaFidelizacion) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_VARI_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		VariantesLocal local = new VariantesLocal(oid, newCodigoVariante, newDescripcionVariante, newPais, newProgramaFidelizacion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(VariantesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(VariantesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public VariantesLocal findByPrimaryKey(Long  oid) {
		VariantesLocal local = (VariantesLocal)em.find(VariantesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("VariantesLocal.FindAll");
		
		return query.getResultList();
	}

	public VariantesLocal findByUK(String codigoVariante) {
		Query query=em.createNamedQuery("VariantesLocal.FindByUK");
		
		query.setParameter(1, codigoVariante);

		return (VariantesLocal)(query.getSingleResult());
	}

}
