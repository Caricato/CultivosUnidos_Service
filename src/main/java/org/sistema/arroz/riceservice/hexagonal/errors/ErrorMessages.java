package org.sistema.arroz.riceservice.hexagonal.errors;

public class ErrorMessages {
    //For Supplies
    public static final String SUP_01_MESSAGE = "Supply with the id: %d not found";
    public static final String SUP_02_MESSAGE = "Actual stock: %.2f is lower than the minimum stock: %.2f. Validate your data please!";
    public static final String SUP_03_MESSAGE = "Supply %d associated with active products. Please remove them first to delete the supply";
    public static final String SUP_04_MESSAGE = "Supply with %d has a limit of %.2f of stock, cant reduce more than that!";
    public static final String SUP_05_MESSAGE = "Unit metric with id: %d not found";
    public static final String SUP_06_MESSAGE = "Unit metric with id: %d not valid to delete";
    //For Communities
    public static final String AGC_01_MESSAGE = "Agriculture community with %d id is not registered!";
    public static final String AGC_02_MESSAGE = "Agriculture community a supervisor with dni %d not registered!";

    //For Products
    public static final String PROD_01_MESSAGE = "Product with the id: %d not found";
    public static final String PROD_02_MESSAGE = "Product price for the product %d in the month %d not found";
    public static final String PROD_03_MESSAGE = "Product has %d sacks and you are trying to sell %d sacks. Validate your data please!";
    public static final String PROD_04_MESSAGE = "Product with the id: %d not valid to delete!";

    //For Merchandise Entries
    public static final String MER_01_MESSAGE = "Merchandise Flow with the id: %d not found";
    public static final String MER_02_MESSAGE = "Merchandise Flow with subtype %s not found";

    //For Supply Formulas
    public static final String SUP_FORM_01_MESSAGE = "Supply Formula with the id: %d not found";

    //For Sales
    public static final String SALE_01_MESSAGE = "Sale not valid!";
    public static final String SALE_02_MESSAGE = "Sale with the id: %d not found";

    //For Users
    public static final String USR_01_MESSAGE = "Producer with DNI: %s already registered!";
    public static final String USR_02_MESSAGE = "Producer with the id: %d not found";
    public static final String USR_03_MESSAGE = "User with the id: %d not found";
    public static final String USR_04_MESSAGE = "Login invalid! Check credentials";
    public static final String USR_05_MESSAGE = "User with the username: %s not found";
    public static final String USR_06_MESSAGE = "Supervisor with DNI: %s already registered!";
    public static final String USR_07_MESSAGE = "Producer with Email: %s already registered!";
    public static final String USR_08_MESSAGE = "Producer with Phone Number: %s already registered!";
    public static final String USR_09_MESSAGE = "Producer with the id: %d not valid to delete!";
    public static final String USR_PROD_01_MESSAGE = "Could not register producer!";

    //For Schedule
    public static final String CRG_01_MESSAGE = "Schedule date is not valid";
    public static final String CRG_02_MESSAGE = "Stock to produce %.2f hectares of product with id %d is not enough for production";
    public static final String CRG_03_MESSAGE = "Actual hectares are %.2f hectares and we need %.2f hectares";
    public static final String CRG_04_MESSAGE = "Not enough supplies to produce";
    public static final String CRG_05_MESSAGE = "Schedule with the id %d not found";
    public static final String CRG_06_MESSAGE = "Schedule Detail with the id %d not found";
    public static final String CRG_07_MESSAGE = "Schedule with the id %d not valid for deletion";
    public static final String CRG_08_MESSAGE = "Schedule with the id %d not valid for completion";
    public static final String CRG_99_MESSAGE = "Hectares and/or producers are not valid!";

    //For Parameters
    public static final String PARAM_01_MESSAGE = "Parameters not loaded correctly. Please contact the administrator!";

    //For Notifications
    public static final String SMS_01_MESSAGE= "Error in sending SMS notification. Contact the administrator!. Exception: %s";
    public static final String MAIL_01_MESSAGE= "Error in sending Mail message. Contact the administrator!. Exception: %s";
}
