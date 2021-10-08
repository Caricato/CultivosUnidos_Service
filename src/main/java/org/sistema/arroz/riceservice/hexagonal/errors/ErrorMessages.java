package org.sistema.arroz.riceservice.hexagonal.errors;

public class ErrorMessages {
    //For Supplies
    public static final String SUP_01_MESSAGE = "Supply with the id: %d not found";
    public static final String SUP_02_MESSAGE = "Actual stock: %.2f is lower than the minimum stock: %.2f. Validate your data please!";
    public static final String SUP_03_MESSAGE = "Supply %d associated with active products. Please remove them first to delete the supply";
    public static final String SUP_04_MESSAGE = "Supply with %d has a limit of %.2f of stock, cant reduce more than that!";
    //For Communities
    public static final String AGC_01_MESSAGE = "Agriculture community with %d id is not registered!";

    //For Products
    public static final String PROD_01_MESSAGE = "Product with the id: %d not found";
    public static final String PROD_02_MESSAGE = "Product price for the product %d in the month %d not found";
    public static final String PROD_03_MESSAGE = "Product has %d sacks and you are trying to sell %d sacks. Validate your data please!";

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

}
