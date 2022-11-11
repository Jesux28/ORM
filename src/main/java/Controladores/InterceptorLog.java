package Controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;
import org.hibernate.type.Type;


public class InterceptorLog extends EmptyInterceptor{
    Session session;
    private ArrayList inserts = new ArrayList();
    private ArrayList updates = new ArrayList();
    private ArrayList deletes = new ArrayList();
	
    public void setSession(Session session) {
        this.session=session;
    }
		
    public boolean onSave(Object entity,Serializable id,Object[] state,String[] propertyNames,Type[] types)throws CallbackException {
		System.out.println("onSave");
		
		if (entity instanceof IAuditLog){
			inserts.add(entity);
		}
		return false;
			
	}
	
	public boolean onFlushDirty(Object entity,Serializable id,
		Object[] currentState,Object[] previousState,
		String[] propertyNames,Type[] types)
		throws CallbackException {
	
		System.out.println("onFlushDirty");
		
		if (entity instanceof IAuditLog){
			updates.add(entity);
		}
		return false;
		
	}
	
	public void onDelete(Object entity, Serializable id, 
		Object[] state, String[] propertyNames, 
		Type[] types) {
		
		System.out.println("onDelete");
		
		if (entity instanceof IAuditLog){
			deletes.add(entity);
		}
	}

	//called before commit into database
	public void preFlush(Iterator iterator) {
		System.out.println("preFlush");
	}	
	
	//called after committed into database
	public void postFlush(Iterator iterator) {
		System.out.println("postFlush");
		
	try{
		
            Iterator ins = inserts.iterator();
            Iterator upd = updates.iterator();
            Iterator del = deletes.iterator();
            
		while(ins.hasNext()) {
		    IAuditLog entity = (IAuditLog) ins.next();
                    ins.remove();
		    System.out.println("postFlush - insert");		
		    AuditLogUtil.logIt("Inserted",entity,session);
		}	
			
		while(upd.hasNext()){
		    IAuditLog entity = (IAuditLog) upd.next();
                    upd.remove();
		    System.out.println("postFlush - update");
		    AuditLogUtil.logIt("Updated",entity,session);
		}	
			
		while(del.hasNext()){
		    IAuditLog entity = (IAuditLog) del.next();
                    del.remove();
		    System.out.println("postFlush - delete");
		    AuditLogUtil.logIt("Deleted",entity,session);
		}	
			
	} finally {
		inserts.clear();
		updates.clear();
		deletes.clear();
	}
       }		
}
