package com.managepoint.managepoint.pojo;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailSubscriberPojo {
    @NotEmpty(message="S-ID cannot be empty")
    private Integer s_id;
    @NotEmpty(message="E-ID cannot be empty")
    private Integer e_id;
    @NotEmpty(message = "Date cannot be empty")
   private Date e_date;
}
