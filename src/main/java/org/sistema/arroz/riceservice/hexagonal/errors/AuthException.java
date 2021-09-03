package org.sistema.arroz.riceservice.hexagonal.errors;

/**
 * Auth exception should be used when the user has not authorization
 * to execute the service or use information that is not allow to use.
 **/
public interface AuthException extends BusinessException {
}
