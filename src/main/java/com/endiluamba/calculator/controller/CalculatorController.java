package com.endiluamba.calculator.controller;

import com.endiluamba.calculator.calculator.SimpleCalculator;
import com.endiluamba.calculator.exception.DivisionByZeroException;
import com.endiluamba.calculator.exception.NegativeSquareRootException;
import com.endiluamba.calculator.exception.UnsupportedMathOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.endiluamba.calculator.converters.NumberConverter.convertToDouble;
import static com.endiluamba.calculator.converters.NumberConverter.isNumeric;

@RestController
public class CalculatorController {

    @Autowired
    private SimpleCalculator calc;

    @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return calc.sum(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value="/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return calc.subtraction(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value="/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return calc.multiplication(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value="/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        if (convertToDouble(numberTwo) == 0) {
            throw new DivisionByZeroException("The second number must not be equal to zero!");
        }
        return calc.division(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value="/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return calc.mean(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value="/squareroot/{number}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable("number") String number) throws Exception {
        if (!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        if (convertToDouble(number) < 0) {
            throw new NegativeSquareRootException("The number must be greater or equal to zero");
        }
        return calc.squareRoot(convertToDouble(number));
    }
}
