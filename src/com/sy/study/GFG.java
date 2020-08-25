package com.sy.study;

import java.lang.annotation.*;
import java.lang.reflect.Method;
  
// create a custom Annotation 
@Retention(RetentionPolicy.RUNTIME) 
@interface Annotation { 
    // This annotation has two attributes. 
    public String key(); 
    public String value(); 
}


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
@interface AppId {
    String value() default "";
}

// create the Main Class 
public class GFG { 
  
    // call Annotation for method and pass values for annotation 
    @Annotation(key = "AvengersLeader", value = "CaptainAmerica")
    public static void getCustomAnnotation(@AppId @Annotation(key = "1", value = "1") int id, @Annotation(key = "1", value = "1") int id3, int id2)
    { 
  
        try { 
  
            // create class object for class name GFG 
            Class c = GFG.class; 
  
            // get method name getCustomAnnotation as Method object 
            Method[] methods = c.getMethods(); 
            Method method = null; 
            for (Method m:methods) { 
                if (m.getName().equals("getCustomAnnotation")) 
                    method = m; 
            } 
  
            // get Annotation of Method object m by passing 
            // Annotation class object as parameter 
            Annotation anno = method.getAnnotation(Annotation.class);

            java.lang.annotation.Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            java.lang.annotation.Annotation[] annotations = method.getAnnotations();

            // print Annotation Details 
            System.out.println("Annotation for Method Object"
                               + " having name:" + method.getName()); 
            System.out.println("Key Attribute of Annotation:"
                               + anno.key()); 
            System.out.println("Value Attribute of Annotation:"
                               + anno.value()); 
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
  
    // create main method 
    public static void main(String args[]) 
    { 
        getCustomAnnotation(1,1,1);
    } 
}