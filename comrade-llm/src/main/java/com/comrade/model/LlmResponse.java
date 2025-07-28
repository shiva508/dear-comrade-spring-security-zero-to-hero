package com.comrade.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class LlmResponse implements Serializable {
    private String output;

    public LlmResponse() {
    }

    public LlmResponse(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public static class Builder{
        private String output;

        public Builder output(String output){
            this.output = output;
            return this;
        }

        public LlmResponse build(){
            return new LlmResponse(this.output);
        }
    }
    public static Builder builder(){
        return new Builder();
    }
}
