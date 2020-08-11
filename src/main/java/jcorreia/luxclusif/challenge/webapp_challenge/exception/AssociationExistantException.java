package jcorreia.luxclusif.challenge.webapp_challenge.exception;

import jcorreia.luxclusif.challenge.webapp_challenge.errors.ErrorMessage;

public class AssociationExistantException extends ExceptionHandler {

    public AssociationExistantException() {
        super(ErrorMessage.ASSOCIATION_EXISTS);
    }
}
