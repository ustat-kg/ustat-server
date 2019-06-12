package com.example.USTAT.service;

import com.example.USTAT.model.Request;

import java.util.List;

public interface RequestService {
    Request getRequestById(Long id);
    List<Request> getAllRequestsById(Long id);
    Request saveRequest(Request request);
    void deleteRequestById(Long id);
    void deleteAllRequests();
}
