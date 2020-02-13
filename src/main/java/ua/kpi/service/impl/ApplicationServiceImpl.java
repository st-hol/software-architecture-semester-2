package ua.kpi.service.impl;

import ua.kpi.service.ApplicationService;

public class ApplicationServiceImpl implements ApplicationService {

    private static ApplicationServiceImpl instance;

    private ApplicationServiceImpl() {
    }

    public static ApplicationServiceImpl getInstance() {
        if (instance == null) {
            synchronized (ApplicationServiceImpl.class) {
                if (instance == null) {
                    instance = new ApplicationServiceImpl();
                }
            }
        }
        return instance;
    }
}
