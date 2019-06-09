package com.practice.flatten;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ESMessageContent {
    //  private static final Logger LOG = LoggerFactory.getLogger( ESMessageContent.class );
    @JsonProperty("id")
    private String Id;
    @JsonProperty("xrequestId")
  private  String xRequestId;
    private String callbackurl;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    private String body;
    private int retriedCount;
    private String xConsumerCustomId;
    private String method;
     private Map<String, List<String>> headers;
    private int maxRetry;
    private long retryTimeInterval;
    private boolean isExpired;
    private long initialTimeStamp;
    private long timeForNextRetry;
    private boolean isRetried;

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    public ESMessageContent() {
    }

    public String getxRequestId() {
        return xRequestId;
    }

    public void setxRequestId(String xRequestId) {
        this.xRequestId = xRequestId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

//    public String getXRequestId() {
//        return XRequestId;
//    }
//
//    public void setXRequestId(String XRequestId) {
//        this.XRequestId = XRequestId;
//    }

    public String getCallbackurl() {
        return callbackurl;
    }

    public void setCallbackurl(String callbackurl) {
        this.callbackurl = callbackurl;
    }

//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }

    public int getRetriedCount() {
        return retriedCount;
    }

    public void setRetriedCount(int retriedCount) {
        this.retriedCount = retriedCount;
    }

    public String getxConsumerCustomId() {
        return xConsumerCustomId;
    }

    public void setxConsumerCustomId(String xConsumerCustomId) {
        this.xConsumerCustomId = xConsumerCustomId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }



    public int getMaxRetry() {
        return maxRetry;
    }

    public void setMaxRetry(int maxRetry) {
        this.maxRetry = maxRetry;
    }

    public long getRetryTimeInterval() {
        return retryTimeInterval;
    }

    public void setRetryTimeInterval(long retryTimeInterval) {
        this.retryTimeInterval = retryTimeInterval;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public long getInitialTimeStamp() {
        return initialTimeStamp;
    }

    public void setInitialTimeStamp(long initialTimeStamp) {
        this.initialTimeStamp = initialTimeStamp;
    }

    public long getTimeForNextRetry() {
        return timeForNextRetry;
    }

    public void setTimeForNextRetry(long timeForNextRetry) {
        this.timeForNextRetry = timeForNextRetry;
    }

    public boolean isRetried() {
        return isRetried;
    }

    public void setRetried(boolean retried) {
        isRetried = retried;
    }


}


