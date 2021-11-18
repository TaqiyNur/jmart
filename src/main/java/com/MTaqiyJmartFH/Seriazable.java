package com.MTaqiyJmartFH;

import java.util.HashMap;
/**
 *
 * @author  Muhammad Taqiy Nur Furqon
 * @NPM     2006468900
 */
public class Seriazable implements Comparable<Seriazable>
{
    // instance variables - replace the example below with your own
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<Class<?>, Integer>();
    
    protected Seriazable() {
    	Integer counter = mapCounter.get(getClass());
    	if (counter == null) {
    		mapCounter.put(getClass(), 0);
    		this.id = 0;
    	} else {
    		mapCounter.put(getClass(), counter + 1);
    		this.id = counter + 1;
    	}
    }
    
    public boolean equals(Object object) {
        return (object != null) && (object instanceof Seriazable) && (this.id == ((Seriazable) object).id);
    }
    
    public boolean equals(Seriazable recognizable){
        if(this.id == recognizable.id) {
            return true;
        }
        
        return false;
    }
    
    public static int setClosingId(Class<Seriazable> clazz, int id) {
    	if (Class.class.isAssignableFrom(Seriazable.class)) {
    		return 0;
    	}
    	return 1;
    }
    
    public static int getClosingId (Class<Seriazable> clazz) {
    	if (Class.class.isAssignableFrom(Seriazable.class)) {
    		 return 0;
    	}
    	return 1;
    }
    
    public int compareTo(Seriazable recognizable) {
    	return Integer.compare(this.id, recognizable.id);
    }
}
