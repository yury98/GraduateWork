package controllers.mail;

import controllers.connections.GetProperties;

public class SMTPServerConnection {
    public void connect() {
        GetProperties.getSMPTProperties();
    }
}
