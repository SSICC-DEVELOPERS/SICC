package es.indra.sicc.entidades.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.fac.ControlCierresLocal;
import es.indra.sicc.util.SecuenciadorOID;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class ControlCierresLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-fac");
	private EntityManager em = emf.createEntityManager();

	public ControlCierresLocal create(Long pais, Long tiposCierre, Integer secuencia, Date fechaCierre, Long periodo) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("FAC_COCI_SEQ");
                ControlCierresLocal local = new ControlCierresLocal(oid, pais, tiposCierre, secuencia, fechaCierre, periodo);
                em.persist(local);
		et.commit();
		return local;
	}

        public ControlCierresLocal create(Long pais, Long tiposCierre, Integer secuencia, Date fechaCierre, String procesoEjecutado, String resultadoProceso, Long periodo, Long zona, Long region) throws MareException {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            Long oid = SecuenciadorOID.obtenerSiguienteValor("FAC_COCI_SEQ");
            ControlCierresLocal local = new ControlCierresLocal(oid, pais, tiposCierre, secuencia, fechaCierre, procesoEjecutado, resultadoProceso, periodo, zona, region);
            em.persist(local);
            et.commit();
            return local;
        }
        
	public void remove(ControlCierresLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ControlCierresLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ControlCierresLocal findByPrimaryKey(Long  oid) {
		ControlCierresLocal local = (ControlCierresLocal)em.find(ControlCierresLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
