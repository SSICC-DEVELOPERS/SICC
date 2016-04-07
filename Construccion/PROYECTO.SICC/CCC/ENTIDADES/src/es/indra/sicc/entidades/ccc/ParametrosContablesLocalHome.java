package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.ParametrosContablesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ParametrosContablesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();

	public ParametrosContablesLocal create(Long subproceso, Character indicativoDeberHaber, 
                                    String textoApunte, Character concatenarFechaSN)
                                    throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_PACO_SEQ");                                    
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametrosContablesLocal local = new ParametrosContablesLocal(oid, subproceso, indicativoDeberHaber, 
                                                 textoApunte, concatenarFechaSN);
		em.persist(local);
		et.commit();
		return local;
	}
	
        public ParametrosContablesLocal create(Long subproceso, Character indicativoDeberHaber, 
                                    Character obtencionCuenta, String textoApunte, String observaciones,
                                    Character concatenarFechaSN, Long cuenta)
                                    throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_PACO_SEQ");                                    
                final EntityTransaction et = em.getTransaction();
                et.begin();
                ParametrosContablesLocal local = new ParametrosContablesLocal(oid, subproceso, indicativoDeberHaber, 
                                                 obtencionCuenta, textoApunte, observaciones,
                                                 concatenarFechaSN, cuenta);
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
		ParametrosContablesLocal local = (ParametrosContablesLocal)em.find(ParametrosContablesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
