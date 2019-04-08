package com.SciCal;

import javax.swing.*;


class InvalidEquationException extends Exception
{
    InvalidEquationException(String errorMessage)
    {
        JOptionPane.showMessageDialog(null, errorMessage, "Error!", JOptionPane.ERROR_MESSAGE);
    }
}
