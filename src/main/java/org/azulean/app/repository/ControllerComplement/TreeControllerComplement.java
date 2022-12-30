package org.azulean.app.repository.ControllerComplement;

import org.azulean.app.PositionException;
import org.azulean.app.repository.RepoPositionJPA;
import org.azulean.app.repository.RepoTreeJPA;
import org.azulean.model.Position;
import org.azulean.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RepositoryRestController

public class TreeControllerComplement {

    @Autowired
    RepoTreeJPA repoTreeJPA;
    @Autowired
    private RepoPositionJPA repoPositionJPA;

    @GetMapping(path = "/tree/all")
    public @ResponseBody ResponseEntity<List<Tree>> getTrees() throws Exception{
        List<Tree> mockTrees = repoTreeJPA.findAll();
        return ResponseEntity.ok(mockTrees);
    }

    @GetMapping(path = "/tree/mocktrees")
    public @ResponseBody ResponseEntity<List<Tree>> getMockTrees() throws Exception{
        List<Tree> trees = new ArrayList<>();
        trees.add(new Tree("morera", new Position(1, 1)));
        trees.add(new Tree("naranjo", new Position(2, 2)));

        return ResponseEntity.ok(trees);
    }
    @PostMapping("/tree/positionNueva/{x}/{y}")
    public @ResponseBody ResponseEntity<Object> addNewPosition(
            @PathVariable ("x") Double x,
            @PathVariable ("y") Double y
    )throws Exception {
        Optional <Position> positionOptional = repoPositionJPA.findByX(x);
        if (positionOptional.isPresent()) {
            if (positionOptional.get().getY()==y) {
                return ResponseEntity.ok("ya hay un tree en esa position");
            }
        }
            Position positionNueva = new Position(x, y);
            repoPositionJPA.save(positionNueva);
            return ResponseEntity.ok(positionNueva.getId());
    }

    @PostMapping("/tree/nuevo/{x}/{y}/{produce}")
    public @ResponseBody ResponseEntity<Object> addNewTree(
            @PathVariable ("x") Double x,
            @PathVariable ("y") Double y,
            @PathVariable ("produce") String produce
    )throws Exception {
        Optional <Position> positionOptional = repoPositionJPA.findByX(x);
        if (positionOptional.isPresent()) {
            if (positionOptional.get().getY()==y) {
                return ResponseEntity.ok("ya hay un tree en esa position");
            }
        }
        Position positionNueva = new Position(x, y);
        Tree treeNuevo = new Tree(produce, positionNueva);
        repoTreeJPA.save(treeNuevo);
        repoPositionJPA.save(positionNueva);
        return ResponseEntity.ok(treeNuevo.getId());
    }

}