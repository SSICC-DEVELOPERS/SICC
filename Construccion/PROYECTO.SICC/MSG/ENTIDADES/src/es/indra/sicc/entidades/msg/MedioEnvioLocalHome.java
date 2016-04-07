package es.indra.sicc.entidades.msg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.msg.MedioEnvioLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MedioEnvioLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-msg");
	private EntityManager em = emf.createEntityManager();

	public MedioEnvioLocal create( String cod_medi_envi, String des_medi_envi) throws MareException{
		final EntityTransaction et = em.getTransaction();
		et.begin();
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("MSG_MEEN_SEQ");
		MedioEnvioLocal local = new MedioEnvioLocal(oid,  cod_medi_envi,  des_medi_envi);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MedioEnvioLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MedioEnvioLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MedioEnvioLocal findByPrimaryKey(Long  oid) {
		MedioEnvioLocal local = (MedioEnvioLocal)em.find(MedioEnvioLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
