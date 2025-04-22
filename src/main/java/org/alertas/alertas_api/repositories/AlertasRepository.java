package org.alertas.alertas_api.repositories;

import org.alertas.alertas_api.entities.AlertaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertasRepository extends JpaRepository<AlertaEntity, Long> {
}
