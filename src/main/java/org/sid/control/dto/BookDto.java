package org.sid.control.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BookDto {
    String titre;
    String publisher;
    Date datepublication;
    double price;
    String resume;
}
