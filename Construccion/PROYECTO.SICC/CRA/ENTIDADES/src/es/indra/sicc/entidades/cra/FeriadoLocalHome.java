package es.indra.sicc.entidades.cra;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cra.FeriadoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;
import es.indra.sicc.util.SecuenciadorOID;

public class FeriadoLocalHome	{

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cra");
	private EntityManager em = emf.createEntityManager();

	public FeriadoLocal create(Long cgzo_oid_cabe_grup_zona, Long cact_oid_acti, Integer num_anio, 
                                    Date fec_feri, Boolean ind_fest) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("CRA_FERI_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		FeriadoLocal local = new FeriadoLocal(oid, cgzo_oid_cabe_grup_zona, cact_oid_acti, num_anio, 
                                                        fec_feri,  ind_fest);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(FeriadoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(FeriadoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public FeriadoLocal findByPrimaryKey(Long  oid) {
		FeriadoLocal local = em.find(FeriadoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
