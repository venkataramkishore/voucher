package com.sogeti.voucher.enums;

/**
 * Enumeration of statuses for a {@link nl.sogeti.voucherwebapp.model.Exam}.
 * @author Theo Moorman
 */
public enum ExamStatus {
    SUCCEEDED,
    FAILED,
    PENDING,
    NO_VOUCHER,
    UNKNOWN;
    
    public String getLabel() {
	return ExamStatus.class.getSimpleName() + "." + this.name();
    }
    
    public String getValue() {
        	return this.name();
        }
    
}

