package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.SubprocesosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class SubprocesosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();

	public SubprocesosLocal create(Long proceso, Integer codigo, String descripcion,
                            Character indicadorGestionaMarcasSN, Character indicadorActualizaCuotaSN,
                            Character indicadorTipoAbonoSN, Character indicadorConsultasDHAN)
                                    throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_SUBP_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		SubprocesosLocal local = new SubprocesosLocal(oid, proceso, codigo, descripcion,
                         indicadorGestionaMarcasSN, indicadorActualizaCuotaSN,
                         indicadorTipoAbonoSN, indicadorConsultasDHAN);
		em.persist(local);
		et.commit();
		return local;
	}
        
        public SubprocesosLocal create(Long proceso, Integer codigo, String descripcion, 
                            Character indicadorGestionaMarcasSN, Character indicadorActualizaCuotaSN, 
                            Character indicadorTipoAbonoSN, Character indicadorConsultasDHAN, String observaciones)
                                    throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_SUBP_SEQ");
                final EntityTransaction et = em.getTransaction();
                et.begin();
                SubprocesosLocal local = new SubprocesosLocal(oid, proceso, codigo, descripcion,
                         indicadorGestionaMarcasSN, indicadorActualizaCuotaSN,
                         indicadorTipoAbonoSN, indicadorConsultasDHAN, observaciones);
                em.persist(local);
                et.commit();
                return local;
        }        
	
	public void remove(SubprocesosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(SubprocesosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public SubprocesosLocal findByPrimaryKey(Long  oid) {
		SubprocesosLocal local = (SubprocesosLocal)em.find(SubprocesosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public SubprocesosLocal findByUk(Long oidProceso,Long codSubproceso) {
		Query query=em.createNamedQuery("SubprocesosLocal.FindByUk");
		
		query.setParameter(1, oidProceso);

		query.setParameter(2, codSubproceso);

		return (SubprocesosLocal)(query.getSingleResult());
	}

}
