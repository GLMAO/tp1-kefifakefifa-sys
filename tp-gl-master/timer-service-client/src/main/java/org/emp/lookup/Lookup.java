package org.emp.gl.lookup;

import java.util.HashMap;

public class Lookup {
    private Lookup instance = null;
    private HashMap<String, Object> services = new HashMap<>() ;

    private Lookup() {

    }

    public Lookup getInstance() {
        if (instance == null) {
            instance = new Lookup();
        }
        return instance;
    }
    
    public void subscribeService ( String service , Object anotherInstance ) {
        this.services.put(service, anotherInstance);
    }
    public Object getService ( String service ) {
        return instance.services.get(service);
    }
}
