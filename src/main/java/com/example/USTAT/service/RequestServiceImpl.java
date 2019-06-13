package com.example.USTAT.service;

import com.example.USTAT.model.Request;
import com.example.USTAT.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;



    @Override
    public Request getRequestById(Long id) {
        return this.requestRepository.findById(id).get();
    }

//    @Override
//    public List<Request> getAllRequestsById(Long id) {
//        return this.requestRepository.findAllById(id);
//    }

    @Override
    public Request saveRequest(Request request) {
        return this.requestRepository.save(request);
    }

    @Override
    public void deleteRequestById(Long id) {
        this.requestRepository.deleteById(id);
    }

    @Override
    public void deleteAllRequests() {
        this.requestRepository.deleteAll();
    }
}
