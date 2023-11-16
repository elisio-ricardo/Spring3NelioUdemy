package com.spring3nelio.course.service.excption;

public class ResourceNotFoundExcption extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundExcption(Object id) {
        super("Resource not Found: " + id);
    }
}
