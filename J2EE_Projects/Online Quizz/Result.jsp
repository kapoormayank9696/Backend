<!-- Result of Quizz -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Quiz Result</title>
        <style>
        body {
            background-color: lavender;
            font-family: Arial, Helvetica, sans-serif; 
        }
        .block {
            background: white;
            padding: 15px;
            margin-top: 10px;
            border-radius: 10px;
        }
        .correct {
            color: green;
            font-weight: bold;
        }
        .wrong {
            color: red;
            font-weight: bold;
        }
        .question {
            font-weight: bold;
            margin-bottom: 5px;
        }
        </style>
    </head>
    <body>
        <%
        String userName = (String) session.getAttribute("userName");
        String email = (String) session.getAttribute("email");
        String enrollno = (String) session.getAttribute("Enrollno");
        if(userName == null || email == null || enrollno == null){
            out.println("<h2>Session expired! Please login again.</h2>");
            return;
        }
        String url = "jdbc:mysql://localhost:3306/quizz";
        String dbuser = "root";
        String dbpass = "9689";
        int score = 0;
        int totalQuestions = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            out.println(e.getMessage());
        }
        try (Connection conn = DriverManager.getConnection(url, dbuser, dbpass)) {
            try (PreparedStatement check = conn.prepareStatement("SELECT * FROM quiz_results WHERE enrollno=?")) {
                    check.setString(1, enrollno);
                try (ResultSet rsCheck = check.executeQuery()) {
                    if(rsCheck.next()) {
                        %>
                        <div class="block">
                            <h2>You have already submitted the quiz.</h2>
                            <p>Your score: <%= rsCheck.getInt("score") %> / <%= rsCheck.getInt("total") %></p>
                        </div>
                        <%
                        return;
                    }
                }
            }
            try (Statement stmt = conn.createStatement();
                ResultSet rsQ = stmt.executeQuery("SELECT * FROM questions")) {
                while(rsQ.next()) {
                    int qid = rsQ.getInt("id");
                    String question = rsQ.getString("question");
                    totalQuestions++;
                    String userAnswer = request.getParameter("answer_" + qid);
                    int userOptionId = (userAnswer != null) ? Integer.parseInt(userAnswer) : -1;
                    String userText = "";
                    int correctId = -1;
                    String correctText = "";
                    try (PreparedStatement pst = conn.prepareStatement(
                        "SELECT id, option_text, correct_answer FROM options WHERE question_id=?")) {
                        pst.setInt(1, qid);
                        try (ResultSet rsOpt = pst.executeQuery()) {
                            while(rsOpt.next()) {
                                int optId = rsOpt.getInt("id");
                                String optText = rsOpt.getString("option_text");
                                int isCorrect = rsOpt.getInt("correct_answer");
                                if(isCorrect == 1) {
                                    correctId = optId;
                                    correctText = optText;
                                }
                                if(optId == userOptionId) {
                                    userText = optText;
                                }
                            }
                        }
                    }
                    %>
                    <div class="block">
                        <p class="question"><%= totalQuestions %>. <%= question %></p>
                        <% if(userOptionId == correctId){ %>
                        <p class="correct">✔ Correct — <%= userText %></p>
                        <% score++; %>
                        <% } else { %>
                            <p class="wrong">✘ Wrong — <%= (userText == null || userText.isEmpty() ? "No answer" : userText) %></p>
                            <p class="correct">Correct answer: <%= correctText %></p>
                        <% } %>
                        </div>
                        <%
                        }
                    }
                    try (PreparedStatement save = conn.prepareStatement(
                        "INSERT INTO quiz_results(username, email, enrollno, score, total) VALUES(?, ?, ?, ?, ?)")) {
                        save.setString(1, userName);
                        save.setString(2, email);
                        save.setString(3, enrollno);
                        save.setInt(4, score);
                        save.setInt(5, totalQuestions);
                        save.executeUpdate();
                    }
                    %>
                    <div class="block">
                        <h2>Your Final Score: <%= score %> / <%= totalQuestions %></h2>
                    </div>
                    <%
                    } catch(Exception e) {
                    out.println("Error: " + e.getMessage());
                }
            %>
        </body>
</html>
