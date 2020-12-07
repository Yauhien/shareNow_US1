package com.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum  ApplicationPages {
    LANDING_PAGE("/"),
    REGISTRATION_PERSONAL_DATA("/registration/personal-data/"),
    REGISTRATION_PERSONAL_PAYMENT("/registration/payment"),
    COUNTRY_LIST("/country-list/");

    private final String field;
}
