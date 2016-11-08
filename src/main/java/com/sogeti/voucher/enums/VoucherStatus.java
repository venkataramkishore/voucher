package com.sogeti.voucher.enums;

/**
 * Enumeration of statuses for a {@link nl.sogeti.voucherwebapp.model.Voucher}.
 * @author Theo Moorman
 */
public enum VoucherStatus {
    ASSIGNED,
    USED,
    AVAILABLE,
    EXPIRED;

    public String getLabel() {
	return VoucherStatus.class.getSimpleName() + "." + this.name();
    }
}