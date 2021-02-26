package com.example.application;

import com.vaadin.flow.component.WebComponentExporter;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.webcomponent.WebComponent;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

public class ServerInfo extends Div {

    public ServerInfo() {
        add(new Label("I am from the Java world"));
        SystemInfo systemInfo = new SystemInfo();
        HardwareAbstractionLayer hardwareAbstractionLayer = systemInfo.getHardware();

        CentralProcessor p = hardwareAbstractionLayer.getProcessor();
        add(new Button("Hello server", e -> {
            Notification.show("Server has " + p.getLogicalProcessorCount() + " processors running on "
                    + p.getMaxFreq() / 1000.0 / 1000.0 / 1000.0 + "GHz");
        }));
    }

    public static class Exporter extends WebComponentExporter<ServerInfo> {
        public Exporter() {
            super("server-info");
        }

        @Override
        protected void configureInstance(WebComponent<ServerInfo> webComponent, ServerInfo info) {
        }
    }
}
