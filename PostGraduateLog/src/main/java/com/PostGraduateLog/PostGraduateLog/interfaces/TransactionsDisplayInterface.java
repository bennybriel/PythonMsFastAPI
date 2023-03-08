package com.PostGraduateLog.PostGraduateLog.interfaces;

import java.time.LocalDateTime;

public interface TransactionsDisplayInterface {
     Integer getId();
     Integer getProductID();
     String getMatricno();
     String getDescription();
     String getResponse();
     String getTransactionID();
     Double getAmount();
     String getApptype();
     String getSession();
     String getReferenceID();
     String getTrans_id();
     String getUrl();
     String getPaymenttype();
     String getEmail();
     String getActivesession();
     String getName();
     String getSurname();
     String getFirstname();
     String getOthername();
     String getUtme();
     String getFormnumber();
     String getUsertype();
     String getMatric();
     String getGuid();
     Boolean getIspaid();
     Boolean getStatus();
     LocalDateTime getUpdated_at();
     LocalDateTime getCreated_at();
}
