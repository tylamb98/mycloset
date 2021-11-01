package edu.neiu.mycloset.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Outfit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //Instance variables with validation
    private long id;
    @NotBlank(message = "Required field")
    @Size(min = 2, message = "Must be two or more characters.")
    private String top;

    @NotBlank(message = "Required field")
    @Size(min = 2, message = "Must be two or more characters.")
    private String bottom;

    @NotBlank(message = "Required field")
    @Size(min = 2, message = "Must be two or more characters.")
    private String shoes;

    private LocalDateTime created;
    private LocalDateTime modified;


    //Constructors
    public Outfit() {
        this.top = "";
        this.bottom = "";
        this.shoes = "";

    }
    public Outfit(String top, String bottom, String shoes) {
        this.top = top;
        this.bottom = bottom;
        this.shoes = shoes;
    }

    //Getters & Setters
    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public String getShoes() {
        return shoes;
    }

    public void setShoes(String shoes) {
        this.shoes = shoes;
    }
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    @PrePersist
    public void onCreat() {
        this.setCreated(LocalDateTime.now());
        this.setModified(LocalDateTime.now());
    }

    @PreUpdate
    public void onUpdate() {
        this.setModified(LocalDateTime.now());
    }

}
