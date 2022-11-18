package com.mgrimm21.gefinal.event;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class EventDispatcher {
	
	@SuppressWarnings("rawtypes")
	private static ArrayList<Object> classes = new ArrayList<Object>();
	
	@SuppressWarnings("rawtypes")
	public static void invoke(GrimmEvent event) {
		for (Object o: classes) {
			Class c = o.getClass();
			Method[] methods = c.getMethods();
			for (Method m: methods) {
				if (m.isAnnotationPresent(EventHandler.class)) {
					if (m.getParameters()[0].getType().getGenericSuperclass().equals(GrimmEvent.class)) {
						try {
							m.invoke(o, event);
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void registerListener(Object o) {
		classes.add(o);
	}

	
	
}
