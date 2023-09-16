package com.employeedata.us;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@JsonInclude(value=JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder(alphabetic = true)
@JsonPropertyOrder({"name","job"})
public class EmployeeData {

    private String name;
    private String job;
   private int id;
   private String createdAt;

}
