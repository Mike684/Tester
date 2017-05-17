package edu.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.creator.QuizMaker;
import edu.models.tester.*;
import edu.models.users.UAnswer;
import edu.models.users.User;
import org.json.JSONException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.List;

/**
 * JSONService is a class for working with JSON files.
 * Created by Mike on 24.04.2017.
 */
public class JSONService {
    /**
     * Read quiz from JSON.
     * @param jsonString is a JSON string.
     * @return quiz.
     * @throws JSONException
     */
    public Quiz quizFromJSON(String jsonString) throws JSONException {
        Gson gson = new Gson();
        final Quiz quiz = gson.fromJson(jsonString, Quiz.class);
        return quiz;
    }

    /**
     * Read question from JSON.
     * @param jsonString is a JSON string.
     * @return question.
     * @throws JSONException
     */
    public Question questionFromJSON(String jsonString) throws JSONException {
        Gson gson = new Gson();
        final Question question = gson.fromJson(jsonString, Question.class);
        return question;
    }

    /**
     * Read option from JSON
     * @param jsonString is a JSON string.
     * @return option.
     * @throws JSONException
     */
    public Option optionnFromJSON(String jsonString) throws JSONException {
        Gson gson = new Gson();
        final Option option = gson.fromJson(jsonString, Option.class);
        return option;
    }

    /**
     * Read blank from JSON.
     * @param jsonString is a JSON string.
     * @return blank.
     * @throws JSONException
     */
    public Blank blankFromJSON(String jsonString) throws JSONException {
        Gson gson = new Gson();
        final Blank blank = gson.fromJson(jsonString, Blank.class);
        return blank;
    }

    /**
     * Read essay from JSON.
     * @param jsonString is a JSON string.
     * @return essay.
     * @throws JSONException
     */
    public Essay essayFromJSON(String jsonString) throws JSONException {
        Gson gson = new Gson();
        final Essay essay = gson.fromJson(jsonString, Essay.class);
        return essay;
    }

    /**
     * Read user from JSON.
     * @param jsonString is a JSON string.
     * @return user.
     * @throws JSONException
     */
    public User userFromJSON(String jsonString) throws JSONException {
        Gson gson = new Gson();
        final User user = gson.fromJson(jsonString, User.class);
        return user;
    }

    /**
     * Read user answers rom JSON.
     * @param jsonString is a JSON string.
     * @return user answers.
     * @throws JSONException
     */
    public UAnswer uAnswerFromJSON(String jsonString) throws JSONException {
        Gson gson = new Gson();
        final UAnswer uAnswer = gson.fromJson(jsonString, UAnswer.class);
        return uAnswer;
    }

    /**
     * Write object to JSON.
     * @param object is an input object.
     * @return JSON string.
     * @throws IOException
     */
    public String toJSON(Object object) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(object);
        return json;
    }

    /**
     * Write object to *.json file.
     * @param object is an input object.
     * @return JSON string.
     * @throws IOException
     */
    public String toJSONFile(Object object) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(object);
        try (FileWriter writer = new FileWriter("down/quizzes.json")) {

            gson.toJson(object, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
