package org.alertas.alertas_api.services;

import org.alertas.alertas_api.dtos.AlertaDTO;
import org.alertas.alertas_api.entities.AlertaEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAlertasService {
    ResponseEntity<List<AlertaEntity>> getAllAlerts();
    ResponseEntity<String> registerAlert(AlertaDTO alertaDTO);
    ResponseEntity<String> updateAlert(AlertaEntity alerta);
    ResponseEntity<String> deleteAlert(Long id);

}
