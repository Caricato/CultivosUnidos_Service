package org.sistema.arroz.riceservice.hexagonal.sms;

public class Messages {
    public static final String SMS_TO_RESET = "Estimado %s %s:\n Se envió a su correo el enlace para restablecer su contraseña.";
    public static final String SMS_TO_PEND = "Estimado %s %s:\n Se programó un cronograma para el dia %s, teniendo usted que cultivar %.2f hectáreas del producto %s";
    public static final String SMS_TO_START = "Estimado %s %s:\n Se inició el cronograma al dia de hoy, teniendo como fecha de culminación el dia %s, teniendo usted que cultivar %.2f hectáreas del producto %s";
    public static final String SMS_TO_FINISH  = "Estimado %s %s:\n Se finalizó el cronograma el dia de hoy, habiendose cultivado por su parte %.2f hectáreas del producto %s";

}
