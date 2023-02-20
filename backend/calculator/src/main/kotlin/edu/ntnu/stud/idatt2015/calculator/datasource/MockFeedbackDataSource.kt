package edu.ntnu.stud.idatt2015.calculator.datasource

import edu.ntnu.stud.idatt2015.calculator.model.Feedback
import org.springframework.stereotype.Repository

interface MockFeedbackDataSource {

    fun createFeedback(feedback: Feedback): Feedback

    fun deleteFeedback(username: String)

    fun getStatus(status: Boolean)
}