package com.postgraduate.PostGraduate.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;

@Document(value="report")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class Report {
    @Id
    private String id;
    private String  apptype;
    private String matricno;
    private String name;
    private String description;
    private BigDecimal amount;
}
