package org.alertas.alertas_api.controllers;

import org.alertas.alertas_api.dtos.AlertaDTO;
import org.alertas.alertas_api.entities.AlertaEntity;
import org.alertas.alertas_api.services.IAlertasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerta")
public class AlertaController {

    @Autowired
    private IAlertasService alertasService;

    // listar todas las alertas
    @GetMapping("/todas")
    public ResponseEntity<List<AlertaEntity>> getAllAlertas() {
        return alertasService.getAllAlerts();
    }

    // crear una alerta con un DTO en el cuerpo de la petición
    @PostMapping("/crear")
    public ResponseEntity<String> create(@RequestBody AlertaDTO alertaDTO) {
        return alertasService.registerAlert(alertaDTO);
    }

    // actualizar una alerta registrada
    @PutMapping("/actualizar")
    public ResponseEntity<String> update(@RequestBody AlertaEntity alerta) {
        return alertasService.updateAlert(alerta);
    }

    // eliminar una alerta por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAlerta(@PathVariable("id") Long id) {
        return alertasService.deleteAlert(id);
    }
}
