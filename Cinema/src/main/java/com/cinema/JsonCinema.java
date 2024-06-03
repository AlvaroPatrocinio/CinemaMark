package com.cinema;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.ArrayList;

public class JsonCinema {
    private static final Gson gson = new Gson();

    public static <T> void escreverObjetoUnico(T objeto, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(objeto, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> void escreverObjeto(List<T> objetos, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(objetos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> lerObjeto(String filePath, Type type) {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
