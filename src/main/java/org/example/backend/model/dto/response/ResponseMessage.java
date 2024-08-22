package org.example.backend.model.dto.response;



public interface ResponseMessage {
    String SUCCESS= "Success.";

    String VALIDATION_FAIL = "Validation failed.";
    String DUPLICATE_ID = "Duplicated id.";
    String SIGN_IN_FAIL = "Login information mismatch.";
    String CERTIFICATION_FAIL = "Certification failed.";
    String DATABASE_ERROR = "Database error.";

    String MAIL_FAIL="Mail send failed.";
}
