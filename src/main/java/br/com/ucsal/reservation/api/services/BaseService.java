package br.com.ucsal.reservation.api.services;

import br.com.ucsal.reservation.api.BaseComponent;

public abstract class BaseService extends BaseComponent {
    protected void throwIfNull(Object obj, String message) throws Exception {
        if (obj == null)
            throw new NullPointerException(message);
    }

    protected void throwIfNull(Object obj) throws Exception {
        if (obj == null)
            throw new NullPointerException();
    }
}
