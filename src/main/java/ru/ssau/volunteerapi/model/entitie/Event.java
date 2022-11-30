package ru.ssau.volunteerapi.model.entitie;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {
    @Id
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "volunteer_amount")
    private Integer volunteerAmount;

    @Column(name = "place")
    private String place;

    @Column(name = "started_day")
    private Date startedDay;

    @Column(name = "ended_day")
    private Date endedDay;

    @Column(name = "started_time")
    private Time startedTime;
}
