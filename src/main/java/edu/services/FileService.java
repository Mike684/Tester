package edu.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.creator.QuizMaker;
import edu.models.tester.Quiz;
import org.json.JSONException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Mike on 24.04.2017.
 */
public class FileService {

    public Quiz readFromJSON(String jsonString) throws JSONException {
        Gson gson = new Gson();
        final Quiz quiz = gson.fromJson(jsonString, Quiz.class);
        return quiz;
    }

    public void writeToJSON(QuizMaker quiz) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(quiz);
        FileWriter writer = null;
        try {
            writer = new FileWriter("down/test.json");
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

    public Quiz readFromXML() {
        Quiz quiz = null;
        try {
            File file = new File("down/test.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Quiz.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            quiz = (Quiz) jaxbUnmarshaller.unmarshal(file);
            System.out.println(quiz);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return quiz;
    }

    public void writeToXML(QuizMaker quiz){
        try {
            File file = new File("down/test.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(QuizMaker.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(quiz, file);
            jaxbMarshaller.marshal(quiz, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


}
