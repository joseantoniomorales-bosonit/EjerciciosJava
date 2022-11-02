package com.bosonit.block7crudvalidation.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "persona")
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id_persona;

    @Column(name="usuario")
    private String usuario;
    @Column(name="password")
    private String password;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="company_email")
    private String company_email;
    @Column(name="personal_email")
    private String personal_email;
    @Column(name="city")
    private String city;
    @Column(name="imagen_url")
    private String imagen_url;

    @Column(name="active")
    private boolean active;

    @Column(name="created_date")
    private LocalDate created_date;
    @Column(name="termination_date")
    private LocalDate termination_date;

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCompany_email() {
        return company_email;
    }

    public void setCompany_email(String company_email) {
        this.company_email = company_email;
    }

    public String getPersonal_email() {
        return personal_email;
    }

    public void setPersonal_email(String personal_email) {
        this.personal_email = personal_email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getImagen_url() {
        return imagen_url;
    }

    public void setImagen_url(String imagen_url) {
        this.imagen_url = imagen_url;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDate getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDate created_date) {
        this.created_date = created_date;
    }

    public LocalDate getTermination_date() {
        return termination_date;
    }

    public void setTermination_date(LocalDate termination_date) {
        this.termination_date = termination_date;
    }

    @Override
    public String toString() {
        return "PersonaEntity{" +
                "id_persona=" + id_persona +
                ", usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", company_email='" + company_email + '\'' +
                ", personal_email='" + personal_email + '\'' +
                ", city='" + city + '\'' +
                ", imagen_url='" + imagen_url + '\'' +
                ", active=" + active +
                ", created_date=" + created_date +
                ", termination_date=" + termination_date +
                '}';
    }
}
