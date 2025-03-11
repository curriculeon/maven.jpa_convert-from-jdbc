package com.github.curriculeon.lib.controller;

import com.github.curriculeon.lib.service.ServiceInterface;

/**
 * Created by leon on 8/14/2020.
 */
abstract public class AbstractController<
        ServiceType extends ServiceInterface>
        implements ControllerInterface<ServiceType> {
    private ServiceType service;

    public AbstractController(ServiceType service) {
        this.service = service;
    }
`
    @Override
    public ServiceType getService() {
        return service;
    }
}
