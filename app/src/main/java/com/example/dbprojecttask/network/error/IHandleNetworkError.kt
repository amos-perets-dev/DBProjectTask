package com.example.dbprojecttask.network.error

import androidx.annotation.StringRes

interface IHandleNetworkError {
    /**
     * Generate the error from the server
     */
    @StringRes fun generateErrorID(it: Throwable): Int
}