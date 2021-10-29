/*
 * Created by yuejz on 2021/09/14.
 * Copyright 2015－2021 Sensors Data Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sensorsdata.uniapp.sf;

import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.sensorsdata.sf.core.entity.SFCampaign;
import com.sensorsdata.sf.ui.listener.SensorsFocusCampaignListener;

import io.dcloud.feature.uniapp.bridge.UniJSCallback;

public class UniCampaignListener implements SensorsFocusCampaignListener {
    private static final String LOG_TAG = "SA.CampaignListener";

    public static UniJSCallback loadSuccessJSCallback;
    public static UniJSCallback closeJSCallback;
    public static UniJSCallback clickJSCallback;
    public static UniJSCallback loadFailedJSCallback;

    @Override
    public boolean campaignShouldStart(SFCampaign sfCampaign) {
        return true;
    }

    @Override
    public void onCampaignStart(SFCampaign sfCampaign) {
        if (loadSuccessJSCallback != null && sfCampaign != null) {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("planId", sfCampaign.getPlanId());
                jsonObject.put("type", sfCampaign.getType().toString().toLowerCase());
                jsonObject.put("content", sfCampaign.getContent());
                loadSuccessJSCallback.invokeAndKeepAlive(jsonObject);
            } catch (Exception e) {
                Log.i(LOG_TAG, e.getMessage());
            }
        }
    }

    @Override
    public void onCampaignEnd(SFCampaign sfCampaign) {
        if (closeJSCallback != null && sfCampaign != null) {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("planId", sfCampaign.getPlanId());
                jsonObject.put("type", sfCampaign.getType().toString().toLowerCase());
                jsonObject.put("content", sfCampaign.getContent());
                closeJSCallback.invokeAndKeepAlive(jsonObject);
            } catch (Exception e) {
                Log.i(LOG_TAG, e.getMessage());
            }
        }
    }

    @Override
    public void onCampaignFailed(SFCampaign sfCampaign, int errorCode, String errorMessage) {
        if (loadFailedJSCallback != null && sfCampaign != null) {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("planId", sfCampaign.getPlanId());
                jsonObject.put("code", errorCode);
                jsonObject.put("message", errorMessage);
                loadFailedJSCallback.invokeAndKeepAlive(jsonObject);
            } catch (Exception e) {
                Log.i(LOG_TAG, e.getMessage());
            }
        }
    }
}
