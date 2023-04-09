package com.appliance.AFAPP.Model;


import com.appliance.AFAPP.dto.TypeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String libele;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appliance_id", referencedColumnName = "id")
    private Appliance appliance;


}
