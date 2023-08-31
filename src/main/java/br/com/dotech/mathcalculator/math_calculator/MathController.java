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
        ) throws Exception {
            if (!ifNumeric(number1) || !ifNumeric(number2)) {
                throw new UnsupportedMathOperationException("Please set a numeric value");
            }
            return convertToDouble(number1) + convertToDouble(number2);

        }
    @RequestMapping(value = "/sub/{numeroUm}/{numeroDois}",method = RequestMethod.GET)
    public double sub (
        @PathVariable(value = "numeroUm") String number1,
        @PathVariable(value = "numeroDois") String number2
        ) throws Exception{
            if (!ifNumeric(number1) || (!ifNumeric(number2))) {
                throw new UnsupportedMathOperationException("Please set a numeric value");
            }
            return convertToDouble(number1) - convertToDouble(number2);
    }
    @RequestMapping(value = "/mult/{numeroUm}/{numeroDois}")
    public double mult(
        @PathVariable(value = "numeroUm") String number1,
        @PathVariable(value = "numeroDois") String number2
    )throws Exception{
        if (!ifNumeric(number1) || (!ifNumeric(number2))) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(number1) * convertToDouble(number2);
    }
    @RequestMapping(value = "/div/{numeroUm}/{numeroDois}")
    public double div(
        @PathVariable(value = "numeroUm") String number1,
        @PathVariable(value = "numeroDois") String number2
    )throws Exception{
        if (!ifNumeric(number1) || (!ifNumeric(number2))) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(number1) / convertToDouble(number2);
    }
    @RequestMapping(value = "/med/{numeroUm}/{numeroDois}")
    public double med(
        @PathVariable(value = "numeroUm") String number1,
        @PathVariable(value = "numeroDois") String number2
    )throws Exception{
        if (!ifNumeric(number1) || (!ifNumeric(number2))) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return (convertToDouble(number1) * convertToDouble(number2))/2;
    }
    @RequestMapping(value = "/square/{numeroUm}")
    public double square(
        @PathVariable(value = "numeroUm") String number1
    )throws Exception{
        if (!ifNumeric(number1)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        double raiz = Math.sqrt(convertToDouble(number1));

        return raiz;
    }
    @RequestMapping(value = "/pow/{numeroUm}")
    public double pow(
        @PathVariable(value = "numeroUm") String number1
    )throws Exception{
        if (!ifNumeric(number1)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        double potencia = Math.pow(convertToDouble(number1),2);

        return potencia;
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
