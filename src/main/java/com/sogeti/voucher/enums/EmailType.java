package com.sogeti.voucher.enums;

/**
 * Enumeration of e-mail types for a {@link nl.sogeti.voucherwebapp.model.EmailTemplate}.
 * @author Theo Moorman
 */
public enum EmailType {
   EXAM_CHANGED_NEW_VOUCHER,
   EXAM_CHANGED_NO_NEW_VOUCHER,
   EXAM_RESULT,
   REVOKE_VOUCHER_FOR_EXAM,
   NO_VOUCHER_AVAILABLE,
   VOUCHER_ASSIGNED,
   NO_VOUCHER_ASSIGNED_ERROR,
   VOUCHER_THRESHOLD_REACHED;

   public String getLabel() {
      return EmailType.class.getSimpleName() + "." + this.name();
   }
}