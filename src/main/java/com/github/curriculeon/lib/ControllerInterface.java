package com.github.curriculeon.lib;

import com.github.curriculeon.lib.ServiceInterface;

public interface ControllerInterface<ServiceType extends ServiceInterface> {
    ServiceType getService();
    void displayById();
    void displayAll();
    void delete();
    void update();
    void create();
}
