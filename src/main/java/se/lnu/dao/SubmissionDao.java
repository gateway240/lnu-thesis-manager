package se.lnu.dao;

import se.lnu.entity.Submission;

import java.util.List;

public interface SubmissionDao {

    Submission saveSubmission(Submission submission);

    List<Submission> getAllSubmissions();
}
