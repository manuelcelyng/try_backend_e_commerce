package com.celyng.ecommerce.domain.valueObject;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@Builder
public class Money {
    private final BigDecimal cantidad;

    public static final Money ZERO = new Money(BigDecimal.ZERO);

    public boolean isGreaterThanZero(){
        return this.cantidad != null && this.cantidad.compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean isGreaterThan(Money money){
        return this.cantidad != null && this.cantidad.compareTo(money.getCantidad()) > 0;
    }

    public Money add(Money money){
        return new Money(setScale(this.cantidad.add(money.getCantidad())));
    }

    public Money multiply(int multiplier){
        return new Money(setScale(this.cantidad.multiply(BigDecimal.valueOf(multiplier))));
    }

    public Money subtract(Money money){
        return new Money(setScale(this.cantidad.subtract(money.getCantidad())));
    }

    private  BigDecimal setScale(BigDecimal input) {
        return input.setScale(2, RoundingMode.HALF_EVEN);
    }

}
