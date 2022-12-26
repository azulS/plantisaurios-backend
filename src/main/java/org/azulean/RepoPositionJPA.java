package org.azulean;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoPositionJPA extends JpaRepository<Position, Long> {

   Position findByXAndY(double x, double y);
   Position findByPosition(Position position);


}