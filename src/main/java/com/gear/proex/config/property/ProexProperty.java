package com.gear.proex.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@ConfigurationProperties("proex")
public class ProexProperty {
    private final SecurityProex security = new SecurityProex();
    public SecurityProex getSecurity() {
        return security;
    }
    public static class SecurityProex {
        private String[]  origins;
        private String  swaggerClientId;
        private String  swaggerclientSecret;
        private String  grantTypePassword;
        private String  grantTypeRefreshToken;
        private String  scopeRead;
        private String  scopeWrite;
        private String linkPassword;
        private String changePassword;

        private boolean enableHttps;

        public SecurityProex() {
        }

        public boolean isEnableHttps() {
            return enableHttps;
        }

        public String getSwaggerClientId() {
            return swaggerClientId;
        }

        public String getSwaggerclientSecret() {
            return swaggerclientSecret;
        }

        public String getGrantTypePassword() {
            return grantTypePassword;
        }

        public String getGrantTypeRefreshToken() {
            return grantTypeRefreshToken;
        }

        public String getScopeRead() {
            return scopeRead;
        }

        public String getScopeWrite() {
            return scopeWrite;
        }

        public String getLinkPassword() {
            return linkPassword;
        }

        public void setLinkPassword(String linkPassword) {
            this.linkPassword = linkPassword;
        }

        public String getChangePassword() {
            return changePassword;
        }

        public void setChangePassword(String changePassword) {
            this.changePassword = changePassword;
        }

        public void setEnableHttps(boolean enableHttps) {
            this.enableHttps = enableHttps;
        }
        public void setSwaggerClientId(String swaggerClientId) {
            this.swaggerClientId = swaggerClientId;
        }
        public void setSwaggerclientSecret(String swaggerclientSecret) {
            this.swaggerclientSecret = swaggerclientSecret;
        }
        public void setGrantTypePassword(String grantTypePassword) {
            this.grantTypePassword = grantTypePassword;
        }
        public void setGrantTypeRefreshToken(String grantTypeRefreshToken) {
            this.grantTypeRefreshToken = grantTypeRefreshToken;
        }
        public void setScopeRead(String scopeRead) {
            this.scopeRead = scopeRead;
        }
        public void setScopeWrite(String scopeWrite) {
            this.scopeWrite = scopeWrite;
        }

        public String[] getOrigins() {
            return origins;
        }

        public void setOrigins(String[] origins) {
            this.origins = origins;
        }
    }
}
