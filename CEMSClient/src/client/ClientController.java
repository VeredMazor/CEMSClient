package client;

import java.io.IOException;
import java.util.ArrayList;

import common.ActiveTest;
import common.FinishedTest;
import common.Question;
import common.ScheduledTest;
import common.Test;
import common.User;

public class ClientController {

	private static CEMSClient client;
	private static String roleFrame = null;
	private static boolean  questionAdded;
	private static boolean testDeleted;
	private static boolean questionDeleted;
	private static boolean questionEdited;
	private static boolean testScheduled;
	private static String newQuestionId;
	private static ArrayList<Question> questions = null;
	private static ArrayList<Test> tests = null;
	private static ArrayList<ScheduledTest> scheduledTests = null;
	private static ArrayList<ActiveTest> activeTests;
	private static ArrayList<FinishedTest> finishedTests = null;

	public ClientController(String host, int port) {
		client = new CEMSClient(host, port, this);
	}

	/**
	 * UI request to server format: REQUEST_NAME-arg0,arg1,arg2
	 * 
	 * @param str
	 */
	public static void accept(String str) {
		try {
			client.handleMessageFromClientUI(str);
		} catch (Exception e) {
			try {
				client.closeConnection();
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static String getRoleFrame() {
		return roleFrame;
	}

	public static void setRoleFrame(String roleFrame) {
		ClientController.roleFrame = roleFrame;
	}

	public static User getActiveUser() {
		return client.getActiveUser();
	}
	
	public static boolean isTestScheduled() {
		return testScheduled;
	}

	public static void setTestScheduled(boolean testScheduled) {
		ClientController.testScheduled = testScheduled;
	}
	
	public static boolean isTestDeleted() {
		return testDeleted;
	}

	public static void setTestDeleted(boolean testDeleted) {
		ClientController.testDeleted = testDeleted;
	}
	
	public static boolean isQuestionDeleted() {
		return questionDeleted;
	}

	public static void setQuestionDeleted(boolean questionDeleted) {
		ClientController.questionDeleted = questionDeleted;
	}
	
	
	public static boolean isQuestionEdited() {
		return questionEdited;
	}

	public static void setQuestionEdited(boolean questionEdited) {
		ClientController.questionEdited = questionEdited;
	}
	public static void setQuestionAdded(boolean questionAdded) {
		ClientController.questionAdded= questionAdded;
	}
	public static boolean isQuestionAdded() {
		return questionAdded;
	}
	public static String getNewQuestionId() {
		return newQuestionId;
	}

	public static void setNewQuestionId(String newQuestionId) {
		ClientController.newQuestionId = newQuestionId;
	}


	public static ArrayList<Question> getQuestions() {
		return questions;
	}

	public static void setQuestions(ArrayList<Question> questions) {
		ClientController.questions = questions;
	}

	public static ArrayList<Test> getTests() {
		return tests;
	}

	public static void setTests(ArrayList<Test> tests) {
		ClientController.tests = tests;
	}

	public static ArrayList<ScheduledTest> getScheduledTests() {
		return scheduledTests;
	}

	public static void setScheduledTests(ArrayList<ScheduledTest> scheduledTests) {
		ClientController.scheduledTests = scheduledTests;
	}

	public static void setActiveTests(ArrayList<ActiveTest> activeTest){
		
		ClientController.activeTests = activeTest;	
	}
	
	public static ArrayList<ActiveTest> getActiveTests() {
		return activeTests;
	}

	public static ArrayList<FinishedTest> getFinishedTests() {
		return finishedTests;
	}
	
	public static void setFinishedTests(ArrayList<FinishedTest> finishedTests) {
		ClientController.finishedTests = finishedTests;
	}

	
}
