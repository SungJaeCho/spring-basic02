package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonTest {
    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class); //콤포넌트 스캔
        System.out.println("findSingleton");
        SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        System.out.println("findSingleton");
        SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);
        Assertions.assertThat(singletonBean1).isSameAs(singletonBean2); // ==비교
        ac.close();
    }

    @Scope("singleton")
    static class SingletonBean {
        @PostConstruct
        public void init() {
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingletonBean.destroy");
        }
    }

}
