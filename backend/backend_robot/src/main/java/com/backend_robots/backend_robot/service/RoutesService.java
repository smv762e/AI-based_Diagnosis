package com.backend_robots.backend_robot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend_robots.backend_robot.model.Routes;
import com.backend_robots.backend_robot.repository.RepositoryRoutes;

import java.util.List;
import java.util.Optional;

@Service
public class RoutesService {

    private final RepositoryRoutes repositoryRoutes;

    @Autowired
    public RoutesService(RepositoryRoutes repositoryRoutes) {
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
            // Aquí podrías realizar las actualizaciones necesarias en existingRoute con los datos de routeDetails
            // Por ejemplo, existingRoute.setInitialPoint(routeDetails.getInitialPoint());
            // Luego, guarda la ruta actualizada
            return repositoryRoutes.save(existingRoute);
        } else {
            return null;
        }
    }

    public void deleteRoute(long id) {
        repositoryRoutes.deleteById(id);
    }
}
