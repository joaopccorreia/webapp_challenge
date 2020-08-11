package jcorreia.luxclusif.challenge.webapp_challenge.exception;

import jcorreia.luxclusif.challenge.webapp_challenge.errors.ErrorMessage;

public class ClientNotFoundException extends ExceptionHandler {

    public ClientNotFoundException() {
        super(ErrorMessage.CLIENT_NOT_FOUND);
    }
}
