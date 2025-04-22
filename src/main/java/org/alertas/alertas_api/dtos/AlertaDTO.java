package org.alertas.alertas_api.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlertaDTO {
    private String mensaje;
    private String nivel;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechacreacion;
}
