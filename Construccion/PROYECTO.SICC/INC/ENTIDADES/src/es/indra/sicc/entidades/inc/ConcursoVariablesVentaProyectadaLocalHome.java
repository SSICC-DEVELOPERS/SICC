package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ConcursoVariablesVentaProyectadaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ConcursoVariablesVentaProyectadaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ConcursoVariablesVentaProyectadaLocal create(Boolean indActi, Boolean indIngr, Boolean indRein, Boolean indEgre, Boolean indEntr, Boolean indReci, Boolean indCapi, Boolean indActiFina, Boolean indAdad, Boolean indNumePedi, Boolean indPrecPromUnit, Boolean indPromVentPedi, Boolean indPromOrdePedi, Boolean indPromUnidPedi, Boolean indRete, Boolean indVentEsta, Long copaOidParaGral) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_CVVP_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ConcursoVariablesVentaProyectadaLocal local = new ConcursoVariablesVentaProyectadaLocal(oid, indActi, indIngr, indRein, indEgre, indEntr, indReci, indCapi, indActiFina, indAdad, indNumePedi, indPrecPromUnit, indPromVentPedi, indPromOrdePedi, indPromUnidPedi, indRete, indVentEsta, copaOidParaGral);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ConcursoVariablesVentaProyectadaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ConcursoVariablesVentaProyectadaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ConcursoVariablesVentaProyectadaLocal findByPrimaryKey(Long  oid) {
		ConcursoVariablesVentaProyectadaLocal local = (ConcursoVariablesVentaProyectadaLocal)em.find(ConcursoVariablesVentaProyectadaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ConcursoVariablesVentaProyectadaLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByConcurso(Long concurso) {
		Query query=em.createNamedQuery("ConcursoVariablesVentaProyectadaLocal.FindByConcurso");
		
		query.setParameter(1, concurso);

	    return query.getResultList();
	}

}
