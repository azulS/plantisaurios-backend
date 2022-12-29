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
import java.util.Optional;

@RestController

// TODO: 12/29/2022 repositoryRestController no funciona...no sabemos porque
public class TreeControllerComplement {

    @Autowired
    RepoTreeJPA repoTreeJPA;
    @Autowired
    private RepoPositionJPA repoPositionJPA;

    @GetMapping(path = "/trees")
    public @ResponseBody ResponseEntity<List<Tree>> getTrees() throws Exception{
        List<Tree> mockTrees = repoTreeJPA.findAll();
        return ResponseEntity.ok(mockTrees);
    }

    @GetMapping(path = "/mocktrees")
    public @ResponseBody ResponseEntity<List<Tree>> getMockTrees() throws Exception{
        List<Tree> trees = new ArrayList<>();
        trees.add(new Tree("morera", new Position(1, 1)));
        trees.add(new Tree("naranjo", new Position(2, 2)));

        return ResponseEntity.ok(trees);
    }

//    public List<Tree> getMockTrees() {
//        List<Tree> trees = new ArrayList<>();
//        trees.add(new Tree("morera", new Position(1, 1)));
//        trees.add(new Tree("naranjo", new Position(2, 2)));
//        return trees;
//    }

    @Transactional
    @PostMapping("/tress")
    public @ResponseBody ResponseEntity<Object> addTree(
            @RequestBody Tree newTree
    )throws Exception {
        Optional<Position> positionOptional =
                Optional.ofNullable(repoPositionJPA.findByXAndY(newTree.getPosition().getX(), newTree.getPosition().getY()));
        try {
            if (!positionOptional.isPresent()) {
                repoTreeJPA.save(newTree);

                Tree newTreeOptional = new Tree(newTree.getProduce(), newTree.getPosition());
                repoTreeJPA.save(newTreeOptional);
                return ResponseEntity.ok(newTreeOptional.getId());

            }
            Exception e= new PositionException("ya hay un tree en esa position", newTree.getPosition());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
