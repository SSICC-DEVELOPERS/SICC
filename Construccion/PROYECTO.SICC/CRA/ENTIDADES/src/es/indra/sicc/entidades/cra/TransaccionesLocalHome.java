package es.indra.sicc.entidades.cra;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cra.TransaccionesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TransaccionesLocalHome	{

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cra");
	private EntityManager em = emf.createEntityManager();

	public TransaccionesLocal create(String cod_proc, Boolean val_ejec) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("CRA_TRAN_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TransaccionesLocal local = new TransaccionesLocal(oid, cod_proc, val_ejec);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TransaccionesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TransaccionesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TransaccionesLocal findByPrimaryKey(Long  oid) {
		TransaccionesLocal local = em.find(TransaccionesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
