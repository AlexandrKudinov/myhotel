package com.example.myHotel.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HotelServiceException extends RuntimeException {

    public HotelServiceException(String message) {
        super(message);
    }

    public HotelServiceException(Throwable cause) {
        super(cause);
    }

    public HotelServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public HotelServiceException(String message, Throwable cause, boolean enableSuppression,
                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
