package com.ludaxord.projectsup.library.utilities;

import android.content.res.Resources;
import com.ludaxord.projectsup.R;

public class UtilsException extends Exception {
    public UtilsException() {
        super();
    }

    public UtilsException(String errorMessage) {
        super(errorMessage);
    }

    public UtilsException(String errorMessage, Throwable errorThrowable) {
        super(errorMessage, errorThrowable);
    }

    @Override
    public String getMessage() {
        return Resources.getSystem().getString(R.string.utils_exception_default_message);
    }
}
