package org.sistema.arroz.riceservice.hexagonal.errors;

/**
 * Business exception should be used when the user requests
 * a service and breaks a business rule (domain or application).
 **/

public interface BusinessException {
    String getMessage();
    String getCode();
    Object getData();
}