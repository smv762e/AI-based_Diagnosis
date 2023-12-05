package com.backend_robots.backend_robot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend_robots.backend_robot.model.Routes;
import com.backend_robots.backend_robot.repository.RoutesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoutesService {

    private final RoutesRepository repositoryRoutes;

    @Autowired
    public RoutesService(RoutesRepository repositoryRoutes) {
        this.repositoryRoutes = repositoryRoutes;
    }

    public List<Routes> getAllRoutes() {
        return repositoryRoutes.findAll();
    }

    public Routes getRouteById(long id) {
        Optional<Routes> routeOptional = repositoryRoutes.findById(id);
        return routeOptional.orElse(null);
    }

    public Routes createRoute(Routes route) {
        return repositoryRoutes.save(route);
    }

    public Routes updateRoute(long id, Routes routeDetails) {
        Optional<Routes> routeOptional = repositoryRoutes.findById(id);
        if (routeOptional.isPresent()) {
            Routes existingRoute = routeOptional.get();
            return repositoryRoutes.save(existingRoute);
        } else {
            return null;
        }
    }

    public void deleteRoute(long id) {
        repositoryRoutes.deleteById(id);
    }
}
