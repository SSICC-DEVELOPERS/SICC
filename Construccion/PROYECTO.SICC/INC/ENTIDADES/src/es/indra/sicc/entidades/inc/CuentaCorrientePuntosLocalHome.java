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

import es.indra.sicc.entidades.inc.CuentaCorrientePuntosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CuentaCorrientePuntosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public CuentaCorrientePuntosLocal create(Integer numPunt, Integer numPuntExig, Date fecMovi, Long copaOidParaGral, Long clieOidClie, Long perdOidPeri, Long tmovOidTipoMovi) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_CUCP_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CuentaCorrientePuntosLocal local = new CuentaCorrientePuntosLocal(oid, numPunt, numPuntExig, fecMovi, copaOidParaGral, clieOidClie, perdOidPeri, tmovOidTipoMovi);
		em.persist(local);
		et.commit();
		return local;
	}
        
    public CuentaCorrientePuntosLocal create(Integer numPunt, Integer numPuntExig, Date fecMovi, Long copaOidParaGral, Long clieOidClie, Long perdOidPeri, Long tmovOidTipoMovi, String descripcion) throws MareException {
            Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_CUCP_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            CuentaCorrientePuntosLocal local = new CuentaCorrientePuntosLocal(oid, numPunt, numPuntExig, fecMovi, copaOidParaGral, clieOidClie, perdOidPeri, tmovOidTipoMovi, descripcion);
            em.persist(local);
            et.commit();
            return local;
    }
	
	public void remove(CuentaCorrientePuntosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CuentaCorrientePuntosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CuentaCorrientePuntosLocal findByPrimaryKey(Long  oid) {
		CuentaCorrientePuntosLocal local = (CuentaCorrientePuntosLocal)em.find(CuentaCorrientePuntosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("CuentaCorrientePuntosLocal.FindAll");
                    return query.getResultList();
            }

	public CuentaCorrientePuntosLocal findByUK(Long oidCliente, Long concurso, Integer numMovimiento) {
		Query query=em.createNamedQuery("CuentaCorrientePuntosLocal.FindByUK");
		
		query.setParameter(1, oidCliente);

		query.setParameter(2, concurso);

		query.setParameter(3, numMovimiento);

		return (CuentaCorrientePuntosLocal)(query.getSingleResult());
	}

	public Collection findByConcurso(Long oidConcurso) {
		Query query=em.createNamedQuery("CuentaCorrientePuntosLocal.FindByConcurso");
		
		query.setParameter(1, oidConcurso);

	    return query.getResultList();
	}

}
