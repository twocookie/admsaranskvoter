package com.simbirsoft.voter.voter.api.anticaptcha.response;

import com.simbirsoft.voter.voter.api.anticaptcha.helper.DebugHelper;
import com.simbirsoft.voter.voter.api.anticaptcha.helper.JsonHelper;
import org.json.JSONObject;

public class BalanceResponse {
    private Integer errorId;
    private String errorCode;
    private String errorDescription;
    private Double balance;

    public BalanceResponse(JSONObject json) {
        errorId = JsonHelper.extractInt(json, "errorId");

        if (errorId != null) {
            if (errorId.equals(0)) {
                balance = JsonHelper.extractDouble(json, "balance");
            } else {
                errorCode = JsonHelper.extractStr(json, "errorCode");
                errorDescription = JsonHelper.extractStr(json, "errorDescription");
            }
        }
        else
        {
            DebugHelper.out("Unknown error", DebugHelper.Type.ERROR);
        }
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorDescription() {
        return errorDescription == null ? "(no error description)" : errorDescription;
    }

    public Double getBalance() {
        return balance;
    }

    public Integer getErrorId() {
        return errorId;
    }
}
