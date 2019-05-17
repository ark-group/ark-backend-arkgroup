package com.arkbackendarkgroup.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class VisitorController {

    private static final List<String> VISITORS = new ArrayList<>();

    @PostMapping("")
    public ResponseEntity<?> writeDownVisitor(final @RequestBody Map<String, Object> input) {
        if (input.containsKey("name") && input.get("name") != null) {
            VISITORS.add(input.get("name").toString());
            return ResponseEntity.ok(VISITORS);
        }
        else
            return ResponseEntity.badRequest().body("'name' is required.");
    }
}
