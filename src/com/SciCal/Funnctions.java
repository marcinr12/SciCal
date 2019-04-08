package com.SciCal;

class Functions
{
    String fun;
    String funPrint;

    public Functions(String fun, String funPrint)
    {
        this.fun = fun;
        this.funPrint = funPrint;
    }

    @Override
    public String toString()
    {
        return this.fun;
    }

    public  String print()
    {
        return this.funPrint;
    }

    public void setFun (String fun)
    {
        this.fun = fun;
    }
}
