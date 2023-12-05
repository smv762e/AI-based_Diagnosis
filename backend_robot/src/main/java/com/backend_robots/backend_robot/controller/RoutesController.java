package com.backend_robots.backend_robot.controller;

import com.backend_robots.backend_robot.model.Routes;
import com.backend_robots.backend_robot.service.RoutesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RoutesController {

    private final RoutesService routesService;

    @Autowired
    public RoutesController(RoutesService routesService) {
        this.routesService = routesService;
    }

    @GetMapping
    public ResponseEntity<List<Routes>> getAllRoutes() {
        List<Routes> routes = routesService.getAllRoutes();
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Routes> getRouteById(@PathVariable("id") long id) {
        Routes route = routesService.getRouteById(id);
        if (route != null) {
            return new ResponseEntity<>(route, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Routes> createRoute(@RequestBody Routes route) {
        Routes createdRoute = routesService.createRoute(route);
        return new ResponseEntity<>(createdRoute, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Routes> updateRoute(
            @PathVariable("id") long id,
            @RequestBody Routes routeDetails) {
        Routes updatedRoute = routesService.updateRoute(id, routeDetails);
        if (updatedRoute != null) {
            return new ResponseEntity<>(updatedRoute, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRoute(@PathVariable("id") long id) {
        routesService.deleteRoute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
