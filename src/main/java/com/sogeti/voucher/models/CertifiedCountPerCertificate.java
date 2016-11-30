package com.sogeti.voucher.models;

import java.io.Serializable;

/**
 * Class that holds attributes for the number of certified {@link Employee}s per {@link Certificate} of a {@link Company}.
 * This class implements the {@link Serializable} interface.
 * @author Theo Moorman
 */
public class CertifiedCountPerCertificate implements Serializable {

    private static final long serialVersionUID = -7655312037784277279L;
    
    private String companyName, certificateName, certificateAbbreviation;
    private Long certifiedCount;
    
    public CertifiedCountPerCertificate() {
	super();
    }
    
    /**
     * @param companyName Name of the company.
     * @param certificateName Name of the certificate.
     * @param certificateAbbreviation Abbreviation of the certificate.
     * @param certifiedCount Number of certified employees for this certificate.
     */
    public CertifiedCountPerCertificate(String companyName, String certificateName, String certificateAbbreviation, 
	    Long certifiedCount) {
	this();
	setCompanyName(companyName);
	setCertificateName(certificateName);
	setCertificateAbbreviation(certificateAbbreviation);
	setCertifiedCount(certifiedCount);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateAbbreviation() {
        return certificateAbbreviation;
    }

    public void setCertificateAbbreviation(String certificateAbbreviation) {
        this.certificateAbbreviation = certificateAbbreviation;
    }

    public Long getCertifiedCount() {
        return certifiedCount;
    }

    public void setCertifiedCount(Long certifiedCount) {
        this.certifiedCount = certifiedCount;
    }
}