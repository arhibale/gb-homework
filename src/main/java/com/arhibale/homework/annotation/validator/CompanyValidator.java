package com.arhibale.homework.annotation.validator;

import com.arhibale.homework.annotation.Company;
import com.arhibale.homework.repository.impl.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CompanyValidator implements ConstraintValidator<Company, String> {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void initialize(Company constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String str, ConstraintValidatorContext ctx) {
        return companyRepository.findAll().contains(str);
    }
}