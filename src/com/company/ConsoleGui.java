package com.company;

import java.io.*;
import java.util.Scanner;

public class ConsoleGui extends Gui {

    protected static ConsoleGui instance;

    protected Scanner input;

    protected PrintWriter output;

    protected GuiCallback callback;

    public ConsoleGui(InputStream inputSource, OutputStream outputSink, GuiCallback callback) {
        this.input = new Scanner(inputSource);
        this.output = new PrintWriter(outputSink);
        this.callback = callback;
    }


    @Override
    public void init() {
        print("---- Sample Weather Forecast Application ----");
        menu();
        callback.handleAction(readString());
    }

    @Override
    public void menu() {
        print("Введите желаемое действие (Например: покажи прогноз погоды в Москве на сегодня):");
    }

    @Override
    public void reset() {
        output.write("\033[H\033[2J");
        output.flush();
    }

    @Override
    public void print(String string) {
        output.append(string).append("\n");
        output.flush();
    }

    @Override
    public String readString() {
        return input.nextLine();
    }

    @Override
    public int readInt() {
        return input.nextInt();
    }
}
