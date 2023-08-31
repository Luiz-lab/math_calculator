package br.com.dotech.mathcalculator.math_calculator;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    private static final double OD = 0;
    private static  AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
    public double sum (
        @PathVariable(value = "numeroUm")String number1,
        @PathVariable (value = "numeroDois")String number2
        ) {
            if (!ifNumeric(number1) || !ifNumeric(number2)) {
                return 0D;
            }
            return convertToDouble(number1) + convertToDouble(number2);

        }
        

    private boolean ifNumeric(String strNumber) {
        if (strNumber == null) {
            return false ;
        }
        return strNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    private Double convertToDouble(String strNumber){
        if (strNumber == null) {
            return 0D;
        }
        String number = strNumber.replaceAll(",", ".");
        if (ifNumeric(number)) {
            return Double.parseDouble(number);
        }
        return 50D;

    }
}
