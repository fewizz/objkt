package cubic;

import java.util.*;
import java.util.function.BiConsumer;

public class Registry<T extends Registry.RegistryElement> {
	public final String name;
	Map<Integer, T> intObjMap = new HashMap<>();
	Map<T, Integer> objIntMap = new HashMap<>();
	
	public Registry(String name) {
		this.name = name;
	}
	
	public void add(T obj) {
		for(int id = 0; id < Integer.SIZE; id++) {
			if(intObjMap.get(id) == null) {
				put(id, obj);
				return;
			}
		}
	}
	
	public void put(int id, T obj) {
		intObjMap.put(id, obj);
		objIntMap.put(obj, id);
		obj.setID(id);
	}
	
	public int idOf(T obj) {
		return objIntMap.get(obj);
	}
	
	public T get(int id) {
		return intObjMap.get(id);
	}
	
	public T getByName(String name) {
		return intObjMap.values().stream().filter(el -> el.getName().equals(name)).findFirst().get();
	}
	
	public T remove(int id) {
		T t = intObjMap.remove(id);
		objIntMap.remove(t);
		t.setID(-1);
		return t;
	}
	
	public interface RegistryElement {
		String getName();
		default void setID(int id) {}
	}
	
	public int size() {
		return intObjMap.size();
	}
	
	public void forEachElement(BiConsumer<Integer, T> consumer) {
		intObjMap.forEach(consumer);
	}
	
	public String getName() {
		return name;
	}
	
	public static abstract class SimpleRegistryElement implements RegistryElement {
		private int id = -1;
		
		@Override
		public void setID(int id) {
			this.id = id;
		}
		
		public int getID() {return id;}
	}
}
