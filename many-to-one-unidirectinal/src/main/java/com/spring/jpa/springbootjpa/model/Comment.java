package com.spring.jpa.springbootjpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.awt.print.Book;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tutorial_id", nullable = false)
    //https://www.concretepage.com/hibernate/example-ondelete-hibernate
    // https://rogerkeays.com/jpa-cascadetype-remove-vs-hibernate-ondelete
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore // needed since we have lazy loading of this field.
    private Tutorial tutorial;
}