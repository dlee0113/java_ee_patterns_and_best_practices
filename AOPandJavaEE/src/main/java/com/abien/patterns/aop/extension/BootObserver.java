package com.abien.patterns.aop.extension;

import com.abien.patterns.aop.HiInstance;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class BootObserver implements Extension{

   void processUniversalGreeter(@Observes ProcessAnnotatedType event) {
      AnnotatedType annotatedType = event.getAnnotatedType();
      Class javaClass = annotatedType.getJavaClass();
      if(javaClass.getName().endsWith("UniversalGreeter")){
        AnnotatedTypeWrapper atw = new AnnotatedTypeWrapper(annotatedType); 
        atw.addAnnotation(new HiInstance());
        event.setAnnotatedType(atw);
      }
   }
}
