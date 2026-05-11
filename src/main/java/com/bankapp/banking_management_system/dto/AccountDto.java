package com.bankapp.banking_management_system.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AccountDto {

    @NotBlank(message = "Account holder name is required")
    private String accountHolderName;

    @NotBlank(message = "Account number is required")
    private String accountNumber;

    @Min(value = 100, message = "Minimum balance should be 100")
    private Double balance;

    @NotBlank(message = "Account Type is required")
    private String accountType;
}
