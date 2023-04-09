package br.com.spring.diolabs.springmvcweb.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Jedi {

    @Id
    @Column(name = "jedi_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(name = "jedi_name")
    @Size(min = 3, max = 20, message = "Name must have between 3 and 20 letters")
    private String name;

    @NotBlank
    @Column(name = "jedi_lastanme")
    @Size(max = 20, message = "Last Name must not have more than 20 letters")
    private String lastname;

    public Jedi(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Jedi() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}