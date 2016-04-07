package es.indra.sicc.entidades.intsys;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.ParametrosContablesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import javax.persistence.Persistence;

public class ParametrosContablesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public ParametrosContablesLocal create(String codigoApunte, String tipoAsiento, String identificadorCabeceraDetalle, String descripcion, String indicadorDebeHaber, Long pais, Long cuentaContable, Long importeAContabilizar) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_IPCF_SEQ");
                ParametrosContablesLocal local = new ParametrosContablesLocal(oid, codigoApunte, tipoAsiento, identificadorCabeceraDetalle, descripcion, indicadorDebeHaber, pais, cuentaContable, importeAContabilizar);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametrosContablesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametrosContablesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametrosContablesLocal findByPrimaryKey(Long  oid) {
		ParametrosContablesLocal local = em.find(ParametrosContablesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("ParametrosContablesLocal.FindAll");
		return query.getResultList();
	}

}
