package com.github.curriculeon.lib.controller;

import com.github.curriculeon.lib.service.ServiceInterface;

public interface ControllerInterface<ServiceType extends ServiceInterface> {
    ServiceType getService();
    void displayById();
    void displayAll();
    void delete();
    void update();
    void create();
}
