
package com.pe.qds.rotarMatriz.enumeration;

import com.pe.qds.rotarMatriz.bean.Status;

public enum ErrorCodeEnum
{
    OK(ErrorContext.LOGIC, 0, "Ejecuci\u00f3n exitosa."), 
    MIMETYPE_INVALID(ErrorContext.LOGIC, 2, "El tipo de dato es inválido."),
    STORE_PROCEDURE(ErrorContext.LOGIC, 3, "Error inesperado."),
    FAIL(ErrorContext.LOGIC, 1000, "Error inesperado."),
    
    VALIDACION(ErrorContext.LOGIC, 4, ""),
    ;

    private ErrorContext context;
    private Status status;

    ErrorCodeEnum(ErrorContext context, Integer index, String message)
    {
        this.status = new Status(context.getCode(index), message);
        this.context = context;
    }

    public ErrorContext getContext()
    {
        return context;
    }

    public String getCode()
    {
        return this.status.getCode();
    }

    public String getMessage()
    {
        return this.status.getMessage();
    }

    public boolean isCode(String code)
    {
        return this.getCode().equals(code);
    }

    public Status status()
    {
        return this.status;
    }

}
