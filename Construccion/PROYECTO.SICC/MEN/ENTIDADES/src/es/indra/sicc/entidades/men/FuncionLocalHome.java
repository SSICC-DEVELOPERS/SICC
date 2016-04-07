package es.indra.sicc.entidades.men;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.men.FuncionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.util.Vector;

public class FuncionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-men");
	private EntityManager em = emf.createEntityManager();

	public FuncionLocal create(Boolean indicadorNivel, Boolean indicadorRastreo, Long funcOid) throws MareException  {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MEN_FUNC_SEQ");
                final EntityTransaction et = em.getTransaction();
                et.begin();
                FuncionLocal local = new FuncionLocal(oid, indicadorNivel, indicadorRastreo, funcOid);
                em.persist(local);
                et.commit();
                return local;
	}
        
        public FuncionLocal create(Boolean indicadorNivel, Boolean indicadorRastreo, Vector valores, Long funcOid) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MEN_FUNC_SEQ");
                final EntityTransaction et = em.getTransaction();
                et.begin();
                FuncionLocal local = new FuncionLocal(oid, indicadorNivel, indicadorRastreo, valores, funcOid);
                local.setTraducciones(valores);//i18n
                em.persist(local);
                et.commit();
                return local;
        }        
	
	public void remove(FuncionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(FuncionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public FuncionLocal findByPrimaryKey(Long  oid) {
		FuncionLocal local = (FuncionLocal)em.find(FuncionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        
        public Collection findAll() {
                Query query=em.createNamedQuery("FuncionLocal.FindAll");
                return query.getResultList();
        }
	
}
