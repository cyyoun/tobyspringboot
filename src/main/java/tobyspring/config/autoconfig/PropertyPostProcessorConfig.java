package tobyspring.config.autoconfig;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import tobyspring.config.MyAutoConfiguration;

@MyAutoConfiguration
public class PropertyPostProcessorConfig {
    @Bean BeanPostProcessor beanPostProcessor(Environment env){
        return new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                MyConfigurationProperties annotaion = AnnotationUtils.findAnnotation(bean.getClass(), MyConfigurationProperties.class);
                if(annotaion == null)return bean;

                return Binder.get(env).bindOrCreate("", bean.getClass());
            }
        };
    }
}
