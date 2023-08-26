package com.example.qldt_vnpt.DataBaseHandler;

import org.json.JSONObject;

public interface ICallBack {
    void onResponse(JSONObject jsonObject);
    void onError(Throwable t);
}
