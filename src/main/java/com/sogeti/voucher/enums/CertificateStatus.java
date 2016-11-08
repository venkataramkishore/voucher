package com.sogeti.voucher.enums;

/**
 * Enumeration of statuses for a {@link nl.sogeti.voucherwebapp.model.Certificate}.
 * @author Theo Moorman
 */
public enum CertificateStatus {
    ISSUED,
    DISCONTINUED;

    public String getLabel() { 
	return CertificateStatus.class.getSimpleName() + "." + this.name();
    }
}