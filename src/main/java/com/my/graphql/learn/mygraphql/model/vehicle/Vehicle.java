package com.my.graphql.learn.mygraphql.model.vehicle;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@EqualsAndHashCode
@Builder
public class Vehicle implements Serializable {

//    @Id
//    @Column(name = "ID", nullable = false)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    //@Column(name = "type", nullable = false)
    private String type;

    //@Column(name = "model_code", nullable = false)
    private String modelCode;

    //@Column(name = "brand_name")
    private String brandName;

    //@Column(name = "launch_date")
    private LocalDate launchDate;

    private transient  String formattedDate;

    // Getter and setter
    public String getFormattedDate() {
        return getLaunchDate().toString();
    }
}
