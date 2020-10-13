package com.annotationsPrac;

import java.lang.annotation.*;
import java.lang.reflect.*;;

public class AnnotationExample {
	@Override
	@MethodInfo(author = "Sammy", comments = "main method", date = "oct 13 2020", revision = 1)
	public String toString() {
		return "overRidden toString() method";
	}

	@Deprecated
	@MethodInfo(author = "manu", comments = "old method", date = "apr 09 1998")
	public static void oldMethod() {
		System.out.println("Old method. Don't use!");
	}

	public static void main(String[] args) {
		try {
			for (Method method : AnnotationExample.class.getMethods()) {
				if (method.isAnnotationPresent(MethodInfo.class)) {
					try {
						for (Annotation anno : method.getDeclaredAnnotations()) {
							System.out.println("Annotation in method : " + method + " is : " + anno);
						}
					} catch (Throwable e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		} catch (SecurityException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
