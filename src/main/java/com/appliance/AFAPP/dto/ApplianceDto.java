package com.appliance.AFAPP.dto;

import com.appliance.AFAPP.Model.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplianceDto {


        private Long id;

        private String libele;

        private String dbid;

        private Boolean disponibilite;

        private String reference;
        private TypeDto typeDto;

}
