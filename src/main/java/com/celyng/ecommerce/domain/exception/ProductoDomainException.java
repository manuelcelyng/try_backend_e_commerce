package com.celyng.ecommerce.domain.exception;

import com.celyng.ecommerce.domain.common.exception.DomainException;

public class  ProductoDomainException extends DomainException {

    public ProductoDomainException(String message) {
        super(message);
    }

    public ProductoDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
