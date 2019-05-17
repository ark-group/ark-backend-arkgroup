package com.arkbackendarkgroup.repository;

import com.arkbackendarkgroup.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor,String> {
}
