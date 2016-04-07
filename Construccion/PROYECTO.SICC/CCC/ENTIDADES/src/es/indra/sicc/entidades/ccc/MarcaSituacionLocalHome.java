package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.MarcaSituacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MarcaSituacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();


	public MarcaSituacionLocal create(Long pais_oid_pais, String cod_marc_situ, Long ind_cuen_cast) throws MareException {        
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_MASI_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MarcaSituacionLocal local = new MarcaSituacionLocal(oid, pais_oid_pais, cod_marc_situ, ind_cuen_cast);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MarcaSituacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MarcaSituacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MarcaSituacionLocal findByPrimaryKey(Long  oid) {
		MarcaSituacionLocal local = (MarcaSituacionLocal)em.find(MarcaSituacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
