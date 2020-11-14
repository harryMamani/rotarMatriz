package com.pe.qds.rotarMatriz.exception;

public class MatrizException extends Exception{

	 
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private final String message;
	    public MatrizException(String message) {
	        super(message);
	        this.message = message;
	    }
	    public MatrizException(String message, Throwable cause) {
	        super(message, cause);
	        this.message = message;
	    }
		public String getMessage() {
			return message;
		}
	
}
