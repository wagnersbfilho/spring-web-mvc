package br.com.spring.diolabs.springmvcweb.repository;

import br.com.spring.diolabs.springmvcweb.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JediRepository {

    private List<Jedi> listaJedi;

    public JediRepository() {
        listaJedi = new ArrayList<Jedi>();
        listaJedi.add(new Jedi("Luke", "Skywalker"));
        listaJedi.add(new Jedi("Obi-Wan", "Kenobi"));
        listaJedi.add(new Jedi("Qui-Gon", "Jinn"));
    }

    public List<Jedi> getAll() {
        return listaJedi;
    }

    public void add(final Jedi jedi) {
        this.listaJedi.add(jedi);
    }
}
