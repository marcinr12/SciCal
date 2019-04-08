package com.SciCal;
import org.mariuszgromada.math.mxparser.*;

class Calculate
{
    static Double calc(String equation) throws InvalidEquationException
    {
        Expression expression = new Expression(equation);
        Double result;
        if (expression.checkSyntax())
        {
            result = expression.calculate();
        }
        else
        {
            String errorMessage = expression.getErrorMessage();
            throw new InvalidEquationException(errorMessage);
        }
        return result;
    }

}


