package com.intech.session8.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Employee {
    int id;
    String name;
    Double salary;
}
