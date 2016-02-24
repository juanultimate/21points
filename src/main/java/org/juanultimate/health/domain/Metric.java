package org.juanultimate.health.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Metric.
 */
@Entity
@Table(name = "metric")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "metric")
public class Metric implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2)
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "amount", nullable = false)
    private String amount;

    @ManyToMany(mappedBy = "metrics")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Entry> emtrys = new HashSet<Entry>();

    @ManyToMany(mappedBy = "metrics")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Goal> goals = new HashSet<Goal>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Set<Entry> getEmtrys() {
        return emtrys;
    }

    public void setEmtrys(Set<Entry> ys) {
        this.emtrys = ys;
    }

    public Set<Goal> getGoals() {
        return goals;
    }

    public void setGoals(Set<Goal> goals) {
        this.goals = goals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Metric metric = (Metric) o;
        if(metric.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, metric.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Metric{" +
            "id=" + id +
            ", name='" + name + "'" +
            ", amount='" + amount + "'" +
            '}';
    }
}
