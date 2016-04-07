package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.ParametroLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class ParametroLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public ParametroLocal create(String cod_para, String val_nomb, Long ind_obli) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_PADT_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametroLocal local = new ParametroLocal(oid, cod_para, val_nomb, ind_obli);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametroLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametroLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametroLocal findByPrimaryKey(Long  oid) {
		ParametroLocal local = (ParametroLocal)em.find(ParametroLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
