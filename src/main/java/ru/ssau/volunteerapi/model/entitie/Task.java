package ru.ssau.volunteerapi.model.entitie;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "wish")
    private String wish;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event eventId;
}
