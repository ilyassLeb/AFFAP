package com.appliance.AFAPP.Model;
import com.appliance.AFAPP.dto.SeanceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seance extends SeanceDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private Date date_Seance;

    private String resume;

    private String participant ;

    @ManyToOne
    @JoinColumn(name="pov_id", nullable=false)
    private Pov pov;





}
