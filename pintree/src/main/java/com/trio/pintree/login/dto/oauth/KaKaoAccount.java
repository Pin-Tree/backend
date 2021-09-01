package com.trio.pintree.login.dto.oauth;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class KaKaoAccount {

    private boolean hasEmail;
    private boolean emailNeedsAgreement;
    private boolean isEmailValid;
    private boolean isEmailVerified;
    private String email;

    @JsonGetter("has_email")
    public boolean isHasEmail() {
        return hasEmail;
    }

    @JsonSetter("has_email")
    public void setHasEmail(boolean hasEmail) {
        this.hasEmail = hasEmail;
    }

    @JsonGetter("email_needs_agreement")
    public boolean isEmailNeedsAgreement() {
        return emailNeedsAgreement;
    }

    @JsonSetter("email_needs_agreement")
    public void setEmailNeedsAgreement(boolean emailNeedsAgreement) {
        this.emailNeedsAgreement = emailNeedsAgreement;
    }

    @JsonGetter("is_email_valid")
    public boolean isEmailValid() {
        return isEmailValid;
    }

    @JsonSetter("is_email_valid")
    public void setEmailValid(boolean emailValid) {
        isEmailValid = emailValid;
    }

    @JsonGetter("is_email_verified")
    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    @JsonSetter("is_email_verified")
    public void setEmailVerified(boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    @JsonGetter("email")
    public String getEmail() {
        return email;
    }

    @JsonSetter("email")
    public void setEmail(String email) {
        this.email = email;
    }

}
