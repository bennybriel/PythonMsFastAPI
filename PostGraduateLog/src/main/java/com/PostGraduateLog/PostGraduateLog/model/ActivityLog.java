package com.PostGraduateLog.PostGraduateLog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="activitylogs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActivityLog {
    @Id
    @GeneratedValue
    private  long id;
    private String userName;
    private String operation;
    private String ipAddress;
    private String macAddress;
    private String platForm;
    private String browser;
    private String guid;
    private LocalDateTime createdAt;


}
