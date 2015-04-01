package com.abien.business.patterns.threadtracker.extension;

import com.abien.business.patterns.threadtracker.MonitorableInstance;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class BootObserver implements Extension{

   void processMonitorable(@Observes ProcessAnnotatedType event) {
      AnnotatedType annotatedType = event.getAnnotatedType();
      Class javaClass = annotatedType.getJavaClass();
      if(javaClass.getSimpleName().contains("Slow")){
        AnnotatedTypeWrapper atw = new AnnotatedTypeWrapper(annotatedType); 
        atw.addAnnotation(new MonitorableInstance());
        event.setAnnotatedType(atw);
      }
   }
}
