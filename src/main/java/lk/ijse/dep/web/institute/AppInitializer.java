package lk.ijse.dep.web.institute;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-03-17
 **/
public class AppInitializer {

    private static AnnotationConfigApplicationContext ctx = buildApplicationContext();

    private static AnnotationConfigApplicationContext buildApplicationContext() {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        return ctx;
    }

    public static AnnotationConfigApplicationContext getContext(){
        return ctx;
    }
}
