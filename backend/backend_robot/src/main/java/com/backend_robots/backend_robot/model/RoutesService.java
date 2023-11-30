package com.backend_robots.backend_robot.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoutesService {

    private final RoutesRepository routesRepository;

    @Autowired
    public RoutesService(RoutesRepository routesRepository) {
        this.routesRepository = routesRepository;
    }

    public List<Routes> getAllRoutes() {
        return routesRepository.findAll();
    }

    public Routes getRouteById(long id) {
        Optional<Routes> routeOptional = routesRepository.findById(id);
        return routeOptional.orElse(null);
    }

    public Routes createRoute(Routes route) {
        return routesRepository.save(route);
    }

    public Routes updateRoute(long id, Routes routeDetails) {
        Optional<Routes> routeOptional = routesRepository.findById(id);
        if (routeOptional.isPresent()) {
            Routes existingRoute = routeOptional.get();
            // Aquí podrías realizar las actualizaciones necesarias en existingRoute con los datos de routeDetails
            // Por ejemplo, existingRoute.setInitialPoint(routeDetails.getInitialPoint());
            // Luego, guarda la ruta actualizada
            return routesRepository.save(existingRoute);
        } else {
            return null;
        }
    }

    public void deleteRoute(long id) {
        routesRepository.deleteById(id);
    }
}
