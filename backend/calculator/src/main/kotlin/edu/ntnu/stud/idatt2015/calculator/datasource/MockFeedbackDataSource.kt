package edu.ntnu.stud.idatt2015.calculator.datasource

import edu.ntnu.stud.idatt2015.calculator.model.Feedback
import org.springframework.stereotype.Repository

@Repository
class MockFeedbackDataSource : Feedback() {

    override fun getStatus(): Boolean {
        return super.getStatus()
    }
}