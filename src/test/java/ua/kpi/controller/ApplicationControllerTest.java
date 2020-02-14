package ua.kpi.controller;

import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import ua.kpi.command.operations.AbsCommand;
import ua.kpi.facade.ApplicationFacade;
import ua.kpi.factory.OperationRequestFactoryImpl;
import ua.kpi.ui.util.InputProvider;


@RunWith(PowerMockRunner.class)
@PrepareForTest({ApplicationController.class, ApplicationFacade.class, LogManager.class})
public class ApplicationControllerTest {
    private ApplicationController underTest;
    private ApplicationFacade applicationFacade;

    @Before
    public void setUp() {
        PowerMockito.mockStatic(LogManager.class);
        Logger logger = PowerMockito.mock(Logger.class);
        PowerMockito.when(LogManager.getLogger(InputProvider.class)).thenReturn(logger);
        PowerMockito.when(LogManager.getLogger(OperationRequestFactoryImpl.class)).thenReturn(logger);
        PowerMockito.when(LogManager.getLogger(AbsCommand.class)).thenReturn(logger);

        PowerMockito.mockStatic(ApplicationFacade.class);
        applicationFacade = mock(ApplicationFacade.class);
        when(ApplicationFacade.getInstance()).thenReturn(applicationFacade);
        underTest = ApplicationController.getInstance();
        underTest.setApplicationFacade(applicationFacade);
    }


    @Test
    public void processActionControl() {
        PowerMockito.mockStatic(ApplicationFacade.class);
        applicationFacade = mock(ApplicationFacade.class);
        when(ApplicationFacade.getInstance()).thenReturn(applicationFacade);

        underTest.setApplicationFacade(applicationFacade);
        doNothing().when(applicationFacade).process(any());
        underTest.processActionControl();
        assertFalse(underTest.getCommands().isEmpty());
    }
}