package br.jus.tse.judiciaria.mural.web;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class JerseyAppConfiguration extends Application {

    private final Set<Class<?>> classes = new HashSet<>();

    private Set<Class<?>> listRestClasses() {
    	classes.add(PublicacaoRest.class);
        classes.add(DecisaoRest.class);
        classes.add(DashboardRest.class);
        classes.add(FiltroRest.class);
        return classes;
    }

    @Override
    public Set<Class<?>> getClasses() {
        return this.listRestClasses();
    }
}
