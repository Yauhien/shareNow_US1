package com.pages;

import com.enums.ApplicationPages;
import org.springframework.stereotype.Component;

@Component
public class RegistrationPaymentPage extends Page {

    public RegistrationPaymentPage() {
        urlPath = ApplicationPages.REGISTRATION_PERSONAL_PAYMENT.getField();
    }
}
