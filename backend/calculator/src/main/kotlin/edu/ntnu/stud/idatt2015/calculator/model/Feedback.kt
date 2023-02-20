package edu.ntnu.stud.idatt2015.calculator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

data class Feedback (
    @JsonProperty("username")
    val username: String,

    @JsonProperty("email")
    val email: String,

    @JsonProperty("message")
    val message: String,

    @JsonProperty("status")
    val status: Boolean
)
