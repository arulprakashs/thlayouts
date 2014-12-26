package com.pos.message;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String title;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id", nullable = false, referencedColumnName="id")    
    private Person person;
    
    @NotEmpty
    private String text;

    @Version
    private Calendar created = Calendar.getInstance();

    public Message() {
    }

    public Message(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }
}
