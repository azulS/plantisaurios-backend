package org.azulean.app.repository;

import org.azulean.model.Position;
import org.azulean.model.Tree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path = "position",excerptProjection = Position.class)
public interface RepoPositionJPA extends JpaRepository<Position, Long> {

   Optional <Position> findByX(Double x);
   Optional <Position> findByY(Double y);

}