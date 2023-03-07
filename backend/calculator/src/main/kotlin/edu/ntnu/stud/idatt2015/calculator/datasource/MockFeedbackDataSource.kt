package edu.ntnu.stud.idatt2015.calculator.datasource

interface MockFeedbackDataSource {

    fun createFeedback(feedback: Feedback): Feedback

    fun deleteFeedback(username: String)

    fun getStatus(status: Boolean)
}