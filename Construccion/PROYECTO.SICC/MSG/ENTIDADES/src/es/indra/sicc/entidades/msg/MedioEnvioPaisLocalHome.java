package es.indra.sicc.entidades.msg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.msg.MedioEnvioPaisLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MedioEnvioPaisLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-msg");
	private EntityManager em = emf.createEntityManager();

	public MedioEnvioPaisLocal create( Long pais_oid_pais, Long meen_oid_medi_envi, String cod_esta) throws MareException{
		final EntityTransaction et = em.getTransaction();
		et.begin();
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("MSG_MEEP_SEQ");
                MedioEnvioPaisLocal local = new MedioEnvioPaisLocal(oid,  pais_oid_pais,  meen_oid_medi_envi,  cod_esta);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MedioEnvioPaisLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MedioEnvioPaisLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MedioEnvioPaisLocal findByPrimaryKey(Long  oid) {
		MedioEnvioPaisLocal local = (MedioEnvioPaisLocal)em.find(MedioEnvioPaisLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
