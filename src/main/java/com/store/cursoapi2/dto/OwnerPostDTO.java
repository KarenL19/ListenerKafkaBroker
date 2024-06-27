package com.store.cursoapi2.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude
@Builder
public class OwnerPostDTO {
    private String name;
    private String type;
    private String contactNumber;
}
