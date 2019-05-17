package com.arkbackendarkgroup.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Visitor {
    @Id
    private String id;
    private String name;
}
