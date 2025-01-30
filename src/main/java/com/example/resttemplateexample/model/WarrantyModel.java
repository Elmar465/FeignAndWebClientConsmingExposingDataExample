package com.example.resttemplateexample.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WarrantyModel {

    private Integer id;
    private Integer duration;
    private String description;
}
