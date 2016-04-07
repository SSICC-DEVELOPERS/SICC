package es.indra.sicc.entidades.edu;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.edu.HistoricoCursosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;

public class HistoricoCursosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-edu");
	private EntityManager em = emf.createEntityManager();
      
        public HistoricoCursosLocal create(Long oid, Long curso, Integer numConvocatoria, Long cliente, Long subtipo, Date fechaAsistencia, Integer asistenciaCurso) throws MareException  {
                final EntityTransaction et = em.getTransaction();
                et.begin();
                HistoricoCursosLocal local = new HistoricoCursosLocal(oid, curso, numConvocatoria, cliente, subtipo, fechaAsistencia, asistenciaCurso);
                em.persist(local);
                et.commit();
                return local;
        }    

        public HistoricoCursosLocal create(Long oid, Long curso, Integer numConvocatoria, Long cliente, Long subtipo, Date fechaAsistencia, Integer asistenciaCurso, Boolean apta, Boolean invitadaCurso) throws MareException  {
                final EntityTransaction et = em.getTransaction();
                et.begin();
                HistoricoCursosLocal local = new HistoricoCursosLocal(oid, curso, numConvocatoria, cliente, subtipo, fechaAsistencia, asistenciaCurso, apta, invitadaCurso, null);
                em.persist(local);
                et.commit();
                return local;
        }
    
	public HistoricoCursosLocal create(Long curso, 
                          Integer numConvocatoria, 
                          Long cliente, 
                          Long subtipo, 
                          Date fechaAsistencia, 
                          Integer asistenciaCurso, 
                          Boolean apta, 
                          Boolean invitadaCurso) throws MareException  {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("EDU_HICU_SEQ");  
		final EntityTransaction et = em.getTransaction();
		et.begin();
		HistoricoCursosLocal local = new HistoricoCursosLocal(oid, curso, 
                                                 numConvocatoria, 
                                                 cliente, 
                                                 subtipo, 
                                                 fechaAsistencia, 
                                                 asistenciaCurso, 
                                                 apta, 
                                                 invitadaCurso);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(HistoricoCursosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(HistoricoCursosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public HistoricoCursosLocal findByPrimaryKey(Long  oid) {
		HistoricoCursosLocal local = (HistoricoCursosLocal)em.find(HistoricoCursosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
