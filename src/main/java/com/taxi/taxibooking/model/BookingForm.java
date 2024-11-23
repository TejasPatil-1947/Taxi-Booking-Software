package com.taxi.taxibooking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
public class BookingForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @NotEmpty(message = "name cant be empty")
//    @NotBlank(message = "name cant be blank")
//    @Size(min = 2,max = 40, message = "Invalid name length")
//    @Pattern(regexp="^[A-Za-z]+$",message = "Name must contain only alphabets")
    private String name;

//    @NotEmpty(message = "source cant be empty")
//    @NotBlank(message = "from cant be blank")
//    @Size(min = 2,max = 100, message = "Invalid from length")
    private String source;

//    @NotEmpty(message = "email cant be empty")
//    @NotBlank(message = "email cant be blank")
//    @Size(min = 8,max = 50, message = "Invalid email length")
    private  String email;

//    @NotEmpty(message = "destination cant be empty")
//    @NotBlank(message = "to cant be blank")
//    @Size(min = 2,max = 100, message = "Invalid destination length")
    private String destination;
//
//    @NotNull(message = "time cant be empty")
    private LocalTime time;

//    @NotNull(message = "date cant be empty")
    private LocalDate date;

//    @NotEmpty(message = "Invalid comfort length")
    private String comfort;

//    @Min(value = 1, message = "Adult minimum value should be 1")
//    @Max(value = 4,message = "Adult  maximum value should be 1")
    private int adult;

//    @Max(value = 3,message = "Children maximum value should be 3")
    private int children;

//    @NotEmpty(message = "message can't be empty")
//    @NotBlank(message = "message cant be blank")
//    @Size(min = 2,max = 200, message = "Invalid message length")
    private String message;

}
