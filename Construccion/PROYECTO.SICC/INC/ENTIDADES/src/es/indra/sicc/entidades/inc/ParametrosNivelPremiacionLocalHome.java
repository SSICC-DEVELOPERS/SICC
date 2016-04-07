package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;
import java.sql.Date;

import es.indra.sicc.entidades.inc.ParametrosNivelPremiacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ParametrosNivelPremiacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ParametrosNivelPremiacionLocal create(Integer numNive, Long pagpOidParaGenePrem, Long tpreOidTipoPrem, Date fechaUltimaActualizacion) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PANP_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametrosNivelPremiacionLocal local = new ParametrosNivelPremiacionLocal(oid, numNive, pagpOidParaGenePrem, tpreOidTipoPrem, fechaUltimaActualizacion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametrosNivelPremiacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametrosNivelPremiacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametrosNivelPremiacionLocal findByPrimaryKey(Long  oid) {
		ParametrosNivelPremiacionLocal local = (ParametrosNivelPremiacionLocal)em.find(ParametrosNivelPremiacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ParametrosNivelPremiacionLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByParametroGeneralPremiacion(Long premiacion) {
		Query query=em.createNamedQuery("ParametrosNivelPremiacionLocal.FindByParametroGeneralPremiacion");
		
		query.setParameter(1, premiacion);

	    return query.getResultList();
	}

	public ParametrosNivelPremiacionLocal findByUK(Integer nivel, Long premi) {
		Query query=em.createNamedQuery("ParametrosNivelPremiacionLocal.FindByUK");
		
		query.setParameter(1, nivel);

		query.setParameter(2, premi);

		return (ParametrosNivelPremiacionLocal)(query.getSingleResult());
	}

}
