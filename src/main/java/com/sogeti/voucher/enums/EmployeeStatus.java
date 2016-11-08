package com.sogeti.voucher.enums;

/**
 * Enumeration of statuses for a {@link nl.sogeti.voucherwebapp.model.Employee}.
 * @author Theo Moorman
 */
public enum EmployeeStatus {
    IN_SERVICE,
    OUT_SERVICE;

    public String getLabel() {
	return EmployeeStatus.class.getSimpleName() + "." + this.name();
    }

    /**
     * Method to get the corresponding EmployeeStatus by its ordinal number.
     * @param number The ordinal number of the status to get.
     * @return EmployeeStatus corresponding with the given number.
     */
    public static EmployeeStatus getByOrdinal(int number) {
	switch(number) {
	case 0:
	    return EmployeeStatus.IN_SERVICE;
	case 1:
	    return EmployeeStatus.OUT_SERVICE;
	default:
	    return EmployeeStatus.IN_SERVICE;
	}
    }
}