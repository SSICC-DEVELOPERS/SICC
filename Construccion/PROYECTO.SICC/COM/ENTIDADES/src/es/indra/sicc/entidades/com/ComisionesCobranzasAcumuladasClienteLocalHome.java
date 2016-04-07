package es.indra.sicc.entidades.com;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;
import java.util.Date;

import es.indra.sicc.entidades.com.ComisionesCobranzasAcumuladasClienteLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ComisionesCobranzasAcumuladasClienteLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-com");
	private EntityManager em = emf.createEntityManager();

	public ComisionesCobranzasAcumuladasClienteLocal create(Integer valNiveTram, Date fecCalc, Integer numDias, Double valPorcComi, Double valPorcObje, Long coc2OidComiCobrAcum) throws MareException  {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COM_ACTR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ComisionesCobranzasAcumuladasClienteLocal local = new ComisionesCobranzasAcumuladasClienteLocal(oid, valNiveTram, fecCalc, numDias, valPorcComi, valPorcObje, coc2OidComiCobrAcum);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ComisionesCobranzasAcumuladasClienteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ComisionesCobranzasAcumuladasClienteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ComisionesCobranzasAcumuladasClienteLocal findByPrimaryKey(Long  oid) {
		ComisionesCobranzasAcumuladasClienteLocal local = (ComisionesCobranzasAcumuladasClienteLocal)em.find(ComisionesCobranzasAcumuladasClienteLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

        public Collection findAll() {
                Query query=em.createNamedQuery("ComisionesCobranzasAcumuladasClienteLocal.FindAll");          
                return query.getResultList();
        }

}
