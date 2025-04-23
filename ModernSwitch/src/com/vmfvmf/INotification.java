package com.vmfvmf;

public sealed interface INotification permits Email, SMS {}

record Email(String from, String subject, String body) implements INotification {}
record SMS(String number, String message) implements INotification {}
