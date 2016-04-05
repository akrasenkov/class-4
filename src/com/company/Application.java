package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Application implements GuiCallback {

    private static Application app;
    private Gui gui;
    private ApiConnector connector;

    public static void main(String[] args) {
        getInstance().init();
    }

    public static Application getInstance() {
        if (app == null) app = new Application();
        return app;
    }

    public void init() {
        gui = new ConsoleGui(System.in, System.out, this);
        connector = new ApiConnector();
        gui.init();
        gui.print("test");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gui.reset();
    }

    public synchronized Gui getGui() {

        return this.gui;
    }

    @Override
    public void handleAction(String action) {
        printForecast(action);
        getGui().init();
    }

    public void printMenu() {
        System.out.println("1 - get weather forecast for today");
        int option = input.nextInt();
        switch (option) {
            case 1 : printForecast(ForecastMode.TODAY, new GuiCallback() {
                @Override
                public void handleAction(String action) {
                    printForecast();
                }
            });
        }
    }

    public void printForecast(ForecastMode mode, GuiCallback callback) {
        if (mode == ForecastMode.TODAY) {
            try {
                System.out.println(connector.getForecastForToday("Mosoow"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        callback.reset();
    }
}
