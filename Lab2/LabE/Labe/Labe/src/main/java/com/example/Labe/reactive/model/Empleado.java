package com.example.Labe.reactive.model;

import org.springframework.data.annotation.Id;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Document
public class Empleado {

    @Id
    int id;

    String name;
    long salary;
}
