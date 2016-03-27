package org.zayim.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "SUPERHEROES")
public class Superhero implements Serializable {

    private static final int serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name must not be empty")
    private String name;

    private String pseudonym;

    private String publisher;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="SKILLS", joinColumns=@JoinColumn(name="superheroId"))
    @Column(name="skill")
    private Set<String> skills = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="ALLIES", joinColumns=@JoinColumn(name="superheroId"))
    @Column(name="ally")
    private Set<String> allies = new HashSet<>();

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date firstAppearance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public Set<String> getAllies() {
        return allies;
    }

    public void setAllies(Set<String> allies) {
        this.allies = allies;
    }

    public Date getFirstAppearance() {
        return firstAppearance;
    }

    public void setFirstAppearance(Date firstAppearance) {
        this.firstAppearance = firstAppearance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Superhero superhero = (Superhero) o;

        if (id != null ? !id.equals(superhero.id) : superhero.id != null) return false;
        if (name != null ? !name.equals(superhero.name) : superhero.name != null) return false;
        if (pseudonym != null ? !pseudonym.equals(superhero.pseudonym) : superhero.pseudonym != null) return false;
        if (publisher != null ? !publisher.equals(superhero.publisher) : superhero.publisher != null) return false;
        if (skills != null ? !skills.equals(superhero.skills) : superhero.skills != null) return false;
        if (allies != null ? !allies.equals(superhero.allies) : superhero.allies != null) return false;
        return firstAppearance != null ? firstAppearance.equals(superhero.firstAppearance) : superhero.firstAppearance == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pseudonym != null ? pseudonym.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + (skills != null ? skills.hashCode() : 0);
        result = 31 * result + (allies != null ? allies.hashCode() : 0);
        result = 31 * result + (firstAppearance != null ? firstAppearance.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Superhero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pseudonym='" + pseudonym + '\'' +
                ", publisher='" + publisher + '\'' +
                ", skills=" + skills +
                ", allies=" + allies +
                ", firstAppearance=" + firstAppearance +
                '}';
    }
}
