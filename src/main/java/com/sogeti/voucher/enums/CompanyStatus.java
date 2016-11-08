package com.sogeti.voucher.enums;

/**
 * Enumeration of statuses for a {@link nl.sogeti.voucherwebapp.model.Company}.
 * @author Theo Moorman
 */
public enum CompanyStatus {
    ACTIVE,
    NON_ACTIVE;

    public String getLabel() { 
	return CompanyStatus.class.getSimpleName() + "." + this.name();
    }
}