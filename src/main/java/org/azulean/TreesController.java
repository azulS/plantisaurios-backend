package org.azulean;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TreesController {
    @GetMapping("/trees")
    public @ResponseBody ResponseEntity<List<Tree>> getTrees() {
        List<Tree> mockTrees = getMockTrees();
        return ResponseEntity.ok(mockTrees);
    }

    public List<Tree> getMockTrees() {
        List<Tree> trees = new ArrayList<>();
        trees.add(new Tree("morera", new Position(1, 1)));
        trees.add(new Tree("naranjo", new Position(2, 2)));
        return trees;
    }
}
