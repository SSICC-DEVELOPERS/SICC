package es.indra.sicc.entidades.cal;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cal.AtributoEstadoContactoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class AtributoEstadoContactoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cal");
	private EntityManager em = emf.createEntityManager();

	public AtributoEstadoContactoLocal create(String cod_atri, Long teco_oid) throws  MareException {
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("CAL_ATEC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		AtributoEstadoContactoLocal local = new AtributoEstadoContactoLocal( oid,  cod_atri, teco_oid);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(AtributoEstadoContactoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AtributoEstadoContactoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AtributoEstadoContactoLocal findByPrimaryKey(Long  oid) {
		AtributoEstadoContactoLocal local = (AtributoEstadoContactoLocal)em.find(AtributoEstadoContactoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public AtributoEstadoContactoLocal findByUK(Long tipoEstadoContacto,String codAtributo) {
		Query query=em.createNamedQuery("AtributoEstadoContactoLocal.FindByUK");
		
		query.setParameter(1, tipoEstadoContacto);

		query.setParameter(2, codAtributo);

		return (AtributoEstadoContactoLocal)(query.getSingleResult());
	}
        public Collection findAll() {
            Query query=em.createNamedQuery("AtributoEstadoContactoLocal.FindAll");
            return query.getResultList();
        }

}
