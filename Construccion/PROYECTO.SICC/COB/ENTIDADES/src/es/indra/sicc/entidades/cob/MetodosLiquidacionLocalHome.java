package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cob.MetodosLiquidacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MetodosLiquidacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public MetodosLiquidacionLocal create(String codigoMetodoLiquidacion, String descripcion, Boolean indLiquidacion, Boolean indLiquidacionGrupoUsuarios, Long pais, Long baseEscala) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_MELC_SEQ");
		et.begin();
		MetodosLiquidacionLocal local = new MetodosLiquidacionLocal(oid, codigoMetodoLiquidacion, descripcion, indLiquidacion, indLiquidacionGrupoUsuarios, pais, baseEscala);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MetodosLiquidacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MetodosLiquidacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MetodosLiquidacionLocal findByPrimaryKey(Long  oid) {
		MetodosLiquidacionLocal local = (MetodosLiquidacionLocal)em.find(MetodosLiquidacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("MetodosLiquidacionLocal.FindAll");          
            return query.getResultList();
        }

}
