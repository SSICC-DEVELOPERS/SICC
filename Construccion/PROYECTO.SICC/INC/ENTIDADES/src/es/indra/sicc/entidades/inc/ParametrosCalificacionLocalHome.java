package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ParametrosCalificacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ParametrosCalificacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ParametrosCalificacionLocal create(Boolean indDevo, Boolean indAnul, Boolean indFaltNoAnun, Boolean indMetaModi, Boolean indMetaBloq, Boolean indComuCali, Long perdOidPeriDesd, Long perdOidPeriHast, Long tvcaOidTipoVentCali, Long diriOidDiri, Long copaOidParaGral, Long fcmeOidFormCalcMeta) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PAC2_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametrosCalificacionLocal local = new ParametrosCalificacionLocal(oid, indDevo, indAnul, indFaltNoAnun, indMetaModi, indMetaBloq, indComuCali, perdOidPeriDesd, perdOidPeriHast, tvcaOidTipoVentCali, diriOidDiri, copaOidParaGral, fcmeOidFormCalcMeta);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametrosCalificacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametrosCalificacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametrosCalificacionLocal findByPrimaryKey(Long  oid) {
		ParametrosCalificacionLocal local = (ParametrosCalificacionLocal)em.find(ParametrosCalificacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ParametrosCalificacionLocal.FindAll");
                    return query.getResultList();
            }

	public ParametrosCalificacionLocal findByUK(Long oidParaGral) {
		Query query=em.createNamedQuery("ParametrosCalificacionLocal.FindByUK");
		
		query.setParameter(1, oidParaGral);

		return (ParametrosCalificacionLocal)(query.getSingleResult());
	}

}
