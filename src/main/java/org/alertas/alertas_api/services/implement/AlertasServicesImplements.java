package org.alertas.alertas_api.services.implement;

import org.alertas.alertas_api.dtos.AlertaDTO;
import org.alertas.alertas_api.entities.AlertaEntity;
import org.alertas.alertas_api.repositories.AlertasRepository;
import org.alertas.alertas_api.services.IAlertasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlertasServicesImplements implements IAlertasService {

    @Autowired
    private AlertasRepository alertaRepository;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<List<AlertaEntity>> getAllAlerts() {
        List<AlertaEntity> alertas = alertaRepository.findAll();
        return new ResponseEntity<>(alertas, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<String> registerAlert(AlertaDTO alertaDTO) {
        try {
            AlertaEntity nuevaAlerta = new AlertaEntity();
            nuevaAlerta.setMensaje(alertaDTO.getMensaje());
            nuevaAlerta.setNivel(alertaDTO.getNivel());
            nuevaAlerta.setFechacreacion(alertaDTO.getFechacreacion());

            alertaRepository.save(nuevaAlerta);
            return ResponseEntity.ok("Alerta registrada exitosamente");
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(404).body("Failed: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Bad Server Response: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public ResponseEntity<String> updateAlert(AlertaEntity alerta) {
        try {
            AlertaEntity alertaExistente = alertaRepository.findById(alerta.getId())
                    .orElseThrow(() -> new RuntimeException("Alerta no encontrada"));

            alertaExistente.setMensaje(alerta.getMensaje());
            alertaExistente.setNivel(alerta.getNivel());
            alertaExistente.setFechacreacion(alerta.getFechacreacion());

            alertaRepository.save(alertaExistente);
            return ResponseEntity.status(HttpStatus.CREATED).body("Alerta actualizada con éxito");
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(404).body("Failed: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Bad Server Response: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public ResponseEntity<String> deleteAlert(Long id) {
        try {
            alertaRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Alerta eliminada correctamente");
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(404).body("Failed: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Bad Server Response: " + e.getMessage());
        }
    }
}