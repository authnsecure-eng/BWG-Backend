package com.pcmc.bwg.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Where and how to push survey data to the admin backend ("BWG backend" /
 * BWG.git) so it shows up in the Admin "Reports" screen. See
 * AdminBridgeClient. baseUrl and apiKey must be set per-environment - the
 * defaults below only work when both backends happen to run on the same
 * machine, which is not assumed to be true in production.
 */
@ConfigurationProperties(prefix = "app.admin-bridge")
public class AdminBridgeProperties {

    private boolean enabled = false;
    private String baseUrl = "http://localhost:8091";
    private String apiKey;
    private int connectTimeoutMs = 5000;
    private int readTimeoutMs = 5000;

    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    public String getBaseUrl() { return baseUrl; }
    public void setBaseUrl(String baseUrl) { this.baseUrl = baseUrl; }

    public String getApiKey() { return apiKey; }
    public void setApiKey(String apiKey) { this.apiKey = apiKey; }

    public int getConnectTimeoutMs() { return connectTimeoutMs; }
    public void setConnectTimeoutMs(int connectTimeoutMs) { this.connectTimeoutMs = connectTimeoutMs; }

    public int getReadTimeoutMs() { return readTimeoutMs; }
    public void setReadTimeoutMs(int readTimeoutMs) { this.readTimeoutMs = readTimeoutMs; }
}
