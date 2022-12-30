package org.azulean.app.repository;

import org.azulean.model.Tree;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "tree",excerptProjection = Tree.class)
public interface RepoTreeJPA extends JpaRepository<Tree, Long> {
    @Override
    @RestResource(exported = false)
    void deleteById(Long id);

    @Override
    @RestResource(exported = false)
    void delete(Tree id);

    Page<Tree> findById(Long idTree, Pageable page);
    Page<Tree> findByProduce(String produce, Pageable page);
}
