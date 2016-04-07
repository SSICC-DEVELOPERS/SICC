package es.indra.sicc.entidades.msg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.msg.ParametroMensajeLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class ParametroMensajeLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-msg");
	private EntityManager em = emf.createEntityManager();

	public ParametroMensajeLocal create(String cod_dato_vari, String desc_dato_vari, String modu_orig, Timestamp fech_de_sist, Long pais_oid_pais) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("MSG_PAME_SEQ");
		ParametroMensajeLocal local = new ParametroMensajeLocal(oid, cod_dato_vari, desc_dato_vari,  modu_orig,  fech_de_sist,  pais_oid_pais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametroMensajeLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametroMensajeLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametroMensajeLocal findByPrimaryKey(Long  oid) {
		ParametroMensajeLocal local = (ParametroMensajeLocal)em.find(ParametroMensajeLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
