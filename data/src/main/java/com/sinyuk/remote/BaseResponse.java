package com.sinyuk.remote;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sinyuk on 2016/12/10.
 */
public class BaseResponse<T> {

    /**
     * error : Couldn't find Photo with 'id'=hh
     * status : 404
     */

    private T data;
    @SerializedName("error")
    private String error;
    @SerializedName("status")
    private int status;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
