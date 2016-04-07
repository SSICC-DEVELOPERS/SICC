package es.indra.sicc.entidades.msg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.msg.PatronCabeceraLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PatronCabeceraLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-msg");
	private EntityManager em = emf.createEntityManager();

	public PatronCabeceraLocal create(String cod_patr, String des_patr, Long pais_oid_pais) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MSG_PATR_SEQ");
		PatronCabeceraLocal local = new PatronCabeceraLocal(oid, cod_patr, des_patr, pais_oid_pais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PatronCabeceraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PatronCabeceraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PatronCabeceraLocal findByPrimaryKey(Long  oid) {
		PatronCabeceraLocal local = (PatronCabeceraLocal)em.find(PatronCabeceraLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByFormulario(Long param1) {
		Query query=em.createNamedQuery("PatronCabeceraLocal.FindByFormulario");
		query.setParameter(1, param1);
		return query.getResultList();
	}

}
