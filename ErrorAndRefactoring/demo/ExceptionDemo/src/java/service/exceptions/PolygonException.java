/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.exceptions;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk
 */
public class PolygonException extends Exception {

    /**
     * Creates a new instance of <code>PolygonException</code> without detail
     * message.
     */
    public PolygonException() {
    }

    /**
     * Constructs an instance of <code>PolygonException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PolygonException(String msg) {
        super(msg);
    }
}
