package com.cinema;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonCinema {
    private static final Gson gson = new Gson();

    // Método para escrever uma lista de objetos em um arquivo JSON
    public static <T> void escreverObjeto(List<T> list, String filePath) {
        // Carrega os dados existentes do arquivo, se houver
        List<T> dadosExistentes = lerObjeto(filePath, new TypeToken<List<T>>() {}.getType());

        // Se não houver dados existentes, cria uma nova lista
        if (dadosExistentes == null) {
            dadosExistentes = new ArrayList<>();
        }

        // Adiciona os novos dados à lista existente
        dadosExistentes.addAll(list);

        // Escreve a lista atualizada no arquivo
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(dadosExistentes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para ler uma lista de objetos de um arquivo JSON
    public static <T> List<T> lerObjeto(String filePath, Type type) {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
