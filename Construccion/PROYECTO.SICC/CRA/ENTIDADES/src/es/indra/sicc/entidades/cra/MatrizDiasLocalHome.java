package es.indra.sicc.entidades.cra;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cra.MatrizDiasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MatrizDiasLocalHome	{

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cra");
	private EntityManager em = emf.createEntityManager();

	public MatrizDiasLocal create(Long cgzo_oid_cabe_grup_zona, Long cact_oid_acti, 
                                Long num_dias_refe) throws MareException{
		Long oid = SecuenciadorOID.obtenerSiguienteValor("CRA_MADI_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MatrizDiasLocal local = new MatrizDiasLocal(oid, cgzo_oid_cabe_grup_zona, cact_oid_acti, 
                                                            num_dias_refe);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MatrizDiasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MatrizDiasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MatrizDiasLocal findByPrimaryKey(Long  oid) {
		MatrizDiasLocal local = em.find(MatrizDiasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public MatrizDiasLocal findByActividadGrupo(Long actividad, Long grupo) {
		Query query=em.createNamedQuery("MatrizDiasLocal.FindByActividadGrupo");
		query.setParameter(1, actividad);
		query.setParameter(2, grupo);
		return (MatrizDiasLocal)(query.getSingleResult());
	}

}
