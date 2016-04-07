package es.indra.sicc.entidades.edu;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.edu.TiposCursoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TiposCursoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-edu");
	private EntityManager em = emf.createEntityManager();

	public TiposCursoLocal create(Long oid_tipo_curs, Long marc_oid_marc, Integer cod_tipo_curs) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TiposCursoLocal local = new TiposCursoLocal(oid_tipo_curs, marc_oid_marc, cod_tipo_curs, null);
		em.persist(local);
		et.commit();
		return local;
	}
        
        public TiposCursoLocal create(Long marc_oid_marc, Integer cod_tipo_curs) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("EDU_TICU_SEQ");
                final EntityTransaction et = em.getTransaction();
                et.begin();
                TiposCursoLocal local = new TiposCursoLocal(oid, marc_oid_marc, cod_tipo_curs);
                em.persist(local);
                et.commit();
                return local;
        }        
	
	public void remove(TiposCursoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TiposCursoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TiposCursoLocal findByPrimaryKey(Long  oid) {
		TiposCursoLocal local = (TiposCursoLocal)em.find(TiposCursoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
