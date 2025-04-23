package com.vmfvmf;

public class Main {
	enum Status { ACTIVE, INACTIVE, ERROR }

	public static void main(String[] args) {
		Object obj = "Hello";

		switch (obj) {
		    case String s -> System.out.println("String: " + s.toUpperCase());
		    case Integer i -> System.out.println("Integer + 1: " + (i + 1));
		    case null -> System.out.println("It's null!");
		    default -> System.out.println("Unknown type");
		}
		
		INotification n = new Email("support@example.com", "Welcome", "Hello!");
		System.out.println(switchSealedIterface(n));
		
		n = new SMS("1122334455", "Welcome");
		System.out.println(switchSealedIterface(n));
		
		Status status = Status.ACTIVE;
		System.out.println(switchEnum(status));
		
		status = Status.ACTIVE;
		System.out.println(switchEnum(status));
		
		status = Status.ACTIVE;
		System.out.println(switchEnum(status));
		
		status = Status.ERROR;
		System.out.println(switchEnum(status));
	}
	
	public static String switchSealedIterface(INotification n) {
		return switch (n) {
		    case Email e when e.subject().contains("Welcome") ->
		        "Send welcome pack to: " + e.from();
		    case Email e ->
		        "Archive email from: " + e.from();
		    case SMS s when s.message().contains("URGENT") ->
		        "High priority SMS to: " + s.number();
		    case SMS s ->
		        "Standard SMS to: " + s.number();
		};
	}
	
	public static String switchEnum(Status status) {
		boolean random = Math.random() > .5;
		return switch (status) {
		    case ACTIVE -> {
		    	if (random) yield "Randomly excited!";
		    	else yield "Just active.";
		    }
		    case INACTIVE, ERROR -> "Not working.";
		};
	}

}
