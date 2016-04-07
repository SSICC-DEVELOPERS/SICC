package es.indra.sicc.entidades.edu;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.edu.AptasACursosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;

public class AptasACursosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-edu");
	private EntityManager em = emf.createEntityManager();

	public AptasACursosLocal create(Long curso, Integer numConvocatoria, Long cliente, Long subtipo) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("EDU_APCU_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		AptasACursosLocal local = new AptasACursosLocal(oid, curso, numConvocatoria, cliente, subtipo);
		em.persist(local);
		et.commit();
		return local;
	}

        public AptasACursosLocal create(Long curso, Integer numConvocatoria, Long cliente, Long subtipo, Date fechaAsistencia, Boolean dataMart, Boolean apta, Boolean invitadaCurso, Integer asistenciaCurso, Boolean pruebas) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("EDU_APCU_SEQ");
                final EntityTransaction et = em.getTransaction();
                et.begin();
                AptasACursosLocal local = new AptasACursosLocal(oid, curso, numConvocatoria, cliente, subtipo, fechaAsistencia, dataMart, apta, invitadaCurso, asistenciaCurso, pruebas);
                em.persist(local);
                et.commit();
                return local;
        }
	
	public void remove(AptasACursosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AptasACursosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AptasACursosLocal findByPrimaryKey(Long  oid) {
		AptasACursosLocal local = (AptasACursosLocal)em.find(AptasACursosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByCursoPruebas(Long oid) {
		Query query=em.createNamedQuery("AptasACursosLocal.FindByCursoPruebas");
		
		query.setParameter(1, oid);

		return query.getResultList();
	}

	public AptasACursosLocal findByUK(Long oidCurso,Long oidCliente) {
		Query query=em.createNamedQuery("AptasACursosLocal.FindByUK");
		
		query.setParameter(1, oidCurso);

		query.setParameter(2, oidCliente);

		return (AptasACursosLocal)(query.getSingleResult());
	}

}
