package org.sistema.arroz.riceservice.hexagonal.errors;

public class ErrorMessages {
    //For Supplies
    public static final String SUP_01_MESSAGE = "Supply with the id: %d not found";
    public static final String SUP_02_MESSAGE = "Actual stock: %d is lower than the minimum stock: %d. Validate your data please!";
    public static final String SUP_03_MESSAGE = "Supply %d associated with active products. Please remove them first to delete the supply";
    //For Communities
    public static final String AGC_01_MESSAGE = "Agriculture community with %d id is not registered!";

    //For Products
    public static final String PROD_01_MESSAGE = "Product with the id: %d not found";

    //For Merchandise Entries
    public static final String MER_01_MESSAGE = "Merchandise Flow with the id: %d not found";
    public static final String MER_02_MESSAGE = "Merchandise Flow with subtype %s not found";

    //For Supply Formulas
    public static final String SUP_FORM_01_MESSAGE = "Supply Formula with the id: %d not found";

}
