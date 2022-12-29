package org.azulean.app.repository;

import org.azulean.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoPositionJPA extends JpaRepository<Position, Long> {

   Position findByXAndY(double x, double y);

}